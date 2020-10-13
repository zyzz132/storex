package org.adminServlet;

import Dao.CommodiyDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DelCommd",urlPatterns = "/admin/DelCommd")
public class DelCommdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        CommodiyDao commdDao=new CommodiyDao();
        if(request.getParameter("id")!=null){
            out.println("{\"code\":"+commdDao.DelCommd(Integer.parseInt(request.getParameter("id")))+"}");
        }else{
            out.println("{\"code\":0}");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
