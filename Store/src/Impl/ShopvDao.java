package Impl;

import java.util.List;

import entity.Commodity;
import entity.shopv;

public interface ShopvDao {
    //1、加入购物车（根据商品id添加购物车记录，返回int）
    public int addshopv(shopv sp);
    //2、删除购物车记录（根据商品id删除购物车记录，返回int）
    public int delshopvById(int id);
    //3、查询购物车记录（根据用户id查询购物车记录，返回Commodity对象）
    public List<shopv> getshopvById(Commodity cd);
}
