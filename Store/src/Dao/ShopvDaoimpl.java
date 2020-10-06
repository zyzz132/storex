package Dao;

import Impl.ShopvDao;
import Util.ShopvUtil;
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


    public List<shopv> getshopvById(int id) {
        List<shopv> list= new ArrayList<shopv>();
        Connection conn=getConnection();
        PreparedStatement ps=null;
        ResultSet rs=null;
        String sql="SELECT * FROM shopv WHERE User_id =?";
        try {
            ps=conn.prepareStatement(sql);
            ps.setInt(1,id);
            rs=ps.executeQuery();
            while (rs.next()){
                shopv s=new shopv();
                s.setShopV_Id(rs.getInt("ShopV_Id"));
                s.setUser_id(rs.getInt("User_id"));
                s.setCommType_id(rs.getInt("CommType_id"));
                s.setCount(rs.getInt("Count"));
                CommoidyTypeDao commtypeDao=new CommoidyTypeDao();
                s.setCommtype(commtypeDao.getCommID_Type(s.getCommType_id()));
                CommodiyDao commddao=new CommodiyDao();
                s.setCommd(commddao.getID_Commodiy(s.getCommtype().getCommodity_Id()));
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
