package com.yangteng.api.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import com.yangteng.api.comm.ApiRest;
import com.yangteng.api.entity.StoreProduct;
import com.yangteng.api.service.IStoreProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/product")
@SaCheckLogin
@RestController
public class ProductController {
    @Autowired
    private IStoreProductService storeProductService;

    @RequestMapping("/{id}")
    public ApiRest byId(@PathVariable Long id){
        final StoreProduct storeProduct = storeProductService.getById(id);
        return ApiRest.ok(storeProduct);
    }


}
