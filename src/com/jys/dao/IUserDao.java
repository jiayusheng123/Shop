package com.jys.dao;

import com.jys.entity.User;

import java.util.List;

/**
 * @author jiayusheng
 * @version 1.0
 * @since 1.0
 */
public interface IUserDao {
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
     * 根据id判断用户是否存在
     * @param id id值
     * @return 存在返回true 不存在返回false;
     */
    public boolean isExist(Integer id);

    /**
     * 查询数据总数
     * @return 返回数据总数
     */
    public int getTotalCount();

    /**
     * 获通过当前页和页面大小获得用户集合
     * @param currentPage 当前页面
     * @param pageSize 页面大小
     * @return 用户集合
     */
    public List<User> queryUserByPage(int currentPage,int pageSize);



}
