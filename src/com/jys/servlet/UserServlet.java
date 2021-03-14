package com.jys.servlet;

import com.jys.entity.Page;
import com.jys.entity.User;
import com.jys.service.IUserService;
import com.jys.service.impl.UserServiceImpl;

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
@WebServlet(value = "/UserServlet")
public class UserServlet extends HttpServlet {
    IUserService iUserService = new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=UTF-8");
        String action = request.getParameter("action");
        if("findUserList".equals(action)){
            Page page = new Page();
            String currentPage = request.getParameter("currentPage");
            if(!"".equals(currentPage)&&currentPage!=null){
                page.setCurrentPage(Integer.parseInt(currentPage));
           }
            iUserService.getPage(page);
            page.setUrl1("UserServlet?action=findUserList");
            request.setAttribute("page",page);
            request.getRequestDispatcher("back/user/userinfo.jsp").forward(request,response);
        }
        else if("addUser".equals(action)){
            //抽出方法
            User user = setUserProperty(request);

            int count = iUserService.add(user);

            responseClient(response, count);
        }else if("findUserById".equals(action)){
            Integer uid = Integer.parseInt(request.getParameter("uid"));
            User user = iUserService.getUserById(uid);
            request.setAttribute("user",user);
            request.getRequestDispatcher("back/user/updateuser.jsp").forward(request,response);

        }else if("updateUser".equals(action)){
            User user = setUserProperty(request);
            int count = iUserService.update(user);
            System.out.println(user);
            responseClient(response,count);
        }else if("deleteUser".equals(action)){
            Integer id = Integer.parseInt(request.getParameter("uid"));
            responseClient(response, iUserService.delete(id));
        }
    }

    private void responseClient(HttpServletResponse response, int count) throws IOException {
        if(count > 0){
            response.sendRedirect("back/main.jsp");
        }else {
            response.getWriter().write("<script>alert('登录失败');location.href ='login.jsp'</script>");
        }
    }

    private User setUserProperty(HttpServletRequest request) {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String sex = request.getParameter("sex");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String isAdmin = request.getParameter("isAdmin");
        String uid = request.getParameter("uid");
        User user = new User();
        //避免出异常 增加的时候没有id
        if(!"".equals(uid)){
            user.setUid(3);
        }
        user.setName(name);
        user.setPassword(password);
        user.setSex(sex);
        user.setPhone(phone);
        user.setEmail(email);
        user.setIsAdmin(isAdmin);
        return user;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
