package com.jys.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5加密实用类
 * @author jiayusheng
 * @version 1.0
 * @since 1.0
 */
public class Md5Util {
    /**
     * 对原始密码进行加密
     * @param password
     * @return
     */
    public static String getMd5(String password){
        String newPassword = "";
        try {
            //生成一个MD5加密计算摘要
            MessageDigest md = MessageDigest.getInstance("MD5");
            //计算md5函数
            md.update(password.getBytes());
            //digest方法最后确定返回md5 hash值 返回值为8长度的字符串.
            //BigInteger函数则将8位的字符串转换成16为hex值，用字符串表示,得到字符串形式的hash值
            newPassword = new BigInteger(1,md.digest()).toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return newPassword;
    }
}
