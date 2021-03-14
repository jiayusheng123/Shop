package com.jys.servlet;

import com.google.gson.Gson;
import com.jys.entity.GoodsType;
import com.jys.entity.Page;
import com.jys.entity.User;
import com.jys.service.IGoodsTypeService;
import com.jys.service.impl.GoodsTypeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author jiayusheng
 * @version 1.0
 * @since 1.0
 */
@WebServlet(value = "/GoodsTypeServlet")
public class GoodsTypeServlet extends HttpServlet {
    IGoodsTypeService iGoodsTypeService = new GoodsTypeServiceImpl();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if("findGoodsTypeList".equals(action)){
            Page page = new Page();
            String currentPage = request.getParameter("currentPage");
            if(currentPage!=null&&!"".equals(currentPage)){
                page.setCurrentPage(Integer.parseInt(currentPage));
            }
            iGoodsTypeService.getPage(page);
            page.setUrl1("GoodsTypeServlet?action=findGoodsTypeList");
            request.setAttribute("page",page);
            request.getRequestDispatcher("back/goodstype/goodstype.jsp").forward(request,response);
        }else if("findParentGoodsType".equals(action)){
            request.setCharacterEncoding("utf-8");
            response.setContentType("text/html; charset=utf-8");
            response.setCharacterEncoding("utf-8");
            List<GoodsType> list = iGoodsTypeService.finParentGoodType();
            //将对象转换成json字符串
            String json = new Gson().toJson(list);
            //写出json
            response.getWriter().write(json);
        }else if("addGoodsType".equals(action)){
            String name = (request.getParameter("name"));
            int gtype_parentid = Integer.parseInt(request.getParameter("parentId"));
            GoodsType goodsType = new GoodsType();
            goodsType.setGtype_name(name);
            goodsType.setGtype_parentid(gtype_parentid);
            int count = iGoodsTypeService.add(goodsType);
            if(count > 0){
                response.sendRedirect("GoodsTypeServlet?action=findGoodsTypeList");
            }else {
                response.getWriter().write("<script>alert('添加失败');location.href ='GoodsTypeServlet?action=findGoodsTypeList'</script>");
            }
        }else if("findGoodsTypeById".equals(action)){
            Integer gid = Integer.parseInt(request.getParameter("gid"));
            GoodsType goodsType = iGoodsTypeService.getGoodsTypeById(gid);
            request.setAttribute("goodsType",goodsType);
            request.getRequestDispatcher("back/goodstype/goodstypeupdate.jsp").forward(request,response);

        }else if("updateGoodsType".equals(action)){
            String name = (request.getParameter("name"));
            int gid = Integer.parseInt(request.getParameter("gid"));
            String gtype_parentid = request.getParameter("parentId");
            GoodsType goodsType = new GoodsType();
            goodsType.setGid(gid);
            goodsType.setGtype_name(name);
            goodsType.setGid(gid);
            int count = iGoodsTypeService.update(goodsType);
            if(count > 0){
                response.sendRedirect("GoodsTypeServlet?action=findGoodsTypeList");
            }else {
                response.getWriter().write("<script>alert('添加失败');location.href ='GoodsTypeServlet?action=findGoodsTypeList'</script>");
            }
        }else if("deleteGoodsType".equals(action)){
            Integer id = Integer.parseInt(request.getParameter("gid"));
           int count = iGoodsTypeService.delete(id);
            if(count > 0){
                response.sendRedirect("GoodsTypeServlet?action=findGoodsTypeById");
            }else {
                response.getWriter().write("<script>alert('添加失败');location.href ='GoodsTypeServlet?action=findGoodsTypeById'</script>");
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
