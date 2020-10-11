package Impl;

import entity.Discounts_record;

import java.util.Date;
import java.util.List;

public interface Discounts_recordimpl {
    //添加
    int addDisRecord(Discounts_record dr);
    //删除
    int delDisRecord(int id);
    //修改(使用状态)
    int updateDisState(int state_id, int Id);
    //修改(使用时间，订单ID)
    int updateDisBill(Date employTime, int Bill_id);
    //查询(查询所有)
    List<Discounts_record> DisRecordById(int id);
    //查询(根据用户id查询)
    List<Discounts_record> DisUser(int User_id);
    //查询(根据使用状态查询)
    List<Discounts_record> DisState(int state_id);
}
