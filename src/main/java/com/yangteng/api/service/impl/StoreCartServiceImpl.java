package com.yangteng.api.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yangteng.api.entity.StoreCart;
import com.yangteng.api.mapper.StoreCartMapper;
import com.yangteng.api.service.IStoreCartService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 购物车表 服务实现类
 * </p>
 *
 * @author 林河
 * @since 2022-08-23
 */
@Service
public class StoreCartServiceImpl extends ServiceImpl<StoreCartMapper, StoreCart> implements IStoreCartService {

}
