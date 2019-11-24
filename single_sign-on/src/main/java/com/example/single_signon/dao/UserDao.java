package com.example.single_signon.dao;

import com.example.single_signon.bean.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户dao
 *
 * @author nightwalker
 */
@Mapper
public interface UserDao {
    /**
     * 查询用户实体信息
     *
     * @param user 用户实体
     * @return 用户信息
     */
    User queryUser(User user);
}
