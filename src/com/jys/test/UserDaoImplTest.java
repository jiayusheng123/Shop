package com.jys.test;

import com.jys.dao.IGoodsTypeDao;
import com.jys.dao.IUserDao;
import com.jys.dao.impl.GoodsTypeImpl;
import com.jys.dao.impl.UserDaoImpl;
import com.jys.entity.GoodsType;
import com.jys.entity.User;
import com.jys.service.IUserService;
import com.jys.service.impl.UserServiceImpl;

/**
 * @author jiayusheng
 * @version 1.0
 * @since 1.0
 */
public class UserDaoImplTest {
    public static void test(){
        IGoodsTypeDao iGoodsTypeDao = new GoodsTypeImpl();
        GoodsType goodsType = new GoodsType();
        goodsType.setGtype_name("水果");
        goodsType.setGtype_parentid(0);
        int count = iGoodsTypeDao.getTotalCount();
        System.out.println(count);

    }

    public static void main(String[] args) {
        test();
    }
}
