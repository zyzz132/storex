package Dao;

import Impl.Discounts_recordimpl;
import entity.Discounts_record;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Discounts_recordDaol extends BaseDao implements Discounts_recordimpl {
    //1:添加
    public int addDisRecord(Discounts_record dr) {
        String sql = "INSERT INTO discounts_record VALUES(?,?,?,?,?,?,?,?)";
        int num = update(sql, dr.getDiscounts_code(), dr.getUser_id(), dr.getGetWay(), dr.getGetTime(), dr.getState()
                , dr.getEmployTime(), dr.getBill_id());
        return num;
    }

    //2删除
    public int delDisRecord(int id) {
        String sql = "DELETE FROM discounts_record WHERE Id=?";
        Connection conn = getConnection();
        PreparedStatement ps = null;
        int num = 0;
        try {
            ps = conn.prepareStatement(sql);
            ps.setObject(1, id);
            num = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeALL(ps, conn);
        }
        return num;
    }

    //3修改（使用状态）
    public int updateDisState(int state_id,int Id) {
        String sql="UPDATE discounts_record SET state=? WHERE Id=?";
       int num=update(sql,state_id,Id );
        return num;
    }

    //4修改（使用时间、订单ID）
    public int updateDisBill(Date employTime, int Bill_id) {
        String sql="UPDATE discounts_record SET employTime=? WHERE Bill_id=?";
        int num=update(sql,employTime,Bill_id);
        return num;
    }

    //3查询（查询所有）
    public List<Discounts_record> DisRecordById(int id) {
        String sql="SELECT * FROM discounts_record WHERE id=?";
        List<Discounts_record> list=new ArrayList<Discounts_record>();
        Connection conn=getConnection();
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            ps= conn.prepareStatement(sql);
            ps.setObject(1,id);
            rs=ps.executeQuery();
            while (rs.next()){
                Discounts_record dr=new Discounts_record();
                dr.setDiscounts_code(rs.getString("Discounts_code"));
                dr.setUser_id(rs.getInt("User_id"));
                dr.setGetWay(rs.getInt("GetWay"));
                dr.setGetTime(rs.getDate("getTime"));
                dr.setState(rs.getInt("state"));
                dr.setEmployTime(rs.getDate("employTime"));
                dr.setBill_id(rs.getInt("Bill_id"));
                list.add(dr);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeALL(rs,ps,conn);
        }
        return list;
    }

    //4查询（根据用户id查询）
    public List<Discounts_record> DisUser(int User_id) {
        String sql = "SELECT * FROM discounts_record where User_id=?";
        List<Discounts_record> list=new ArrayList<Discounts_record>();
        Connection conn=getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setObject(1, User_id);
            rs = ps.executeQuery();
            while (rs.next()) {
                Discounts_record dr=new Discounts_record();
                dr.setDiscounts_code(rs.getString("Discounts_code"));
                dr.setUser_id(rs.getInt("User_id"));
                dr.setGetWay(rs.getInt("GetWay"));
                dr.setGetTime(rs.getDate("getTime"));
                dr.setState(rs.getInt("state"));
                dr.setEmployTime(rs.getDate("employTime"));
                dr.setBill_id(rs.getInt("Bill_id"));
                list.add(dr);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeALL(rs, ps, conn);
        }
        return list ;
    }
    //5查询（根据使用状态查询）
    public List<Discounts_record> DisState(int state_id) {
        String sql = "SELECT * FROM discounts_record where state_id=?";
        List<Discounts_record> list=new ArrayList<Discounts_record>();
        Connection conn=getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setObject(1, state_id);
            rs = ps.executeQuery();
            while (rs.next()) {
                Discounts_record dr=new Discounts_record();
                dr.setDiscounts_code(rs.getString("Discounts_code"));
                dr.setUser_id(rs.getInt("User_id"));
                dr.setGetWay(rs.getInt("GetWay"));
                dr.setGetTime(rs.getDate("getTime"));
                dr.setState(rs.getInt("state"));
                dr.setEmployTime(rs.getDate("employTime"));
                dr.setBill_id(rs.getInt("Bill_id"));
                list.add(dr);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeALL(rs, ps, conn);
        }
        return list ;
    }


















}
