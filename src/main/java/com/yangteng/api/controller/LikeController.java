package com.yangteng.api.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.yangteng.api.comm.ApiRest;
import com.yangteng.api.entity.StoreProductRelation;
import com.yangteng.api.service.IStoreProductRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 喜欢，收藏，足迹，首页喜欢列表
 */
@RequestMapping("/like")
@RestController
public class LikeController {
    @Autowired
    private IStoreProductRelationService productRelationService;

    /**
     * 添加一位用户的收藏或者足迹
     */
    @PostMapping
    public ApiRest addLike(@RequestBody StoreProductRelation productRelation) {
        // 添加uid
        final boolean save = productRelationService.save(productRelation.setUid(StpUtil.getLoginIdAsLong()));
        return save ? ApiRest.ok() : ApiRest.fail();
    }

    /**
     * 删除足迹或者收藏
     */
    @DeleteMapping("/{id}")
    @SaCheckLogin
    public ApiRest deleteLike(@PathVariable Long id) {
        return productRelationService.removeById(id) ? ApiRest.ok() : ApiRest.fail();
    }

    /**
     * 获取指定用户所有的足迹或者收藏
     */
    @GetMapping("/{select}")
    @SaCheckLogin
    public ApiRest getLike(@PathVariable Integer select) {
        if (select != -1) {
            ApiRest.ok(productRelationService.list(Wrappers.<StoreProductRelation>lambdaQuery()
                    .eq(StoreProductRelation::getUid, StpUtil.getLoginIdAsLong())
                    .eq(StoreProductRelation::getType, select == 1 ? "foot" : "collect")
            ));
        }
        return ApiRest.ok(productRelationService.list(Wrappers.<StoreProductRelation>lambdaQuery()
                .eq(StoreProductRelation::getUid, StpUtil.getLoginIdAsLong())
        ));
    }
}
