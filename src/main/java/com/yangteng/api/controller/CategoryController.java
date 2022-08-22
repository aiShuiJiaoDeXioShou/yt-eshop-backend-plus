package com.yangteng.api.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.yangteng.api.comm.ApiRest;
import com.yangteng.api.entity.StoreCategory;
import com.yangteng.api.entity.StoreProduct;
import com.yangteng.api.service.IStoreCategoryService;
import com.yangteng.api.service.IStoreProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/category")
@RestController
public class CategoryController {

    @Autowired
    private IStoreCategoryService categoryService;

    @Autowired
    private IStoreProductService productService;

    /**
     * 查找所有父类
     */
    @RequestMapping("/list")
    public ApiRest list() {
        final List<StoreCategory> list = categoryService.list(
                Wrappers.<StoreCategory>lambdaQuery().
                        eq(StoreCategory::getPid, 0)
        );
        return ApiRest.ok(list);
    }

    /**
     * 查找指定父类的子类别
     */
    @RequestMapping("/{id}")
    public ApiRest byId(@PathVariable Long id) {
        final List<StoreCategory> list = categoryService.list(
                Wrappers.<StoreCategory>lambdaQuery()
                        .eq(StoreCategory::getPid, id)
        );
        return ApiRest.ok(list);
    }

    /**
     * 根据分类查找该分类的商品信息
     */
    @RequestMapping("/product/{id}")
    public ApiRest byCategoryId(@PathVariable Long id) {
        final List<StoreProduct> list = productService.list(
                Wrappers.<StoreProduct>lambdaQuery()
                        .eq(StoreProduct::getCateId,id)
        );

        return ApiRest.ok(list);
    }
}
