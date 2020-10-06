package entity;
//购物实体类
public class shopv {
    private int ShopV_Id;   //购物车序号id

    private int User_id;    //用户ID

    private  int CommType_id;   //商品型号ID

    private  int Count;     //数量
    private CommodityType Commtype=new CommodityType();
    private Commodity Commd=new Commodity();

    public shopv() {
    }

    public shopv(int user_id, int commType_id, int count) {
        User_id = user_id;
        CommType_id = commType_id;
        Count = count;
    }

    public shopv(int shopV_Id, int user_id, int commType_id, int count) {
        ShopV_Id = shopV_Id;
        User_id = user_id;
        CommType_id = commType_id;
        Count = count;
    }

    public int getShopV_Id() {
        return ShopV_Id;
    }

    public void setShopV_Id(int shopV_Id) {
        ShopV_Id = shopV_Id;
    }

    public int getUser_id() {
        return User_id;
    }

    public void setUser_id(int user_id) {
        User_id = user_id;
    }

    public int getCommType_id() {
        return CommType_id;
    }

    public void setCommType_id(int commType_id) {
        CommType_id = commType_id;
    }

    public int getCount() {
        return Count;
    }

    public void setCount(int count) {
        Count = count;
    }


    public CommodityType getCommtype() {
        return Commtype;
    }

    public void setCommtype(CommodityType commtype) {
        Commtype = commtype;
    }

    public Commodity getCommd() {
        return Commd;
    }

    public void setCommd(Commodity commd) {
        Commd = commd;
    }
}
