package Impl;

import entity.Seckill;

import java.util.List;

//秒杀活动接口
public interface SeckillK {
    //添加秒杀活动
    public int AddSeckill(Seckill sl);

    //删除秒杀活动
    public int delSeckill(int id);

    //获取秒杀活动列表
    public List<Seckill> getSeckills();
}
