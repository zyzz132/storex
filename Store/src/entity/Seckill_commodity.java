package entity;
//秒杀活动商品实体类
public class Seckill_commodity {
    private int id;                 //编号
    private int seckill_id;         //秒杀活动id
    private int seckill_Time_id;    //秒杀时间id
    private int commodity_id;       //商品id
    private double seckill_Price;   //秒杀价格
    private int seckill_Count;      //秒杀数量
    private int xg_Count;           //限购数量

    public int getSeckill_id() {
        return seckill_id;
    }

    public void setSeckill_id(int seckill_id) {
        this.seckill_id = seckill_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSeckill_Time_id() {
        return seckill_Time_id;
    }

    public void setSeckill_Time_id(int seckill_Time_id) {
        this.seckill_Time_id = seckill_Time_id;
    }

    public int getCommodity_id() {
        return commodity_id;
    }

    public void setCommodity_id(int commodity_id) {
        this.commodity_id = commodity_id;
    }

    public double getSeckill_Price() {
        return seckill_Price;
    }

    public void setSeckill_Price(double seckill_Price) {
        this.seckill_Price = seckill_Price;
    }

    public int getSeckill_Count() {
        return seckill_Count;
    }

    public void setSeckill_Count(int seckill_Count) {
        this.seckill_Count = seckill_Count;
    }

    public int getXg_Count() {
        return xg_Count;
    }

    public void setXg_Count(int xg_Count) {
        this.xg_Count = xg_Count;
    }

    public Seckill_commodity() {
    }

    public Seckill_commodity(int seckill_Time_id, int commodity_id, double seckill_Price, int seckill_Count, int xg_Count) {
        this.seckill_Time_id = seckill_Time_id;
        this.commodity_id = commodity_id;
        this.seckill_Price = seckill_Price;
        this.seckill_Count = seckill_Count;
        this.xg_Count = xg_Count;
    }

    public Seckill_commodity(int id, int seckill_Time_id, int commodity_id, double seckill_Price, int seckill_Count, int xg_Count) {
        this.id = id;
        this.seckill_Time_id = seckill_Time_id;
        this.commodity_id = commodity_id;
        this.seckill_Price = seckill_Price;
        this.seckill_Count = seckill_Count;
        this.xg_Count = xg_Count;
    }
}
