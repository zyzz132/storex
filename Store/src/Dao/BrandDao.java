package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Brand;

public class BrandDao extends BaseDao{
	Connection conn=null;
	PreparedStatement ps=null;
	//获取品牌总数量
	public int getBrandCount(){
		ResultSet rs=null;
		String sql="SELECT COUNT(*) FROM brand b LEFT JOIN commodity c ON b.id = c.brand_id";
		int count= -1;
		
		try {
			rs=this.executeQuery(conn,ps,sql, null);
			rs.next();
			count=rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeALL(rs,ps,conn);
		}
		
		return count;
	}
	//获取品牌列表，可以根据品牌名称查询
	public List<Brand> getBrandInfo(String brand_name,int currPageNo, int numsPerPage) {
		List<Brand> brands = new ArrayList<Brand>();
		ResultSet rs=null;
		String WhereBrand_name="";
		if(brand_name !=null && !brand_name.equals("")){
			WhereBrand_name="WHERE b.brand_name=?";
		}
		String sql = "SELECT  b.*,COUNT(c.Commodity_Id) AS COUNT "+
					"FROM brand b LEFT JOIN commodity c ON b.id = c.brand_id "+WhereBrand_name+
					"GROUP BY b.id "
				+"LIMIT ?,?";
		if(currPageNo==1){
			currPageNo=currPageNo-1;
		}else{
			currPageNo=(currPageNo-1)*numsPerPage;
		}
		if(brand_name !=null && !brand_name.equals("")){
			rs = this.executeQuery(conn,ps,sql, brand_name,currPageNo,numsPerPage);
		}else{
			rs = this.executeQuery(conn,ps,sql, currPageNo,numsPerPage);
		}

		try {
			while(rs.next()){
				Brand brand = new Brand();
				brand.setId(rs.getInt("id"));
				brand.setBrand_name(rs.getString("brand_name"));
				brand.setBrand_letter(rs.getString("brand_letter"));
				brand.setSort(rs.getInt("sort"));
				brand.setIsShow(rs.getInt("isShow"));
				brand.setBrand_manufacturer(rs.getString("brand_manufacturer"));
				brand.setCommodCount(rs.getInt("count"));
				brands.add(brand);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeALL(rs,ps,conn);
		}
		return brands;
	}
	//查询
	public int getBrandInfoCount(String brand_name){
		String sql="SELECT count(*) from brand ";
		ResultSet rs=null;
		int num=-1;
		if(brand_name!=null){
			sql+="WHERE brand_name=?";
			rs=this.executeQuery(conn,ps,sql,brand_name);
		}else{
			rs=this.executeQuery(conn,ps,sql);
		}
		try {
			rs.next();
			num=rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeALL(rs,ps,conn);
		}
		return num;
	}
	//
	public List<Brand> getBrandlist(){
		List<Brand> list=new ArrayList<Brand>();
		ResultSet rs=null;
		String sql="select * FROM brand";
		rs=executeQuery(conn,ps,sql);
		try {
			while(rs.next()){
				Brand br=new Brand();
				br.setId(rs.getInt("id"));
				br.setBrand_name(rs.getString("brand_name"));
				br.setBrand_letter(rs.getString("brand_letter"));
				br.setSort(rs.getInt("sort"));
				br.setIsShow(rs.getInt("isShow"));
				br.setBrand_manufacturer(rs.getString("brand_manufacturer"));
				list.add(br);
			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}finally {
			closeALL(rs,ps,conn);
		}
		return list;
	}
}
