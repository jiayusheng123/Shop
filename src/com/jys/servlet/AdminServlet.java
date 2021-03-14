package com.jys.servlet;

import com.jys.entity.Admin;
import com.jys.service.IAdminService;
import com.jys.service.impl.AdminDaoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigInteger;

/**
 * @author jiayusheng
 * @version 1.0
 * @since 1.0
 */
@WebServlet(value = "/AdminServlet")
public class AdminServlet extends HttpServlet {
    IAdminService adminService = new AdminDaoServiceImpl();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=UTF-8");
        String action = request.getParameter("action");
        if("login".equals(action)){
            String phone = request.getParameter("name");
            String password = request.getParameter("password");
            String password2 = adminService.getPasswordByPhone(phone);
            int count = -1;
            if(password2!=null&&password2.equals(password)){
                count = 1;
            }
            responseClient(response,count);
        }else if("register".equals(action)){
            String phone = request.getParameter("username");
            String password1 = request.getParameter("password");
            String password2 = request.getParameter("passwordRepeat");
            if(password1 != null && password1.equals(password2) &&
                    phone.length()==11){
                response.getWriter().write("<script>alert('注册成功');location.href ='login.jsp'</script>");
                Admin admin = new Admin(phone,password1);
                adminService.addAdmin(admin);
            }else {
                response.getWriter().write("<script>alert('注册失败,请重新注册(密码不一致或者手机号不为11位)');location.href ='register.jsp'</script>");
            }
        }

    }
    private void responseClient(HttpServletResponse response, int count) throws IOException {
        if(count > 0){
            response.sendRedirect("back/main.jsp");
        }else {
            response.getWriter().write("<script>alert('登录失败');location.href ='login.jsp'</script>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
