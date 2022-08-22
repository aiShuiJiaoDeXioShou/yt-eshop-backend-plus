package com.yangteng.api.controller;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.crypto.digest.DigestUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.yangteng.api.comm.ApiRest;
import com.yangteng.api.entity.EshopUser;
import com.yangteng.api.entity.User;
import com.yangteng.api.service.IEshopUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IEshopUserService userService;

    // 用户注册
    @PostMapping
    public ApiRest register(@RequestBody EshopUser user) {
        user.setPassword(DigestUtil.md5Hex(user.getPassword().getBytes()));
        final boolean save = userService.save(user);
        if (!save) return ApiRest.fail("用户注册失败！");
        return ApiRest.ok();
    }

    // 用户登录功能
    @PutMapping
    public ApiRest login(@RequestBody User user) {
        // 验证用户名密码
        final EshopUser one = userService.getOne(Wrappers.<EshopUser>lambdaQuery()
                .eq(EshopUser::getPassword, DigestUtil.md5Hex(user.getPassword()))
                .eq(EshopUser::getUsername, user.getUsername())
        );
        if (one == null) return ApiRest.fail("登录失败!");
        StpUtil.login(one.getUid());
        return ApiRest.ok();
    }

    // 退出登录
    @RequestMapping
    public ApiRest logout() {
        StpUtil.logout();
        return ApiRest.ok();
    }
}
