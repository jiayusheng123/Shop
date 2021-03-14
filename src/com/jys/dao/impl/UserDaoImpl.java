package com.jys.dao.impl;

import com.jys.dao.IUserDao;
import com.jys.entity.User;
import com.jys.utils.DbUtil;
import com.jys.utils.Md5Util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jiayusheng
 * @version 1.0
 * @since 1.0
 */
public class UserDaoImpl extends DbUtil<User> implements IUserDao {
    @Override
    public int add(User user) {
        int count;
        String sql = "insert into t_user(name,password,sex,phone,email,is_admin) values(?,?,?,?,?,?)";
        Object[] params = {user.getName(), Md5Util.getMd5(user.getPassword()),user.getSex(),user.getPhone(),user.getEmail(),user.getIsAdmin()};
        count = DbUtil.executeUpdate(sql,params);
        return count;
    }

    @Override
    public int update(User user) {
        int count ;
        String sql = "update t_user set name=?,password=?,sex=?,phone=?,email=?,is_admin=? where uid = ?";
        Object[] params = {user.getName(), Md5Util.getMd5(user.getPassword()),user.getSex(),user.getPhone(),user.getEmail(),user.getIsAdmin(),user.getUid()};
        count = DbUtil.executeUpdate(sql,params);
        return count;
    }

    @Override
    public int delete(Integer id) {
        int count ;
        String sql = "delete from t_user where uid = ?";
        Object[] params = {id};
        count = DbUtil.executeUpdate(sql,params);
        return count;
    }

    @Override
    public User getUserById(Integer id) {
        String sql = "select * from t_user where uid = ?";
        Object[] params = {id};
        List<User> list = executeQuery(sql,User.class,params);
        if(list!=null){
            return list.get(0);
        }
        return null;
    }

    @Override
    public List<User> getUserList() {
        String sql = "SELECT uid,NAME,PASSWORD,email,CASE WHEN sex='1' THEN '男' ELSE '女' " +
                "END AS sex,phone,CASE WHEN is_admin='1' THEN '是' ELSE '否' " +
                " END AS is_admin FROM t_user;";
        return executeQuery(sql,User.class,null);
    }

    @Override
    public boolean isExist(Integer id) {
        return getUserById(id) != null;
    }

    @Override
    public int getTotalCount() {
        String sql = "select count(1) from t_user";
        return DbUtil.getTotalCount(sql);
    }

    @Override
    public List<User> queryUserByPage(int currentPage, int pageSize) {
        String sql = "SELECT uid,NAME,PASSWORD,email,CASE WHEN sex='1' THEN '男' ELSE '女' " +
                "END AS sex,phone,CASE WHEN is_admin='1' THEN '是' ELSE '否' " +
                " END AS is_admin FROM t_user order by uid limit ?,?";
        Object[] params = {currentPage*pageSize,pageSize};
        return executeQuery(sql,User.class,params);
    }


}
