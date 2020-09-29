package entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//订单实体类
public class bill {
    private  int Bill_Id;   //订单ID

    private  int BillComm_Id;   //订单商品ID

    private  String Bill_address;    //收货地址

    private  double Bill_freight;   //运费

    private  int User_Id;   //用户ID

    private Date Bill_Time; //订单日期

    private  String Bill_number;    //订单编号

    private  int Bill_state;        //订单状态

    private  int Bill_type;     //订单类型

    private  String Recipients; //收件人姓名

    private  String phne;   //收件人电话

    private  String postcode;   //邮政编码

    List<bill_commodity> list=new ArrayList<bill_commodity>();

    public int getBill_Id() {
        return Bill_Id;
    }

    public void setBill_Id(int bill_Id) {
        Bill_Id = bill_Id;
    }

    public int getBillComm_Id() {
        return BillComm_Id;
    }

    public void setBillComm_Id(int billComm_Id) {
        BillComm_Id = billComm_Id;
    }

    public String getBill_address() {
        return Bill_address;
    }

    public void setBill_address(String bill_address) {
        Bill_address = bill_address;
    }

    public double getBill_freight() {
        return Bill_freight;
    }

    public void setBill_freight(double bill_freight) {
        Bill_freight = bill_freight;
    }

    public int getUser_Id() {
        return User_Id;
    }

    public void setUser_Id(int user_Id) {
        User_Id = user_Id;
    }

    public Date getBill_Time() {
        return Bill_Time;
    }

    public void setBill_Time(Date bill_Time) {
        Bill_Time = bill_Time;
    }

    public String getBill_number() {
        return Bill_number;
    }

    public void setBill_number(String bill_number) {
        Bill_number = bill_number;
    }

    public int getBill_state() {
        return Bill_state;
    }

    public void setBill_state(int bill_state) {
        Bill_state = bill_state;
    }

    public int getBill_type() {
        return Bill_type;
    }

    public void setBill_type(int bill_type) {
        Bill_type = bill_type;
    }

    public String getRecipients() {
        return Recipients;
    }

    public void setRecipients(String recipients) {
        Recipients = recipients;
    }

    public String getPhne() {
        return phne;
    }

    public void setPhne(String phne) {
        this.phne = phne;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public bill(int bill_Id, int billComm_Id, String bill_address, double bill_freight, int user_Id, Date bill_Time, String bill_number, int bill_state, int bill_type, String recipients, String phne, String postcode) {
        Bill_Id = bill_Id;
        BillComm_Id = billComm_Id;
        Bill_address = bill_address;
        Bill_freight = bill_freight;
        User_Id = user_Id;
        Bill_Time = bill_Time;
        Bill_number = bill_number;
        Bill_state = bill_state;
        Bill_type = bill_type;
        Recipients = recipients;
        this.phne = phne;
        this.postcode = postcode;
    }

    public bill(int billComm_Id, String bill_address, double bill_freight, int user_Id, Date bill_Time, String bill_number, int bill_state, int bill_type, String recipients, String phne, String postcode) {
        BillComm_Id = billComm_Id;
        Bill_address = bill_address;
        Bill_freight = bill_freight;
        User_Id = user_Id;
        Bill_Time = bill_Time;
        Bill_number = bill_number;
        Bill_state = bill_state;
        Bill_type = bill_type;
        Recipients = recipients;
        this.phne = phne;
        this.postcode = postcode;
    }

    public bill() {
    }
}
