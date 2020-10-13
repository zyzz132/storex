package org.adminServlet;

import Dao.CommodiyDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "UpCommdStatcServlet",urlPatterns = "/admin/UpCommdStatic")
public class UpCommdStatcServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        String type=request.getParameter("type");

        if(type!=null && request.getParameter("value")!=null && request.getParameter("id")!=null){
            int id=Integer.parseInt(request.getParameter("id"));
            int value=Integer.parseInt(request.getParameter("value"));
            CommodiyDao commdDao=new CommodiyDao();

            out.println("{\"code\":"+commdDao.upstatic(id,type,value)+"}");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
