package Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Brand;

public class BrandDao extends BaseDao{
	//获取品牌总数量
	public int getBrandCount(){
		ResultSet rs=null;
		String sql="SELECT COUNT(*) FROM brand b LEFT JOIN commodity c ON b.id = c.brand_id";
		int count= -1;
		
		try {
			rs=this.executeQuery(sql, null);
			rs.next();
			count=rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeALL(rs);
		}
		
		return count;
	}
	//获取品牌列表，可以根据品牌名称查询
	public List<Brand> getBrandInfo(String brand_name,int currPageNo, int numsPerPage) {
		List<Brand> brands = new ArrayList<Brand>();
		ResultSet rs=null;
		String WhereBrand_name="";
		if(brand_name !=null){
			WhereBrand_name="WHERE b.brand_name='"+brand_name+"'";
		}
		String sql = "SELECT b.id,b.brand_name,b.brand_letter,b.sort,b.isShow,COUNT(c.Commodity_Id) AS COUNT "+
					"FROM brand b LEFT JOIN commodity c ON b.id = c.brand_id "+WhereBrand_name+
					"GROUP BY b.id "
				+"LIMIT ?,?";
		if(currPageNo==1){
			currPageNo=currPageNo-1;
		}else{
			currPageNo=(currPageNo-1)*numsPerPage;
		}
		if(brand_name !=null){
			rs = this.executeQuery(sql, brand_name,currPageNo,numsPerPage);
		}else{
			rs = this.executeQuery(sql, currPageNo,numsPerPage);
		}

		try {
			while(rs.next()){
				Brand brand = new Brand();
				brand.setId(rs.getInt("id"));
				brand.setBrand_name(rs.getString("brand_name"));
				brand.setBrand_letter(rs.getString("brand_letter"));
				brand.setSort(rs.getInt("sort"));
				brand.setIsShow(rs.getInt("isShow"));
				brand.setCommodCount(rs.getInt("count"));
				brands.add(brand);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return brands;
	}
	public int getBrandInfoCount(String brand_name){
		String sql="SELECT count(*) from brand ";
		ResultSet rs=null;
		int num=-1;
		if(brand_name!=null){
			sql+="WHERE b.brand_name=?";
			rs=this.executeQuery(sql,brand_name);
		}else{
			rs=this.executeQuery(sql);
		}
		try {
			rs.next();
			num=rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}
}
