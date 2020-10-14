package org.servlet;

import Dao.ShopvDaoimpl;
import entity.shopv;
import sqlreq.UserInfo;
import sqlreq.user;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "AddshopServlet",urlPatterns = "/addshopv")
public class AddshopServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       user uin=(user) request.getSession().getAttribute("Userinfo");
        ShopvDaoimpl si=new ShopvDaoimpl();
        shopv sv=new shopv();
        int commdtype_id=-1;
        int commdcount_count=-1;
        if(request.getParameter("commdtype")!=null && request.getParameter("commdcount")!=null){
            commdtype_id=Integer.parseInt(request.getParameter("commdtype"));
            commdcount_count=Integer.parseInt(request.getParameter("commdcount"));
        }
            sv.setCommType_id(commdtype_id);
        sv.setCount(commdcount_count);
        sv.setUser_id(uin.get_id());
        PrintWriter out=response.getWriter();
        int num=si.addshopv(sv);
        out.println("\"code\":"+num);
    }
}
