package org.servlet;

import Dao.ShopvDaoimpl;
import Util.ShopvUtil;
import entity.shopv;
import sqlreq.user;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/Shopv")
public class ShopvServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String Storepath=request.getScheme() + "://"+request.getServerName()+":"+request.getServerPort()+ request.getContextPath()+"/";
        user userinfo=(user)request.getSession().getAttribute("Userinfo");

        request.getRequestDispatcher("/Commodity/Shopv.jsp").forward(request,response);
    }
}
