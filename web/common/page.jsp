<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<a href="${page.url1}&currentPage=0">首页</a>
<c:if test="${page.currentPage>0}">
    <a href="${page.url1}&currentPage=${page.currentPage-1}">上一页</a>
</c:if>
<c:if test="${page.currentPage<page.totalPage-1}">
    <a href="${page.url1}&currentPage=${page.currentPage+1}">下一页</a>
</c:if>
<a href="${page.url1}&currentPage=${page.totalPage-1}">尾页</a>