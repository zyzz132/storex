package entity;

//用户财富实体类
public class userwealth {

    private int UserWealth_id;  //用户财富ID

    private  int User_Id;   //用户id

    private  double Money;  //余额

    private  int Score; //积分

    private  String PayPwd;     //支付密码

    public userwealth() {
    }

    public userwealth(int user_Id, double money, int score, String payPwd) {
        User_Id = user_Id;
        Money = money;
        Score = score;
        PayPwd = payPwd;
    }

    public userwealth(int userWealth_id, int user_Id, double money, int score, String payPwd) {
        UserWealth_id = userWealth_id;
        User_Id = user_Id;
        Money = money;
        Score = score;
        PayPwd = payPwd;
    }

    public int getUserWealth_id() {
        return UserWealth_id;
    }

    public void setUserWealth_id(int userWealth_id) {
        UserWealth_id = userWealth_id;
    }

    public int getUser_Id() {
        return User_Id;
    }

    public void setUser_Id(int user_Id) {
        User_Id = user_Id;
    }

    public double getMoney() {
        return Money;
    }

    public void setMoney(double money) {
        Money = money;
    }

    public int getScore() {
        return Score;
    }

    public void setScore(int score) {
        Score = score;
    }

    public String getPayPwd() {
        return PayPwd;
    }

    public void setPayPwd(String payPwd) {
        PayPwd = payPwd;
    }
}
