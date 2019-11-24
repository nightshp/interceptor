package com.example.single_signon.controller;

import com.example.single_signon.bean.User;
import com.example.single_signon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用户Controller
 *
 * @author nightwalker
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 查询用户谢谢
     *
     * @param user 用户实体
     * @return 用户信息
     */
    @RequestMapping("/query")
    @ResponseBody
    public User queryUser(@RequestBody User user) {
        return userService.queryUser(user);
    }

    /**
     * 校验登录用户
     *
     * @param request  请求
     * @param response 响应
     */
    @RequestMapping("/checkUser")
    public void checkUser(HttpServletRequest request, HttpServletResponse response, @RequestBody User user) {
        userService.checkUser(request, response, user);
    }
}
