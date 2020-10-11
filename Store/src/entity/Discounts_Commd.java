package entity;

//优惠券商品表
public class Discounts_Commd {
    private int Id;

    private  int Commodity_id;  //商品id

    private  int Discounts_id;  //优惠券id

    public Discounts_Commd(int id, int commodity_id, int discounts_id) {
        Id = id;
        Commodity_id = commodity_id;
        Discounts_id = discounts_id;
    }

    public Discounts_Commd(int commodity_id, int discounts_id) {
        Commodity_id = commodity_id;
        Discounts_id = discounts_id;
    }

    public Discounts_Commd() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getCommodity_id() {
        return Commodity_id;
    }

    public void setCommodity_id(int commodity_id) {
        Commodity_id = commodity_id;
    }

    public int getDiscounts_id() {
        return Discounts_id;
    }

    public void setDiscounts_id(int discounts_id) {
        Discounts_id = discounts_id;
    }
}
