package com.example.single_signon.service;

import com.example.single_signon.bean.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface UserService {
    /**
     * 查询用户实体信息
     *
     * @param user 用户实体
     * @return 用户信息
     */
    User queryUser(User user);

    /**
     * 校验登录用户
     *
     * @param request  请求
     * @param response 响应
     * @param user     用户实体
     */
    void checkUser(HttpServletRequest request, HttpServletResponse response, User user);
}
