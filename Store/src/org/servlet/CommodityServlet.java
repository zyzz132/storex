package org.servlet;

import Dao.CommodiyDao;
import entity.Commodity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Commod")
public class CommodityServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String Storepath=request.getScheme() + "://"+request.getServerName()+":"+request.getServerPort()+ request.getContextPath()+"/";
        String CommdID=request.getParameter("Commd_id");
        int Commd_id=-1;
        if(CommdID!=null){
            Commd_id=Integer.parseInt(CommdID);
        }
        CommodiyDao commdDao=new CommodiyDao();
        Commodity commd= commdDao.getID_Commodiy(Commd_id);
        request.setAttribute("commd",commd);
        request.setAttribute("path",Storepath);
        request.getRequestDispatcher("/Commodity/Commdoity.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);


    }
}
