package entity;


import java.util.Date;

// 优惠券表
public class Discounts {
    private  int Id;

    private String name;   //优惠券名称

     private  int type_id;  //优惠券类型

     private    int send_count;//发放数量

     private    int user_count;//用户限额

     private  int money;    //面额

     private    double tj_price;    //满减使用条件

     private Date Time; //开始时间

    private  Date endTime;  //结束时间

    private int siCommodity;    //是否指定商品 0（不指定）：1（指定商品） 默认为0

    private String  remark;    //备注

    private  int count; //剩余数量

    public Discounts(int id, String name, int type_id, int send_count, int user_count, int money, double tj_price, Date time, Date endTime, int siCommodity, String  remark, int count) {
        Id = id;
        this.name = name;
        this.type_id = type_id;
        this.send_count = send_count;
        this.user_count = user_count;
        this.money = money;
        this.tj_price = tj_price;
        Time = time;
        this.endTime = endTime;
        this.siCommodity = siCommodity;
        this.remark = remark;
        this.count = count;
    }

    public Discounts(String name, int type_id, int send_count, int user_count, int money, double tj_price, Date time, Date endTime, int siCommodity, String remark, int count) {
        this.name = name;
        this.type_id = type_id;
        this.send_count = send_count;
        this.user_count = user_count;
        this.money = money;
        this.tj_price = tj_price;
        Time = time;
        this.endTime = endTime;
        this.siCommodity = siCommodity;
        this.remark = remark;
        this.count = count;
    }

    public Discounts() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }

    public int getSend_count() {
        return send_count;
    }

    public void setSend_count(int send_count) {
        this.send_count = send_count;
    }

    public int getUser_count() {
        return user_count;
    }

    public void setUser_count(int user_count) {
        this.user_count = user_count;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public double getTj_price() {
        return tj_price;
    }

    public void setTj_price(double tj_price) {
        this.tj_price = tj_price;
    }

    public Date getTime() {
        return Time;
    }

    public void setTime(Date time) {
        Time = time;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public int getSiCommodity() {
        return siCommodity;
    }

    public void setSiCommodity(int siCommodity) {
        this.siCommodity = siCommodity;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

}
