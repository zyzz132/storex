package entity;

import java.util.Date;

//优惠劵记录表
public class Discounts_record {
    private  int Id;

    private String Discounts_code;  //优惠码

    private  int User_id;  //用户id

    private int GetWay; //领取方式 1主动领取

    private Date getTime;   //领取时间

    private  int state;     //使用状态 默认为0未使用 1为已使用

    private  Date employTime;   //使用时间

    private  int Bill_id;       //订单id

    public Discounts_record() {
    }

    public Discounts_record(String discounts_code, int user_id, int getWay, Date getTime, int state, Date employTime, int bill_id) {
        Discounts_code = discounts_code;
        User_id = user_id;
        GetWay = getWay;
        this.getTime = getTime;
        this.state = state;
        this.employTime = employTime;
        Bill_id = bill_id;
    }

    public Discounts_record(int id, String discounts_code, int user_id, int getWay, Date getTime, int state, Date employTime, int bill_id) {
        Id = id;
        Discounts_code = discounts_code;
        User_id = user_id;
        GetWay = getWay;
        this.getTime = getTime;
        this.state = state;
        this.employTime = employTime;
        Bill_id = bill_id;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getDiscounts_code() {
        return Discounts_code;
    }

    public void setDiscounts_code(String discounts_code) {
        Discounts_code = discounts_code;
    }

    public int getUser_id() {
        return User_id;
    }

    public void setUser_id(int user_id) {
        User_id = user_id;
    }

    public int getGetWay() {
        return GetWay;
    }

    public void setGetWay(int getWay) {
        GetWay = getWay;
    }

    public Date getGetTime() {
        return getTime;
    }

    public void setGetTime(Date getTime) {
        this.getTime = getTime;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Date getEmployTime() {
        return employTime;
    }

    public void setEmployTime(Date employTime) {
        this.employTime = employTime;
    }

    public int getBill_id() {
        return Bill_id;
    }

    public void setBill_id(int bill_id) {
        Bill_id = bill_id;
    }
}
