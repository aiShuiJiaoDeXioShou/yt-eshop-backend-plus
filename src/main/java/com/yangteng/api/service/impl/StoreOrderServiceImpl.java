package com.yangteng.api.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yangteng.api.entity.StoreOrder;
import com.yangteng.api.mapper.StoreOrderMapper;
import com.yangteng.api.service.IStoreOrderService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单表 服务实现类
 * </p>
 *
 * @author 林河
 * @since 2022-08-23
 */
@Service
public class StoreOrderServiceImpl extends ServiceImpl<StoreOrderMapper, StoreOrder> implements IStoreOrderService {

}
