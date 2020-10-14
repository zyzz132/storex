package org.servlet;

import Dao.ShopvDaoimpl;
import com.alibaba.fastjson.JSON;
import entity.shopv;
import sqlreq.user;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.List;

@WebServlet(name = "HeadershoppingServlet",urlPatterns = "/Headershop")
public class HeadershoppingServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        user uin= (user) request.getSession().getAttribute("Userinfo");
        ShopvDaoimpl si=new ShopvDaoimpl();
        List<shopv> list=si.getshopvById(uin.get_id());
        //request.setAttribute("shopv",list);
        PrintWriter out=response.getWriter();
        out.println(JSON.toJSONString(list));
    }
}
