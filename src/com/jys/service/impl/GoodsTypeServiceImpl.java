package com.jys.service.impl;

import com.jys.dao.IGoodsTypeDao;
import com.jys.dao.impl.GoodsTypeImpl;
import com.jys.entity.GoodsType;
import com.jys.entity.Page;
import com.jys.service.IGoodsTypeService;
import com.jys.service.IUserService;

import java.util.List;

/**
 * @author jiayusheng
 * @version 1.0
 * @since 1.0
 */
public class GoodsTypeServiceImpl implements IGoodsTypeService {
    IGoodsTypeDao iGoodsTypeDao = new GoodsTypeImpl();
    @Override
    public int add(GoodsType goodstype) {
        return iGoodsTypeDao.add(goodstype);
    }

    @Override
    public int update(GoodsType goodstype) {
        return iGoodsTypeDao.update(goodstype);
    }

    @Override
    public int delete(Integer id) {
        return iGoodsTypeDao.delete(id);
    }

    @Override
    public GoodsType getGoodsTypeById(Integer id) {
        return iGoodsTypeDao.getGoodsTypeById(id);
    }

    @Override
    public List<GoodsType> getGoodsTypeList() {
        return null;
    }

    @Override
    public void getPage(Page page) {
        int count = iGoodsTypeDao.getTotalCount();
        page.setTotalCount(count);
        page.getTotalPage();
        List<GoodsType> list = iGoodsTypeDao.queryGoodsTypeByPage(page.getCurrentPage(),page.getPageSize());
        page.setList(list);
    }

    @Override
    public List<GoodsType> finParentGoodType() {
        return iGoodsTypeDao.finParentGoodType();
    }
}
