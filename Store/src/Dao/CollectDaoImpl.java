package Dao;

import Impl.CollectDao;
import entity.Collect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CollectDaoImpl extends BaseDao implements CollectDao {


    public int addcollect(Collect ct) {
        String sql="INSERT INTO collect VALUES(NULL,?,?)";
        int num=  update(sql,ct.getUser_Id(),ct.getCommodity_Id());
        return num;
    }


    public int delcollect(int id) {
        String sql="DELETE FROM collect WHERE Collect_Id=?";
        int num=  update(sql,id);
        return num;

    }


    public List<Collect> getByComId(int User_Id,int page,int limit) {
        String sql="SELECT * FROM collect WHERE User_Id=? GROUP BY cl.CommClass_Id LIMIT ?,?";
        List<Collect> list=new ArrayList<>();
        Connection conn =getConnection();
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            ps=conn.prepareStatement(sql);
            if(page==1){
                ps.setInt(1, page-1);
                System.out.println(page-1);
            }else{
                ps.setInt(1, (page-1)*limit);
                System.out.println((page-1)*limit);
            }
            ps.setInt(2, limit);
            rs=ps.executeQuery();
            while (rs.next()){
                Collect ct=new Collect(rs.getInt("Collect_Id"),rs.getInt("Commodity_Id"));
                list.add(ct);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }


    public Collect getByUserId(int id) {
        String  sql="SELECT * FROM collect WHERE User_Id=?";
        Collect ct=null;
        Connection conn=getConnection();
        PreparedStatement ps=null;
        ResultSet rs=null;

        try {
            ps=conn.prepareStatement(sql);
            ps.setObject(1,id);
            rs=ps.executeQuery();
            while (rs.next()){
                ct=new Collect();
                ct.setCollect_Id(rs.getInt("Collect_Id"));
                ct.setUser_Id(rs.getInt("User_Id"));
                ct.setCommodity_Id(rs.getInt("Commodity_Id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeALL(rs,ps,conn);
        }


        return ct;
    }


    public List<Collect> getByComName(String Commodity_Name,int User_Id) {
        List<Collect> list=new ArrayList<>();
        String sql="SELECT * FROM collect WHERE Commodity_Id IN " +
                "(SELECT Commodity_Id FROM commodity WHERE Commodity_name LIKE '%?%') " +
                "AND User_Id = ?";
        Connection conn=getConnection();
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            ps=conn.prepareStatement(sql);
            rs= ps.executeQuery();
            while (rs.next()){
                Collect ct=new Collect();
                ct.setCollect_Id(rs.getInt("Collect_Id"));
                ct.setUser_Id(rs.getInt("User_Id"));
                ct.setCommodity_Id(rs.getInt("Commodity_Id"));
                list.add(ct);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeALL(rs,ps,conn);
        }
        return list;
    }
}
