package entity;
//送货地址实体类
public class sendadress {

    private int Address_Id; //地址ID

    private  int User_Id;   //用户ID

    private  String Address;    //详细地址

    public int getAddress_Id() {
        return Address_Id;
    }

    public void setAddress_Id(int address_Id) {
        Address_Id = address_Id;
    }

    public int getUser_Id() {
        return User_Id;
    }

    public void setUser_Id(int user_Id) {
        User_Id = user_Id;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public sendadress(int address_Id, int user_Id, String address) {
        Address_Id = address_Id;
        User_Id = user_Id;
        Address = address;
    }

    public sendadress(int user_Id, String address) {
        User_Id = user_Id;
        Address = address;
    }

    public sendadress() {
    }
}
