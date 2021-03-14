package com.jys.utils;


import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**德鲁伊数据库连接池获取数据库连接以及关闭资源
 * @author jiayusheng
 * @version 1.0
 * @since 1.0
 */
public class DbUtil<T> {
    private static DataSource dataSource;
    public static Connection connection;
    public static PreparedStatement ps;
    public static ResultSet rs;

    static {
        Properties ps = new Properties();
        try {
            ps.load(DbUtil.class.getClassLoader().getResourceAsStream("druid.properties"));
            dataSource = DruidDataSourceFactory.createDataSource(ps);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获得数据库连接对象
     * @return 连接对象
     */
    public static Connection getConnection(){
        try {
            return dataSource.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    /**
     * 获取PreparedStatement对象
     * @param sql sql语句
     * @param params Object数组
     * @return PreparedStatement对象
     * @throws SQLException sql异常
     */
    public static PreparedStatement creatPreparedStatement(String sql,Object[] params) throws SQLException {
        connection = getConnection();
        assert connection != null;
        ps = connection.prepareStatement(sql);
        //排除空指针异常
        if(params!=null){
            for(int i=0;i<params.length;i++){
                ps.setObject(i+1,params[i]);
            }
        }
        return ps;
    }

    /**
     * 通用增删改
     * @param sql sql语句
     * @param params Object数组
     * @return 如果增删改成功返回1 否则返回0或者-1
     */
    public static int executeUpdate(String sql,Object[] params) {
        int count;
        try {
            count = creatPreparedStatement(sql,params).executeUpdate();
            return count;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return -1;
        }finally {
            close(ps,connection);
        }
    }

    /**
     * 通用查询
     * @param sql sql语句
     * @param cls user类型反射对象
     * @param params Object数组
     * @return 将结果集存储到list集合中
     */
    public List<T> executeQuery(String sql, Class<T> cls,Object[] params){
        List<T> list = new ArrayList<>();
        //拿到当前类的所有字段对象
        Field[] fields = cls.getDeclaredFields();
        try {
            rs = creatPreparedStatement(sql,params).executeQuery();
            while(rs.next()){
                //创建一个对象
                T ins = cls.newInstance();
                //遍历所有的字段(属性)
                for(Field field:fields){
                    //授权操作
                    field.setAccessible(true);
                    //拿到字段名称
                    String fieldName = field.getName();
                    //拿到数据
                    Object value;
                    //如果字段名称不一样 则捕获异常
                    try {
                        value = rs.getObject(fieldName);
                    } catch (SQLException throwables) {
                        System.out.println(fieldName+"---未找到");
                        Properties properties = new Properties();
                        try {
                            properties.load(DbUtil.class.getClassLoader().getResourceAsStream("user.properties"));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        String columnName = properties.getProperty(fieldName);
                        value = rs.getObject(columnName);
                    }
                    //给ins对象赋值该字段值
                    field.set(ins,value);
                }
                list.add(ins);
            }
        } catch (IllegalAccessException | InstantiationException | SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            close(rs,ps,connection);
        }
        return list;
    }

    /**
     * 查询数据总数
     * @param sql sql语句
     * @return 数据总数
     */
    public static int getTotalCount(String sql){
        int count = -1;
        try {
            rs=creatPreparedStatement(sql,null).executeQuery();
            if(rs.next()){
                count = rs.getInt(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            close(rs,ps,connection);
        }
        return count;
    }

    /**
     * 关闭资源
     */
    public static void close(ResultSet rs, Statement st, Connection c){
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
        }
        if(st!=null){
            try {
                st.close();
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
        }
        if(c!=null){
            try {
                c.close();
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
        }
    }

    public static void close(Statement st,Connection c){
        close(null,st,c);
    }
    public static void close(Connection c){
        close(null,c);
    }
}
