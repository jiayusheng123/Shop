package com.jys.service;

import com.jys.entity.Admin;

/**
 * @author jiayusheng
 * @version 1.0
 * @since 1.0
 */
public interface IAdminService {
    /**
     * 通过手机号获取密码
     * @param phone 手机号
     * @return 密码
     */
    public String getPasswordByPhone(String phone);
    /**
     * 增加管理员
     * @param admin 管理员对象
     * @return 添加成功返回1,添加失败返回0
     */
    public int addAdmin(Admin admin);
}
