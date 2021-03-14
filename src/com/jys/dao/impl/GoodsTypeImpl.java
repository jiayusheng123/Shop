package com.jys.dao.impl;

import com.jys.dao.IGoodsTypeDao;
import com.jys.entity.GoodsType;
import com.jys.utils.DbUtil;

import java.util.List;

/**
 * @author jiayusheng
 * @version 1.0
 * @since 1.0
 */
public class GoodsTypeImpl extends DbUtil<GoodsType> implements IGoodsTypeDao {
    @Override
    public int add(GoodsType goodsType) {
        String sql = "insert into t_goods_type(gtype_name,gtype_parentid) values(?,?)";
        Object[] params = {goodsType.getGtype_name(),goodsType.getGtype_parentid()};
        return DbUtil.executeUpdate(sql,params);
    }

    @Override
    public int update(GoodsType goodsType) {
        String sql = "update t_goods_type set gtype_name=?,gtype_parentid=? where gid = ?";
        Object[] params = {goodsType.getGtype_name(),goodsType.getGtype_parentid(),goodsType.getGid()};
        return DbUtil.executeUpdate(sql,params);
    }

    @Override
    public int delete(Integer id) {
        String sql = "delete from t_goods_type where gid = ?";
        Object[] params = {id};
        return DbUtil.executeUpdate(sql,params);
    }

    @Override
    public GoodsType getGoodsTypeById(Integer id) {
        String sql = "select * from t_goods_type where gid = ?";
        Object[] params = {id};
        List<GoodsType> list = executeQuery(sql,GoodsType.class,params);
        if(list!=null){
            return list.get(0);
        }else {
            return null;
        }

    }

    @Override
    public List<GoodsType> getGoodsTypeList() {
        return null;
    }

    @Override
    public boolean isExist(Integer id) {
        return false;
    }

    @Override
    public int getTotalCount() {
        String sql = "select count(1) from t_goods_type";
        return DbUtil.getTotalCount(sql);
    }

    @Override
    public List<GoodsType> queryGoodsTypeByPage(int currentPage, int pageSize) {
        String sql = "select * from t_goods_type order by gid limit ?,?";
        Object[] params = {currentPage*pageSize,pageSize};
        return executeQuery(sql,GoodsType.class,params);
    }

    @Override
    public List<GoodsType> finParentGoodType() {
        String sql = "select * from t_goods_type where gtype_parentid = 0";
        List<GoodsType> list = executeQuery(sql,GoodsType.class,null);
        return list;
    }
}
