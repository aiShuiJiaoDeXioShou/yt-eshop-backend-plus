package com.yangteng.api.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yangteng.api.entity.EshopUser;
import com.yangteng.api.mapper.EshopUserMapper;
import com.yangteng.api.service.IEshopUserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author 林河
 * @since 2022-08-23
 */
@Service
public class EshopUserServiceImpl extends ServiceImpl<EshopUserMapper, EshopUser> implements IEshopUserService {

}
