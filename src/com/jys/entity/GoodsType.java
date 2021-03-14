package com.jys.entity;

/**
 * @author jiayusheng
 * @version 1.0
 * @since 1.0
 */
public class GoodsType {
    private int gid;
    private String gtype_name;
    private String gtype_pic;
    private int gtype_parentid;

    public GoodsType() {
    }

    public GoodsType(int gid, String gtype_name, String gtype_pic, int gtype_parentid) {
        this.gid = gid;
        this.gtype_name = gtype_name;
        this.gtype_pic = gtype_pic;
        this.gtype_parentid = gtype_parentid;
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public String getGtype_name() {
        return gtype_name;
    }

    public void setGtype_name(String gtype_name) {
        this.gtype_name = gtype_name;
    }

    public String getGtype_pic() {
        return gtype_pic;
    }

    public void setGtype_pic(String gtype_pic) {
        this.gtype_pic = gtype_pic;
    }

    public int getGtype_parentid() {
        return gtype_parentid;
    }

    public void setGtype_parentid(int gtype_parentid) {
        this.gtype_parentid = gtype_parentid;
    }

    @Override
    public String toString() {
        return "GoodsType{" +
                "gid=" + gid +
                ", gtype_name='" + gtype_name + '\'' +
                ", gtype_pic='" + gtype_pic + '\'' +
                ", gtype_parentid=" + gtype_parentid +
                '}';
    }
}
