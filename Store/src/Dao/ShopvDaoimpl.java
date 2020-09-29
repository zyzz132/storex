package Dao;

import Impl.ShopvDao;
import entity.Commodity;
import entity.shopv;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ShopvDaoimpl extends  BaseDao implements ShopvDao {

    public int addshopv(shopv sp) {
        int num=0;
        String sql="insert into shopv(Shopv_Id,User_id,CommType_id,Count) values(?,?,?,?)";
        Object[] objs=new Object[]{sp.getShopV_Id(),sp.getUser_id(),sp.getCommType_id(),sp.getCount()};
        num=update(sql,objs);

        return num;
    }


    public int delshopvById(int id) {
        String sql="delete from student where id=? ";
        int num=0;
        Object objs=new Object[]{id};
        num=update(sql,id);
        return num;
    }


    public List<shopv> getshopvById(Commodity cd) {
        List<shopv> list= new ArrayList<shopv>();
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        String sql="SELECT * FROM shopv WHERE ShopV_Id=?";
        try {
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()){
                shopv s=new shopv();
                s.setShopV_Id(rs.getInt("ShopV_Id"));
                s.setUser_id(rs.getInt("User_id"));
                s.setCommType_id(rs.getInt("CommType_id"));
                s.setCount(rs.getInt("Count"));
                list.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeALL(conn,ps,rs);
        }
        return list;
    }
}
