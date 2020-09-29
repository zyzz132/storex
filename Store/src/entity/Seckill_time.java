package entity;

import java.sql.Time;

//秒杀活动时间实体类
public class Seckill_time {
    private int id;         //编号
    private String Name;    //时间段名称
    private Time OpenTime;  //开始时间
    private Time SoptTime;  //结束时间
    private int isOpen;     //是否启动(1:0)

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Time getOpenTime() {
        return OpenTime;
    }

    public void setOpenTime(Time openTime) {
        OpenTime = openTime;
    }

    public Time getSoptTime() {
        return SoptTime;
    }

    public void setSoptTime(Time soptTime) {
        SoptTime = soptTime;
    }

    public int getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(int isOpen) {
        this.isOpen = isOpen;
    }

    public Seckill_time() {
    }

    public Seckill_time(String name, Time openTime, Time soptTime, int isOpen) {
        Name = name;
        OpenTime = openTime;
        SoptTime = soptTime;
        this.isOpen = isOpen;
    }

    public Seckill_time(int id, String name, Time openTime, Time soptTime, int isOpen) {
        this.id = id;
        Name = name;
        OpenTime = openTime;
        SoptTime = soptTime;
        this.isOpen = isOpen;
    }
}
