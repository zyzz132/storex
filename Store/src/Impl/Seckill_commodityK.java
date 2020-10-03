package Impl;

import entity.Seckill_commodity;

import java.util.List;

//秒杀商品接口
public interface Seckill_commodityK {
    //添加秒杀商品
    public int AddSeckill_commodity(Seckill_commodity slc);

    //删除秒杀商品
    public int delSeckill_commodity(int  id);

    //获取秒杀商品列表
    public List<Seckill_commodity> getSeckill_commodity();
}
