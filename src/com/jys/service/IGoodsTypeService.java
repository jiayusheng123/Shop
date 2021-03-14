package com.jys.service;

import com.jys.entity.Page;
import com.jys.entity.GoodsType;

import java.util.List;

/**
 * @author jiayusheng
 * @version 1.0
 * @since 1.0
 */
public interface IGoodsTypeService {
    /**
     * 增加用户信息
     * @param goodstype 用户对象
     * @return 增加成功返回1 否则返回0
     */
    public int add(GoodsType goodstype);

    /**
     * 更新用户信息
     * @param goodstype 用户对象
     * @return 更新成功返回1 否则返回0
     */
    public int update(GoodsType goodstype);

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
    public GoodsType getGoodsTypeById(Integer id);

    /**
     * 查询所有用户
     * @return 查询结果储存在list中
     */
    public List<GoodsType> getGoodsTypeList();

    /**
     * 实现page对象
     * @param page 传入的page对象
     */
    public void getPage(Page page);

    /**
     * 获得所有商品种类的父类
     * @return 将结果存储在list容器中
     */
    public List<GoodsType> finParentGoodType();
}
