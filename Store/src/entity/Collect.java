package entity;
//商品收藏实体类
public class Collect {
    private int Collect_Id; //序号ID

    private  int User_Id;   //用户ID

    private  int Commodity_Id;  //商品ID

    public int getCollect_Id() {
        return Collect_Id;
    }

    public void setCollect_Id(int collect_Id) {
        Collect_Id = collect_Id;
    }

    public int getUser_Id() {
        return User_Id;
    }

    public void setUser_Id(int user_Id) {
        User_Id = user_Id;
    }

    public int getCommodity_Id() {
        return Commodity_Id;
    }

    public void setCommodity_Id(int commodity_Id) {
        Commodity_Id = commodity_Id;
    }

    public Collect(int collect_Id, int user_Id, int commodity_Id) {
        Collect_Id = collect_Id;
        User_Id = user_Id;
        Commodity_Id = commodity_Id;
    }

    public Collect(int user_Id, int commodity_Id) {
        User_Id = user_Id;
        Commodity_Id = commodity_Id;
    }

    public Collect() {
    }
}
