package com.jys.entity;

import java.util.List;

/**
 * @author jiayusheng
 * @version 1.0
 * @since 1.0
 */
public class Page {
    /**
     * 在page中就将当前页面和每页数量值给定
     * 当前页
     */
    private Integer currentPage =0 ;
    /**
     * 每页数量
     */
    private Integer pageSize =3;
    /**
     * 总条数
     */
    private Integer totalCount;
    /**
     * 总页数
     */
    private Integer totalPage;

    /**
     * 当前页数据
     */
    private List<?> list;

    /**
     * 访问路径
     */
    private String url1;

    public  Page() {
    }

    public Page(Integer currentPage, Integer pageSize, Integer totalCount, Integer totalPage) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
        this.totalPage = totalPage;
    }

    public String getUrl1() {
        return url1;
    }

    public void setUrl1(String url1) {
        this.url1 = url1;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalCount() {
        return totalCount;
    }


    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }
    /**
     * 在得到总页数中设置总页数的值
     * 总页数 = 总数据个数%页面大小==0？总数据个数/页面大小:总数据个数/页面大小+1
     * 当使用了总数据个数的set和页面大小的set后自动生成页面个数
     */
    public Integer getTotalPage() {
        this.totalPage = this.totalCount%this.pageSize==0?this.totalCount/this.pageSize:this.totalCount/this.pageSize+1;
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public List<?> getList() {
        return list;
    }

    public void setList(List<?> list) {
        this.list = list;
    }
}
