package com.dxb.mybatisplus.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dxb.mybatisplus.entity.User;
import com.dxb.mybatisplus.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author dxb
 * @since 2019-07-26
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("/users")
    @ResponseBody
    public IPage getUsers(int current) {
        Page page = new Page();
        page.setSize(2);
        page.setCurrent(current);
        return userService.page(page, new QueryWrapper<User>().gt("age", 11).orderByDesc("age"));
    }
}
