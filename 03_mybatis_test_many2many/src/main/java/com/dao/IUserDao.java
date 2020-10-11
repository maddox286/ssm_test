package com.dao;

import com.domain.User;

import java.util.List;

public interface IUserDao {
    /**
     * 查找用户
     * @return
     */
    List<User> findAll();

    /**
     * 根据id查询用户
     * @param userId
     */
    User findById(Integer userId);

}
