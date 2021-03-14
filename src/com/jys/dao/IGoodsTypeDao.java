package com.jys.dao;


import com.jys.entity.GoodsType;

import java.util.List;

/**
 * @author jiayusheng
 * @version 1.0
 * @since 1.0
 */
public interface IGoodsTypeDao {
    /**
     * 增加商品类型信息
     * @param goodsType 商品类型对象
     * @return 增加成功返回1 否则返回0
     */
    public int add(GoodsType goodsType);

    /**
     * 更新商品类型信息
     * @param goodsType 商品类型对象
     * @return 更新成功返回1 否则返回0
     */
    public int update(GoodsType goodsType);

    /**
     * 删除商品类型信息
     * @param id 商品类型id
     * @return 删除成功返回1,否则返回0
     */
    public int delete(Integer id);

    /**
     * 通过id查询商品类型信息
     * @param id 商品类型id
     * @return 商品类型对象
     */
    public GoodsType getGoodsTypeById(Integer id);

    /**
     * 查询所有商品类型
     * @return 查询结果储存在list中
     */
    public List<GoodsType> getGoodsTypeList();

    /**
     * 根据id判断商品类型是否存在
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
     * 获通过当前页和页面大小获得商品类型集合
     * @param currentPage 当前页面
     * @param pageSize 页面大小
     * @return 商品类型集合
     */
    public List<GoodsType> queryGoodsTypeByPage(int currentPage,int pageSize);
    /**
     * 获得所有商品种类的父类
     * @return 将结果存储在list容器中
     */
    public List<GoodsType> finParentGoodType();
}
