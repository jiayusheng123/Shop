package com.jys.service.impl;

import com.jys.dao.IAdminDao;
import com.jys.dao.impl.AdminDaoImpl;
import com.jys.entity.Admin;
import com.jys.service.IAdminService;

/**
 * @author jiayusheng
 * @version 1.0
 * @since 1.0
 */
public class AdminDaoServiceImpl implements IAdminService {
    IAdminDao adminDao = new AdminDaoImpl();
    @Override
    public String getPasswordByPhone(String phone) {
        return adminDao.getPasswordByPhone(phone);
    }

    @Override
    public int addAdmin(Admin admin) {
        return adminDao.addAdmin(admin);
    }
}
