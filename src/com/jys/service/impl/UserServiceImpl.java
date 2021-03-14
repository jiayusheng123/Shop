package com.jys.service.impl;

import com.jys.dao.IUserDao;
import com.jys.dao.impl.UserDaoImpl;
import com.jys.entity.Page;
import com.jys.entity.User;
import com.jys.service.IUserService;

import java.util.List;

/**
 * @author jiayusheng
 * @version 1.0
 * @since 1.0
 */
public class UserServiceImpl implements IUserService {
    IUserDao userDao = new UserDaoImpl();
    @Override
    public int add(User user) {
        return userDao.add(user);
    }

    @Override
    public int update(User user) {
        return userDao.update(user);
    }

    @Override
    public int delete(Integer id) {
        return userDao.delete(id);
    }

    @Override
    public User getUserById(Integer id) {
        return userDao.getUserById(id);
    }

    @Override
    public List<User> getUserList() {
        return userDao.getUserList();
    }

    @Override
    public void getPage(Page page) {
        int count = userDao.getTotalCount();
        page.setTotalCount(count);
        page.getTotalPage();
        List<User> list = userDao.queryUserByPage(page.getCurrentPage(), page.getPageSize());
        page.setList(list);
    }


}
