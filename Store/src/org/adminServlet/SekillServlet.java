package org.adminServlet;

import Dao.SeckillDao;
import com.alibaba.fastjson.JSON;
import entity.Seckill;
import entity.Seckill_time;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/admin/SekillServlet")
public class SekillServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out= response.getWriter();
        SeckillDao sekildao=new SeckillDao();
        String type=request.getParameter("type");
        String Spage=request.getParameter("page");
        String brand_name=request.getParameter("suo");
        int page=1;
        int limit=10;
        int count=0;
        if(Spage!=null){
            page=Integer.parseInt(Spage);
        }
        String Slimit=request.getParameter("limit");
        if(Slimit!=null){
            limit=Integer.parseInt(Slimit);
        }
        String dataJSON="";
        if(type.equals("seckill")){
            List<Seckill> seckillList=sekildao.getSeckills(page,limit);
            dataJSON=JSON.toJSONString(seckillList);
            count=sekildao.getSeckillsCount();
        }else if(type.equals("seckillTime")){
            List<Seckill_time> seckill_timeList=sekildao.getSeckill_times_Select(1,page,limit);
            dataJSON=JSON.toJSONString(seckill_timeList);
            count=sekildao.getSeckill_Count();
        }

        StringBuffer sb=new StringBuffer("{\"code\":0,\"msg\":\"\",\"count\":"+count+",\"data\":");
        sb.append(dataJSON);
        sb.append("}");
        out.println(sb.toString());
    }
}
