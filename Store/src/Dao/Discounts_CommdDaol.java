package Dao;

import Impl.Discounts_Commdimpl;
import entity.Discounts_Commd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Discounts_CommdDaol extends BaseDao implements Discounts_Commdimpl {
   //1:添加
    public int addDisCommd(Discounts_Commd dc) {
        String sql="INSERT INTO discounts_commd VALUES(?,?)";
        int num=update(sql,dc.getCommodity_id(),dc.getDiscounts_id());
        return num;
    }

    //2删除
    public int delDisCommd(int id) {
        String sql="DELETE FROM discounts_commd WHERE Id=?";
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
    public List<Discounts_Commd> DisCommdById() {
        String sql="SELECT * FROM discounts_commd WHERE Id=?";
        List<Discounts_Commd> list=new ArrayList<Discounts_Commd>();
        Connection conn=getConnection();
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()){
                Discounts_Commd dc=new Discounts_Commd();
                dc.setId(rs.getInt("Id"));
                dc.setCommodity_id(rs.getInt("Commodity_id"));
                dc.setDiscounts_id(rs.getInt("Discounts_id"));
                list.add(dc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeALL(rs,ps,conn);
        }
        return list;
    }

    //4查询（根据优惠券id查询）
    public List<Discounts_Commd> DisCommdByDiscounts_id(int Dis_id) {
        String sql="SELECT * FROM discounts_commd WHERE Discounts_id=1";
        List<Discounts_Commd> list=new ArrayList<>();
        Connection conn=getConnection();
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            ps=conn.prepareStatement(sql);
            ps.setObject(1,Dis_id);
            rs=ps.executeQuery();
            while (rs.next()){
                Discounts_Commd dc=new Discounts_Commd();
                dc.setId(rs.getInt("Id"));
                dc.setCommodity_id(rs.getInt("Commodity_id"));
                dc.setDiscounts_id(rs.getInt("Discounts_id"));
                list.add(dc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeALL(rs,ps,conn);
        }
        return list;
    }
}
