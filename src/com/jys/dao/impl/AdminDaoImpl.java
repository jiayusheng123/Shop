package com.jys.dao.impl;

import com.jys.dao.IAdminDao;
import com.jys.entity.Admin;
import com.jys.entity.User;
import com.jys.utils.DbUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author jiayusheng
 * @version 1.0
 * @since 1.0
 */
public class AdminDaoImpl extends DbUtil<User>  implements IAdminDao {
    @Override
    public String getPasswordByPhone(String phone) {
        String sql = "select password from t_admin where phone = ?";
        Object[] params = {phone};
        String password = null;
        try {
            ResultSet rs = creatPreparedStatement(sql,params).executeQuery();
            if(rs.next()){
                password = rs.getString("password");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return password;
    }

    @Override
    public int addAdmin(Admin admin) {
        String sql = "insert into  t_admin(phone,password) values(?,?)";
        Object[] params = {admin.getPhone(),admin.getPassword()};
        return executeUpdate(sql,params);
    }
}
