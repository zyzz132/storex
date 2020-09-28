package entity;
//订单商品实体类
public class bill_commodity {
    private  int BillComm_Id;   //订单商品ID

    private  int CommType_Id;   //商品型号ID

    private  int Count;     //数量

    private  double Price;  //金额

    public int getBillComm_Id() {
        return BillComm_Id;
    }

    public void setBillComm_Id(int billComm_Id) {
        BillComm_Id = billComm_Id;
    }

    public int getCommType_Id() {
        return CommType_Id;
    }

    public void setCommType_Id(int commType_Id) {
        CommType_Id = commType_Id;
    }

    public int getCount() {
        return Count;
    }

    public void setCount(int count) {
        Count = count;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public bill_commodity(int billComm_Id, int commType_Id, int count, double price) {
        BillComm_Id = billComm_Id;
        CommType_Id = commType_Id;
        Count = count;
        Price = price;
    }

    public bill_commodity(int commType_Id, int count, double price) {
        CommType_Id = commType_Id;
        Count = count;
        Price = price;
    }

    public bill_commodity() {
    }
}
