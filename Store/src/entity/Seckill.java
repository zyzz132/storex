package entity;

import java.util.Date;

//秒杀活动实体类
public class Seckill {
    private int id;             //编号
    private String Name;        //秒杀活动名称
    private Date OpenData;      //开始日期
    private Date stopData;      //结束日期
    private int isopen;         //是否启动(1=开始 0=关闭)

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

    public Date getOpenData() {
        return OpenData;
    }

    public void setOpenData(Date openData) {
        OpenData = openData;
    }

    public Date getStopData() {
        return stopData;
    }

    public void setStopData(Date stopData) {
        this.stopData = stopData;
    }

    public int getIsopen() {
        return isopen;
    }

    public void setIsopen(int isopen) {
        this.isopen = isopen;
    }
}
