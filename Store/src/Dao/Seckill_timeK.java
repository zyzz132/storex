package Dao;

import entity.Seckill_time;

import java.util.List;

//秒杀时间段接口
public interface Seckill_timeK {
    //添加秒杀时间段
    public int AddSeckill_time(Seckill_time slt);

    //删除秒杀时间段
    public int delSeckill_time(int id);

    //获取秒杀时间段列表
    public List<Seckill_time> getSeckill_times();
}
