package com.dxb.mybatisplus.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dxb.mybatisplus.entity.User;
import com.dxb.mybatisplus.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author dxb
 * @since 2019-07-26
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("/users")
    public IPage getUsers(@RequestParam(required = false, defaultValue = "0") int current) {
        Page page = new Page(current, 2);
        return userService.page(page, new QueryWrapper<User>().gt("age", 0).orderByDesc("age"));
    }

    @GetMapping("/set")
    public List<User> getUsers() {
        User user = new User();
        user.setAge(new Random().nextInt(100));
        user.setEmail("ds1@ss.com");
        user.setName("ds1");
        userService.save(user);
        User user2 = new User();
        user2.setAge(new Random().nextInt(100));
        user2.setEmail("ds2@ss.com");
        user2.setName("ds2");
        userService.save(user2);
        List<User> list = new ArrayList<>();
        list.add(user);
        list.add(user2);
        return list;
    }

}
