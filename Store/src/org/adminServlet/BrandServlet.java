package org.adminServlet;

import com.alibaba.fastjson.JSON;
import entity.Brand;
import serice.BrandSerice;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/admin/brand")
public class BrandServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        String Storepath=request.getScheme() + "://"+request.getServerName()+":"+request.getServerPort()+ request.getContextPath()+"/";
        request.setAttribute("path",Storepath);
        PrintWriter out=resp.getWriter();
        String Spage=request.getParameter("page");
        String brand_name=request.getParameter("brand_name");
        int page=1;
        int limit=10;
        if(Spage!=null){
            page=Integer.parseInt(Spage);
        }
        String Slimit=request.getParameter("limit");
        if(Slimit!=null){
            limit=Integer.parseInt(Slimit);
        }
        BrandSerice bs=new BrandSerice();
        List<Brand> list=bs.getBrandInfo(brand_name,page,limit);
        StringBuffer sb=new StringBuffer("[");
        for(int i=0;i<list.size();i++){
            sb.append(JSON.toJSONString(list.get(i)));

        }
        sb.append("]"+bs.getBrandInfoCount(null));
        System.out.println(bs.getBrandInfoCount(null));
        out.println(sb.toString());



        //request.getRequestDispatcher("BrandList.jsp").forward(request,resp);

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
