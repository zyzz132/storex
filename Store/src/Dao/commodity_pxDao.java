package Dao;

import entity.commodity_px;
import Impl.commodity_pximpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class commodity_pxDao extends BaseDao implements commodity_pximpl {
    //增加
    public int Addcommodity_px(commodity_px cp) {
        String sql="INSERT INTO commodity_px VALUES (?,?)";
        int num=update(sql,cp.getCommodity_id(),cp.getParticulars());
        return num;
    }

    //删除
    public int Delcommodity_px(int com_id) {
        String sql="DELETE FROM commodity_px WHERE Commodity_id=?";
        Connection conn=getConnection();
        PreparedStatement ps=null;
        int num=0;
        try {
            ps= conn.prepareStatement(sql);
            ps.setObject(1,com_id);
            num=ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeALL(ps,conn);
        }
        return num;
    }

    //修改
    public int Updcommodity_px(int com_id) {
        String sql="UPDATE commodity_px SET particulars=? WHERE Commodity_id=?";
        int num=update(sql,com_id);
        return num;
    }

    //查询
    public commodity_px Selcommodity_px(int Commodity_id) {
        String sql="SELECT * FROM commodity_px WHERE commodity_px.Commodity_id=?";
        commodity_px px=new commodity_px();
        Connection conn=getConnection();
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            ps=conn.prepareStatement(sql);
            ps.setInt(1,Commodity_id);
            rs=ps.executeQuery();
            while (rs.next()){
                px.setCommodity_id(rs.getInt("Commodity_id"));
                px.setParticulars(rs.getString("particulars"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeALL(rs,ps,conn);
        }

        return px;
    }
}
