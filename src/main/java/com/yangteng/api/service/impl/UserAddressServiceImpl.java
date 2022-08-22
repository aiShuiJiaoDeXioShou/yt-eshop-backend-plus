package com.yangteng.api.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yangteng.api.entity.UserAddress;
import com.yangteng.api.mapper.UserAddressMapper;
import com.yangteng.api.service.IUserAddressService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户地址表 服务实现类
 * </p>
 *
 * @author 林河
 * @since 2022-08-23
 */
@Service
public class UserAddressServiceImpl extends ServiceImpl<UserAddressMapper, UserAddress> implements IUserAddressService {

}
