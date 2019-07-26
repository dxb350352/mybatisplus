package com.dxb.mybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dxb.mybatisplus.entity.User;
import com.dxb.mybatisplus.mapper.UserMapper;
import com.dxb.mybatisplus.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author dxb
 * @since 2019-07-26
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
