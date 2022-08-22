package com.yangteng.api.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.lang.UUID;
import com.yangteng.api.comm.ApiRest;
import com.yangteng.api.entity.EshopUser;
import com.yangteng.api.entity.UserRecharge;
import com.yangteng.api.service.IEshopUserService;
import com.yangteng.api.service.IUserRechargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;

@RequestMapping("/recharge")
@SaCheckLogin
@RestController
public class RechargeController {
    @Autowired
    private IUserRechargeService rechargeService;

    @Autowired
    private IEshopUserService userService;

    @PostMapping
    public ApiRest addRecharge(@RequestBody UserRecharge userRecharge) {
        // 保存充值信息
        final long uid = StpUtil.getLoginIdAsLong();
        final EshopUser user = userService.getById(uid);
        userRecharge.setUid(uid)
                .setOrderId(UUID.randomUUID().toString())
                .setNickname(user.getNickname())
                .setCreateTime(LocalDateTime.now())
                .setRechargeType("weixin");
        final boolean save = rechargeService.save(userRecharge);

        // 更新用户余额
        user.setNowMoney(user.getNowMoney()
                .add(userRecharge.getPrice())
                .add(userRecharge.getGivePrice())
        );

        final boolean b = userService.updateById(user);
        userRecharge.setPaid(b);
        return save ? ApiRest.ok() : ApiRest.fail();
    }

    /**
     * 用户消费
     */
    @DeleteMapping
    public ApiRest deleteRecharge(@RequestBody HashMap<String, Object> params) {
        final BigDecimal balance = (BigDecimal)params.get("balance");
        // 更新用户余额
        final EshopUser user = userService.getById(StpUtil.getLoginIdAsLong());
        user.setNowMoney(
                user.getNowMoney().subtract(balance)
        );
        final boolean b = userService.updateById(user);
        return b?ApiRest.ok("用户支付成功"):ApiRest.fail("用户支付失败");
    }
}
