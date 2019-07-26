package com.dxb.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dxb.mybatisplus.entity.User;
import com.dxb.mybatisplus.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisplusApplicationTests {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(new QueryWrapper<User>().gt("age", 20));
        userList.forEach(System.out::println);
        System.out.println(("----- selectAll method test ------"));
        userList = userMapper.selectList(new QueryWrapper<User>().ge("age", 20));
        userList.forEach(System.out::println);
        System.out.println(("----- selectAll method test ------"));
        userList = userMapper.selectList(new QueryWrapper<User>().ge(false, "age", 20));
        userList.forEach(System.out::println);
    }

    @Test
    public void testAdd() {
        User user = new User();
        user.setAge(11);
        user.setEmail("xxxxx@ss.com");
        user.setName("xxx");
        userMapper.insert(user);
        System.out.println(user);
    }

    @Test
    public void testPage() {
        Page page = new Page();
        page.setSize(2);
        page.setCurrent(3);
        userMapper.selectPage(page, new QueryWrapper<User>().gt("age", 11).orderByDesc("age"));
        page.getRecords().forEach(System.out::println);
        System.out.println(page.getTotal());
    }

}
