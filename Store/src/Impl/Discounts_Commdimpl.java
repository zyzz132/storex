package Impl;

import entity.Discounts_Commd;

import java.util.List;

public interface Discounts_Commdimpl {
    //添加数据  返回int
    int addDisCommd(Discounts_Commd dc);
    //删除数据  返回int
    int  delDisCommd(int id);
    //查询数据，返回集合
    List<Discounts_Commd> DisCommdById();
    //根据优惠券id查询
    List<Discounts_Commd> DisCommdByDiscounts_id(int Dis_id);
}
