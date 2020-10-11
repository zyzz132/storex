package Dao;

import Impl.SeckillK;
import Impl.Seckill_commodityK;
import Impl.Seckill_timeK;
import entity.Seckill;
import entity.Seckill_commodity;
import entity.Seckill_time;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SeckillDao extends BaseDao implements SeckillK, Seckill_timeK, Seckill_commodityK {
    //添加秒杀活动
    public int AddSeckill(Seckill sl) {
        String sql = "insert into seckill(`Name`,OpenDate,StopDate,isopen) values(?,?,?,?)";
        Object[] objs = new Object[]{sl.getName(),sl.getOpenDate(),sl.getStopDate(),sl.getIsopen()};
        return update(sql,objs);
    }

    //删除秒杀活动
    public int delSeckill(int id) {
        String sql = "DELETE FROM seckill WHERE id=?";
        Object[] objs = new Object[]{id};
        return update(sql,objs);
    }

    //查询秒杀活动
    public List<Seckill> getSeckills(int page,int limit) {
        List<Seckill> list = new ArrayList<Seckill>();
        Connection conn = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM seckill LIMIT ?,?";

        try {
            ps = conn.prepareStatement(sql);
            if(page==1){
                ps.setInt(1, page-1);
            }else{
                ps.setInt(1, (page-1)*limit);
            }
            ps.setInt(2,limit);
            rs = ps.executeQuery();
            while (rs.next()){
                Seckill seckill = new Seckill();
                seckill.setId(rs.getInt("id"));
                seckill.setName(rs.getString("Name"));
                seckill.setOpenDate(rs.getDate("OpenData"));
                seckill.setStopDate(rs.getDate("StopData"));
                seckill.setIsopen(rs.getInt("isopen"));
                list.add(seckill);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeALL(conn,ps,rs);
        }
        return list;
    }
    //查询count
    public int getSeckillsCount(){
        int num=0;
        Connection conn=getConnection();
        PreparedStatement ps=null;
        ResultSet rs=null;
        String sql = "SELECT Count(1) FROM seckill";
        try {
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            rs.next();
            num=rs.getInt(1);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeALL(rs,ps,conn);
        }
        return num;
    }

    //增加秒杀商品
    public int AddSeckill_commodity(Seckill_commodity slc) {
        String sql = "INSERT INTO seckill_commodity(seckill_id,seckill_Time_id,commodity_id,seckill_Price,seckill_Count,xg_Count) VALUES(?,?,?,?,?,?)";
        Object[] objs = new Object[]{slc.getSeckill_Time_id(),slc.getSeckill_id(),slc.getCommodity_id(),slc.getSeckill_Price(),slc.getSeckill_Count(),slc.getXg_Count()};
        return update(sql,objs);
    }

    //删除秒杀商品
    public int delSeckill_commodity(int id) {
        String sql = "DELETE FROM seckill_commodity WHERE id=?";
        Object[] objs = new Object[]{id};
        return update(sql,objs);
    }

    //获取秒杀商品列表
    public List<Seckill_commodity> getSeckill_commodity() {
        List<Seckill_commodity> list = new ArrayList<Seckill_commodity>();
        Connection conn = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM Seckill_commodity";
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                Seckill_commodity sc = new Seckill_commodity();
                sc.setId(rs.getInt("id"));
                sc.setSeckill_Time_id(rs.getInt("seckill_Time_id"));
                sc.setCommodity_id(rs.getInt("commodity_id"));
                sc.setSeckill_Price(rs.getDouble("seckill_Price"));
                sc.setSeckill_Count(rs.getInt("seckill_Count"));
                sc.setXg_Count(rs.getInt("xg_Count"));
                list.add(sc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeALL(conn,ps,rs);
        }
        return list;
    }

    //增加秒杀时间段
    public int AddSeckill_time(Seckill_time slt) {
        String sql = "INSERT INTO seckill_time(`Name`,OpenTime,StopTime,isOpen) VALUES(?,?,?,?)";
        Object[] objs = new Object[]{slt.getName(),slt.getOpenTime(),slt.getStopTime(),slt.getIsOpen()};
        return update(sql,objs);
    }

    //删除秒杀时间段
    public int delSeckill_time(int id) {
        String sql = "DELETE FROM seckill_time WHERE id=?";
        Object[] objs = new Object[]{id};
        return update(sql,objs);
    }

    //获取秒杀时间段列表
    public List<Seckill_time> getSeckill_times() {
        List<Seckill_time> list = new ArrayList<Seckill_time>();
        Connection conn = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM Seckill_time";
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                Seckill_time st = new Seckill_time();
                st.setId(rs.getInt("id"));
                st.setName(rs.getString("Name"));
                st.setOpenTime(rs.getTime("OpenTime"));
                st.setStopTime(rs.getTime("StopTime"));
                st.setIsOpen(rs.getInt("isOpen"));
                list.add(st);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeALL(conn,ps,rs);
        }
        return list;
    }
    //获取秒杀活动的秒杀时间段列表和商品数量
    public List<Seckill_time> getSeckill_times_Select(int seckill_id,int page,int limit) {
        List<Seckill_time> list = new ArrayList<Seckill_time>();
        Connection conn = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT *,\n" +
                "(SELECT COUNT(1) FROM seckill_commodity \n" +
                "WHERE seckill_commodity.seckill_Time_id=seckill_time.id \n" +
                "AND seckill_commodity.seckill_id=?) AS COUNT \n" +
                "FROM seckill_time \n" +
                "LIMIT ?,?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,seckill_id);
            if(page==1){
                ps.setInt(2, page-1);
            }else{
                ps.setInt(2, (page-1)*limit);
            }
            ps.setInt(3,limit);
            rs = ps.executeQuery();
            while (rs.next()){
                Seckill_time st = new Seckill_time();
                st.setId(rs.getInt("id"));
                st.setName(rs.getString("Name"));
                st.setOpenTime(rs.getTime("OpenTime"));
                st.setStopTime(rs.getTime("StopTime"));
                st.setIsOpen(rs.getInt("isOpen"));
                st.setCount(rs.getInt("count"));
                list.add(st);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeALL(conn,ps,rs);
        }
        return list;
    }
    public int getSeckill_Count(){
        int num=0;
        Connection conn=getConnection();
        PreparedStatement ps=null;
        ResultSet rs=null;
        String sql = "SELECT Count(1) FROM Seckill_time";
        try {
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            rs.next();
            num=rs.getInt(1);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeALL(rs,ps,conn);
        }
        return num;
    }
}
