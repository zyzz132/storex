package Impl;

import entity.Discounts;

import java.util.List;

public interface Discountsimpl {
    //添加数据 返回int
    int addDiscounts(Discounts ds);
    //删除数据 根据Id删除，返回int
    int delDiscounts(int id);
    //查询所有数据  返回集合
    List<Discounts> DiscountsById();
    //修改数据 返回int
    int updateDiscountById(int id, int count);

}
