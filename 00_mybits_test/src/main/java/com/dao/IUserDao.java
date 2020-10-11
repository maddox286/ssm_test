package com.dao;

import com.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IUserDao {
    /**
     * 查找用户
     * @return
     */
    List<User> findAll();

    /**
     * 保存用户
     * @param user
     */
    void saveUser(User user);

    /**
     * 更新用户
     * @param user
     */
    void updateUser(User user);

    /**
     * 删除用户
     * @param userId
     */
    void deleteUser(Integer userId);

    /**
     * 根据id查询用户
     * @param userId
     */
    User findById(Integer userId);

    /**
     * 根据名字查找用户信息
     * @param username
     * @return
     */
    List<User> findByName(String username);

    /**
     * 查找用户记录
     * @return
     */
    int findTotal();
}
