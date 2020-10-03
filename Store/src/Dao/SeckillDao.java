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
    public List<Seckill> getSeckills() {
        List<Seckill> list = new ArrayList<Seckill>();
        Connection conn = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM seckill";
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                Seckill seckill = new Seckill();
                seckill.setId(rs.getInt("id"));
                seckill.setName(rs.getString("Name"));
                seckill.setOpenDate(rs.getDate("OpenDate"));
                list.add(seckill);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeALL(conn,ps,rs);
        }
        return null;
    }

    //增加秒杀商品
    public int AddSeckill_commodity(Seckill_commodity slc) {
        String sql = "INSERT INTO seckill_commodity(seckill_Time_id,commodity_id,seckill_Price,seckill_Count,xg_Count) VALUES(?,?,?,?,?)";
        Object[] objs = new Object[]{slc.getSeckill_Time_id(),slc.getCommodity_id(),slc.getSeckill_Price(),slc.getSeckill_Count(),slc.getXg_Count()};
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
        return null;
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
        return null;
    }
}
