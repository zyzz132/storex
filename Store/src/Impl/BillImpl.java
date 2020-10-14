package Impl;

import entity.bill;

import java.util.Date;
import java.util.List;

//购物订单接口
public interface BillImpl {
    //查询订单编号(Bill_number)的订单数据，返回bill对象
    bill getBillByNumber(String Bill_number);

    //添加购物记录(bill) 返回int
    int addBill(bill Bill);

    //修改订单状态Bill_State 返回int
    int updateBill_State(bill Bill);

    //修改支付状态payState 返回int
    int updateBill_PayState(bill Billl);

    //查询订单 根据（订单编号，收货人姓名，订单日期,订单状态，订单类型）查询数据 返回List<bill >集合
    //a.String 订单编号
    //b.String 收货人姓名
    //c.String 订单日期
    //d.Int 订单状态
    //e.Int 订单类型
    //f.Int page	//当前页面
    //g.Int limit	//每页显示数量
    List<bill> getBill(String Bill_number, String Recipients, Date Bill_Time, int Bill_state, int Bill_type,int User_id, int page, int limit);

    //查询根据（订单编号，收货人姓名，订单日期,订单状态，订单类型）查询数据总数量 返回int
    int getBillCount(String Bill_number, String Recipients, Date Bill_Time, int Bill_state, int Bill_type,int User_id);
}
