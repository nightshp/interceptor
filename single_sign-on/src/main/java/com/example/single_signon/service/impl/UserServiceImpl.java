package com.example.single_signon.service.impl;

import com.example.single_signon.bean.User;
import com.example.single_signon.dao.UserDao;
import com.example.single_signon.service.UserService;
import com.example.single_signon.util.MemoryData;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用户service实现类
 *
 * @author nightwalker
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User queryUser(User user) {
        User user1 = userDao.queryUser(user);
        return user1;
    }

    @Override
    public void checkUser(HttpServletRequest request, HttpServletResponse response, User user) {
        User userInfo = userDao.queryUser(user);
        request.getSession().setAttribute("user", userInfo);
        String sessionId = request.getRequestedSessionId();
        String key = userInfo.getuName();
        // map不存在该key则放入否则先移除再放入新的值
        if (!MemoryData.getSessionIdMap().containsKey(key)) {
            MemoryData.getSessionIdMap().put(key, sessionId);
        } else if (MemoryData.getSessionIdMap().containsKey(key) && !StringUtils.equals(MemoryData.getSessionIdMap().get(key), sessionId)) {
            MemoryData.getSessionIdMap().remove(key);
            MemoryData.getSessionIdMap().put(key, sessionId);
        }
    }
}
