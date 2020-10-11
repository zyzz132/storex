package entity;

//实体类
public class commodity_px {
    private int Commodity_id;   //商品id

    private  String particulars;    //商品详情

    public int getCommodity_id() {
        return Commodity_id;
    }

    public void setCommodity_id(int commodity_id) {
        Commodity_id = commodity_id;
    }

    public String getParticulars() {
        return particulars;
    }

    public void setParticulars(String particulars) {
        this.particulars = particulars;
    }

    public commodity_px(int commodity_id, String particulars) {
        Commodity_id = commodity_id;
        this.particulars = particulars;
    }

    public commodity_px(String particulars) {
        this.particulars = particulars;
    }

    public commodity_px() {
    }
}

