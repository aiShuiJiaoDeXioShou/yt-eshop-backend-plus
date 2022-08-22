package com.yangteng.api.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yangteng.api.entity.StoreCategory;
import com.yangteng.api.mapper.StoreCategoryMapper;
import com.yangteng.api.service.IStoreCategoryService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品分类表 服务实现类
 * </p>
 *
 * @author 林河
 * @since 2022-08-23
 */
@Service
public class StoreCategoryServiceImpl extends ServiceImpl<StoreCategoryMapper, StoreCategory> implements IStoreCategoryService {

}
