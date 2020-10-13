package Dao;

import Impl.BillImpl;
import entity.bill;
import entity.bill_commodity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BillDao extends BaseDao implements BillImpl {
    //查询订单编号(Bill_number)的订单数据，返回bill对象
    public bill getBillByNumber(String Bill_number) {
        Connection conn = getConnection();
        String sql = "SELECT * FROM bill WHERE Bill_number = ?";
        PreparedStatement ps = null;
        bill Bill = null;
        ResultSet rs = executeQuery(conn,ps,sql,Bill_number);
        try {
            if(rs.next()){
                while (rs.next()){
                    Bill = new bill();
                    Bill.setBill_Id(rs.getInt("Bill_Id"));
                    Bill.setBillComm_Id(rs.getInt("BillComm_Id"));
                    Bill.setBill_address(rs.getString("Bill_address"));
                    Bill.setBill_freight(rs.getDouble("Bill_freight"));
                    Bill.setUser_Id(rs.getInt("User_Id"));
                    Bill.setBill_Time(rs.getDate("Bill_Time"));
                    Bill.setBill_number(rs.getString("Bill_number"));
                    Bill.setBill_state(rs.getInt("Bill_state"));
                    Bill.setBill_type(rs.getInt("Bill_type"));
                    Bill.setRecipients(rs.getString("Recipients"));
                    Bill.setPhone(rs.getString("phone"));
                    Bill.setPostcode(rs.getString("postcode"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeALL(conn,ps,rs);
        }
        return Bill;
    }

    //添加购物记录(bill) 返回int
    public int addBill(bill Bill) {
        int num=-1;
        String sql = "INSERT INTO bill(BillComm_Id,Bill_address,Bill_freight,User_Id,Bill_Time,Bill_number,Bill_state,Bill_type,Recipients,phne,postcode,payState) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
        Object[] objs = new Object[]{Bill.getBillComm_Id(),Bill.getBill_address(),Bill.getBill_freight(),Bill.getUser_Id()
        ,Bill.getBill_Time(),Bill.getBill_number(),Bill.getBill_state(),Bill.getBill_type(),Bill.getRecipients(),Bill.getPhone()
        ,Bill.getPostcode(),Bill.getPayState()};
        if(update(sql,objs)>0){
            Connection conn = getConnection();
            PreparedStatement ps = null;
            String billIdSql ="SELECT Bill_Id FROM bill WHERE Bill_number=?";
            ResultSet rs = executeQuery(conn,ps,billIdSql,Bill.getBill_number());
            try {
                while(rs.next()){
                    Bill.setBill_Id(rs.getInt("Bill_Id"));
                }
               for (int i=0;i<Bill.getList().size();i++){
                   bill_commodity bc = Bill.getList().get(i);
                   String addBillCommoditySql = "INSERT INTO bill_commodity(Bill_Id,Commtype_Id,`Count`,Price) VALUES(?,?,?,?)";
                   Object[] BillCommodityobjs = new Object[]{bc.getBill_Id(),bc.getCommType_Id(),bc.getCount(),bc.getPrice()};
                   num = update(addBillCommoditySql,BillCommodityobjs);
               }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                closeALL(conn,ps,rs);
            }
        }
        return num;
    }

    //修改订单状态Bill_State 返回int
    public int updateBill_State(bill Bill) {
        return update("UPDATE bill SET Bill_state = ? WHERE Bill_Id=?",Bill.getBill_state(),Bill.getBill_Id());
    }

    //修改支付状态payState 返回int
    public int updateBill_PayState(bill Bill) {
        return update("UPDATE bill SET payState = ? WHERE Bill_Id=?",Bill.getPayState(),Bill.getBill_Id());
    }

    //查询订单 根据（订单编号，收货人姓名，订单日期,订单状态，订单类型）查询数据 返回List<bill >集合
    public List<bill> getBill(String Bill_number, String Recipients, Date Bill_Time, int Bill_state, int Bill_type, int page, int limit) {
        List<bill> list = new ArrayList<bill>();
        StringBuffer sbf = new StringBuffer("SELECT * FROM bill WHERE 1=1");
        if(Bill_number!=null){
            sbf.append(" and Bill_number = "+Bill_number);
        }
        if(Recipients!=null){
            sbf.append(" and Recipients = "+Recipients);
        }
        if(Bill_Time!=null){
            sbf.append(" and Bill_Time = "+Bill_Time);
        }
        if(Bill_state!=0){
            sbf.append(" and Bill_state = "+Bill_state);
        }
        if(Bill_type!=0){
            sbf.append(" and Bill_type = "+Bill_type);
        }
        if(page>0){
            sbf.append(" limit "+(page-1)*limit+" , "+limit);
        }
        Connection conn = getConnection();
        PreparedStatement ps=null;
        ResultSet rs = executeQuery(conn,ps,sbf.toString());
        try {
            while (rs.next()){
                bill Bill = new bill();
                Bill.setBill_Id(rs.getInt("Bill_Id"));
                Bill.setBillComm_Id(rs.getInt("BillComm_Id"));
                Bill.setBill_address(rs.getString("Bill_address"));
                Bill.setBill_freight(rs.getDouble("Bill_freight"));
                Bill.setUser_Id(rs.getInt("User_Id"));
                Bill.setBill_Time(rs.getDate("Bill_Time"));
                Bill.setBill_number(rs.getString("Bill_number"));
                Bill.setBill_state(rs.getInt("Bill_state"));
                Bill.setBill_type(rs.getInt("Bill_type"));
                Bill.setRecipients(rs.getString("Recipients"));
                Bill.setPhone(rs.getString("phone"));
                Bill.setPostcode(rs.getString("postcode"));
                list.add(Bill);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeALL(conn,ps,rs);
        }
        System.out.println(list.size());
        return list;
    }

    //查询根据（订单编号，收货人姓名，订单日期,订单状态，订单类型）查询数据总数量 返回int
    public int getBillCount(String Bill_number, String Recipients, Date Bill_Time, int Bill_state, int Bill_type) {
        int num=-1;
        StringBuffer sbf = new StringBuffer("SELECT COUNT(1) FROM bill WHERE 1=1");
        if(Bill_number!=null){
            sbf.append(" and Bill_number = "+Bill_number);
        }
        if(Recipients!=null){
            sbf.append(" and Recipients = "+Recipients);
        }
        if(Bill_Time!=null){
            sbf.append(" and Bill_Time = "+Bill_Time);
        }
        if(Bill_state!=0){
            sbf.append(" and Bill_state = "+Bill_state);
        }
        if(Bill_type!=0){
            sbf.append(" and Bill_type = "+Bill_type);
        }
        Connection conn = getConnection();
        PreparedStatement ps=null;
        ResultSet rs = executeQuery(conn,ps,sbf.toString());
        try {
            while(rs.next()){
                num=rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeALL(conn,ps,rs);
        }
        return num;
    }
}
