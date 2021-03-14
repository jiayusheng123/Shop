package com.jys.service;

import com.jys.entity.Page;
import com.jys.entity.User;

import java.util.List;

/**
 * @author jiayusheng
 * @version 1.0
 * @since 1.0
 */
public interface IUserService {
    /**
     * 增加用户信息
     * @param user 用户对象
     * @return 增加成功返回1 否则返回0
     */
    public int add(User user);

    /**
     * 更新用户信息
     * @param user 用户对象
     * @return 更新成功返回1 否则返回0
     */
    public int update(User user);

    /**
     * 删除用户信息
     * @param id 用户id
     * @return 删除成功返回1,否则返回0
     */
    public int delete(Integer id);

    /**
     * 通过id查询用户信息
     * @param id 用户id
     * @return 用户对象
     */
    public User getUserById(Integer id);

    /**
     * 查询所有用户
     * @return 查询结果储存在list中
     */
    public List<User> getUserList();

    /**
     * 实现page对象
     * @param page 传入的page对象
     */
    public void getPage(Page page);

}
