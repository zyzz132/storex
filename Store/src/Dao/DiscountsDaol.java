package Dao;

import Impl.Discountsimpl;
import entity.Discounts;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DiscountsDaol extends BaseDao implements Discountsimpl {
    //	1:添加
    public int addDiscounts(Discounts ds) {
        String sql="INSERT INTO discounts VALUES(?,?)";
        int num=update(sql,ds.getName(),ds.getType_id(),ds.getSend_count(),ds.getUser_count()
        ,ds.getMoney(),ds.getTj_price(),ds.getTime(),ds.getEndTime(),ds.getSiCommodity()
        ,ds.getRemark(),ds.getCount());
        return num;
    }

    //2:删除
    public int delDiscounts(int id) {
        String sql="DELETE FROM discounts WHERE Id=?";
        Connection conn=getConnection();
        PreparedStatement ps=null;
        int num=0;
        try {
            ps= conn.prepareStatement(sql);
            ps.setObject(1,id);
            num=ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeALL(ps,conn);
        }
        return num;
    }

    //3查询（查询所有）
    public List<Discounts> DiscountsById() {
        String sql="SELECT * FROM discounts";
        List<Discounts> list=new ArrayList<Discounts>();
        Connection conn=getConnection();
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()){
               Discounts dt=new Discounts();
                dt.setId(rs.getInt("Id"));
                dt.setName(rs.getString("name"));
                dt.setType_id(rs.getInt("type_id"));
                dt.setSend_count(rs.getInt("send_count"));
                dt.setUser_count(rs.getInt("user_count"));
                dt.setMoney(rs.getInt("money"));
                dt.setTj_price(rs.getDouble("tj_price"));
                dt.setTime(rs.getDate("Time"));
                dt.setEndTime(rs.getDate("endTime"));
                dt.setSiCommodity(rs.getInt("siCommodity"));
                dt.setRemark(rs.getString("remark"));
                dt.setCount(rs.getInt("count"));
                list.add(dt);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeALL(rs,ps,conn);
        }

        return list;
    }

    //4修改（剩余数量）
    public int updateDiscountById(int id,int count) {
        String sql="UPDATE discounts_record SET `count`=? WHERE Id=?";
        int num=update(sql,count,id);
        return num;
    }
}
