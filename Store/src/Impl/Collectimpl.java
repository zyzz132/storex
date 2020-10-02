package Impl;

import entity.Collect;

import java.util.List;

public interface Collectimpl {
    //添加collect数据  返回int
    public int addcollect(Collect ct);
    //删除collect数据 ，根据collect. Collect_Id查询删除 返回int
    public  int delcollect(int id);
    //查询用户ID的商品收藏数据 返回collect集合
    public List<Collect> getByComId(int User_Id,int page,int limit);
    //查询用户ID的商品收藏总记录数 返回int
    public  Collect getByUserId(int id);
    //根据商品名称模糊查询用户ID的商品收藏数据 返回collect集合
    public  List<Collect> getByComName(String Commodity_Name,int User_Id);
}
