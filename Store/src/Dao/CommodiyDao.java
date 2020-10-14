package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.CommClass;
import entity.Commodity;
import entity.commodity_px;

public class CommodiyDao extends BaseDao{
	Connection conn=null;
	PreparedStatement ps=null;
	//添加商品信息
	public int AddCommodity(Commodity commd){
		String addCommoditySql="INSERT INTO commodity VALUES(NULL,?,?,NOW(),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		int num=update(addCommoditySql, commd.getCommodity_Name(),
				commd.getCommClass_Id(),
				commd.getSubname(),
				commd.getUnit(),
				commd.getBrand_id(),
				commd.getCommodity_No(),
				commd.getWarehousing(),
				commd.getSort(),
				commd.getSelling_price(),
				commd.getMarket_price(),
				commd.getWeight(),
				commd.getCommodity_introduce(),
				commd.getPutaway(),
				commd.getNew_recommend(),
				commd.getRecommend(),
				commd.getGuarantee1(),
				commd.getGuarantee2(),
				commd.getGuarantee3());
		if(num>=1){
			String selectIDsql="SELECT Commodity_Id FROM commodity WHERE Commodity_name=? AND subname=? AND market_price=? AND unit=?";
			ResultSet rs=executeQuery(conn,ps,selectIDsql, commd.getCommodity_Name(),
					commd.getSubname(),
					commd.getMarket_price(),
					commd.getUnit());
			
			try {
				if(rs.next()){
					commd.setCommodity_Id(rs.getInt("Commodity_Id"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				closeALL(rs,ps,conn);
			}
			if(commd.getCommodity_Id()>0){//判断商品是否添加成功
				//添加商品规格
				CommoidyTypeDao ctdao=new CommoidyTypeDao();
				for(int i=0;i<commd.getCommTypeList().size();i++){
					commd.getCommTypeList().get(i).setCommodity_Id(commd.getCommodity_Id());
					num=ctdao.AddCommType(commd.getCommTypeList().get(i));
					if(num==0){
						return num;
					}
				}
				//添加商品相册
				CommodityImageDao commimageDao=new CommodityImageDao();
				for(int i=0;i<commd.getImageList().size();i++){
					commd.getImageList().get(i).setCommodity_id(commd.getCommodity_Id());
					num=commimageDao.AddCommdoityImage(commd.getImageList().get(i));
					if(num==0){
						return num;
					}
				}
				//添加商品详情
				commodity_pxDao pxDao=new commodity_pxDao();
				commd.getParticulars().setCommodity_id(commd.getCommodity_Id());
				num=pxDao.Addcommodity_px(commd.getParticulars());
				if(num==0){
					return num;
				}
			}
			
		}
		return num;
	}
	//获取商品信息
	public List<Commodity> getCommClass(int page, int limit){
    	String sql="SELECT * FROM commodity LIMIT ?,?";
        List<Commodity> list=new ArrayList<Commodity>();
        CommoidyTypeDao ctdao=new CommoidyTypeDao();
        CommodityImageDao cimgdao=new CommodityImageDao();
        Connection conn =getConnection();
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
			ps=conn.prepareStatement(sql);
			if(page>=1){
				ps.setInt(1, (page-1)*limit);

			}
			ps.setInt(2, limit);
			rs=ps.executeQuery();
			while(rs.next()){
				Commodity commd=new Commodity();
				commd.setCommodity_Id(rs.getInt("Commodity_Id"));
				commd.setCommodity_Name(rs.getString("Commodity_name"));
				commd.setCommClass_Id(rs.getInt("CommClass_Id"));
				commd.setTime(rs.getString("CommClass_Id"));
				commd.setSubname(rs.getString("subname"));
				commd.setUnit(rs.getString("unit"));
				commd.setBrand_id(rs.getInt("brand_id"));
				commd.setCommodity_No(rs.getString("Commodity_No"));
				commd.setWarehousing(rs.getInt("warehousing"));
				commd.setSort(rs.getInt("sort"));
				commd.setSelling_price(rs.getDouble("selling_price"));
				commd.setMarket_price(rs.getDouble("market_price"));
				commd.setWeight(rs.getString("weight"));
				commd.setCommodity_introduce(rs.getString("Commodity_introduce"));
				commd.setPutaway(rs.getInt("putaway"));
				commd.setNew_recommend(rs.getInt("new_recommend"));
				commd.setRecommend(rs.getInt("recommend"));
				commd.setGuarantee1(rs.getInt("guarantee1"));
				commd.setGuarantee2(rs.getInt("guarantee2"));
				commd.setGuarantee3(rs.getInt("guarantee3"));

				list.add(commd);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeALL(rs,ps,conn);
		}
        for(int i=0;i<list.size();i++){
        	list.get(i).setCommTypeList(ctdao.getCommID_Types(list.get(i).getCommodity_Id()));
        	list.get(i).setImageList(cimgdao.getCommodityImage(list.get(i).getCommodity_Id()));
		}
        return list;
    }
    public int getcount(){
    	String sql="SELECT COUNT(*) FROM commodity ";
    	Connection conn=getConnection();
    	PreparedStatement ps=null;
    	ResultSet rs=null;
    	int num=0;
    	try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				num=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeALL(rs,ps,conn);
		}
    	
    	return num;
    }
    public Commodity getCommodiyID(String Commodity_name){
		 String sql="SELECT * FROM commodity WHERE Commodity_name=?";
    	 Connection conn =getConnection();
         PreparedStatement ps=null;
         ResultSet rs=null;
         Commodity commodity=null;
         try {
 			ps=conn.prepareStatement(sql);
 			ps.setString(1, Commodity_name);
 			rs=ps.executeQuery();
 			while(rs.next()){
 				commodity=new Commodity();
 				commodity.setCommodity_Id(rs.getInt("Commodity_Id"));
 				commodity.setCommodity_Name(rs.getString("Commodity_name"));
 				commodity.setCommClass_Id(rs.getInt("CommClass_Id"));
 				commodity.setBrand_id(rs.getInt("brand_id"));
 				commodity.setCommodity_introduce(rs.getString("Commodity_introduce"));
 				commodity.setCommodity_No(rs.getString("Commodity_No"));
 				commodity.setMarket_price(rs.getDouble("market_price"));
 				commodity.setSelling_price(rs.getDouble("selling_price"));
 				commodity.setSort(rs.getInt("sort"));
 				commodity.setWeight(rs.getString("weight"));
 				commodity.setWarehousing(rs.getInt("warehousing"));
 				commodity.setUnit(rs.getString("unit"));
 				commodity.setSubname(rs.getString("subname"));
 				commodity.setTime(rs.getString("Time"));
 			}
 		} catch (SQLException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
         return commodity;
    }
    //查询商品ID的信息
	public Commodity getID_Commodiy(int Commodity_Id){
		String sql="SELECT * FROM commodity WHERE Commodity_Id=?";
		Connection conn =getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		Commodity commodity=null;
		CommoidyTypeDao ctdao=new CommoidyTypeDao();
		CommodityImageDao cimgdao=new CommodityImageDao();
		commodity_pxDao pxDao=new commodity_pxDao();
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1,Commodity_Id);
			rs=ps.executeQuery();
			while(rs.next()){
				commodity=new Commodity();
				commodity.setCommodity_Id(rs.getInt("Commodity_Id"));
				commodity.setCommodity_Name(rs.getString("Commodity_name"));
				commodity.setCommClass_Id(rs.getInt("CommClass_Id"));
				commodity.setBrand_id(rs.getInt("brand_id"));
				commodity.setCommodity_introduce(rs.getString("Commodity_introduce"));
				commodity.setCommodity_No(rs.getString("Commodity_No"));
				commodity.setMarket_price(rs.getDouble("market_price"));
				commodity.setSelling_price(rs.getDouble("selling_price"));
				commodity.setSort(rs.getInt("sort"));
				commodity.setWeight(rs.getString("weight"));
				commodity.setWarehousing(rs.getInt("warehousing"));
				commodity.setUnit(rs.getString("unit"));
				commodity.setSubname(rs.getString("subname"));
				commodity.setTime(rs.getString("Time"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			System.out.println("getID_Commodiy-----------");
			closeALL(rs,ps,conn);
		}
		commodity.setCommTypeList(ctdao.getCommID_Types(commodity.getCommodity_Id()));
		commodity.setImageList(cimgdao.getCommodityImage(commodity.getCommodity_Id()));
		commodity.setParticulars(pxDao.Selcommodity_px(commodity.getCommodity_Id()));
		return commodity;
	}
	//修改商品分类是否显示  根据传入的字段值和number值
	public int upstatic(int Commodity_Id,String fieID,int number){
		return update("UPDATE commodity SET "+fieID+" = ? WHERE Commodity_Id = ?",number,Commodity_Id);
	}
	public int DelCommd(int Commodity_Id){
		int num=0;
		Connection conn=getConnection();
		PreparedStatement ps=null;


		try {
			//关闭自动提交
			conn.setAutoCommit(false);
			String delsql1="DELETE FROM commodity WHERE Commodity_Id = ?";
			num=updateAffair(conn,ps,delsql1,Commodity_Id);
			if(num>=1){
				try {
					//删除SKU
					String delsql2="DELETE FROM commodity_type WHERE Commodity_Id=?";
					updateAffair(conn,ps,delsql2,Commodity_Id);
					//删除相册
					String delsql3="DELETE FROM commodity_image WHERE Commodity_Id=?";
					updateAffair(conn,ps,delsql3,Commodity_Id);
					//删除商品详情
					String delsql4="DELETE FROM commodity_px WHERE Commodity_Id=?";
					updateAffair(conn,ps,delsql4,Commodity_Id);
				} catch (Exception e) {
					//事务回滚
					conn.rollback();
					num=0;
				}finally {
					//提交事务
					conn.commit();
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.setAutoCommit(true);
				closeALL(ps,conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return num;
	}
	//随即查询十条数据
	public  List<Commodity> Seltencom(){
		List<Commodity> list=new ArrayList<Commodity>();
		String sql="SELECT * FROM commodity  ORDER BY  RAND() LIMIT 10";
		Connection conn=getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps= conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while (rs.next()){
				Commodity cp=new Commodity();
				cp.setCommodity_Id(rs.getInt("Commodity_Id"));
				cp.setCommodity_Name(rs.getString("Commodity_name"));
				cp.setCommClass_Id(rs.getInt("CommClass_Id"));
				cp.setTime(rs.getString("Time"));
				cp.setSubname(rs.getString("subname"));
				cp.setUnit(rs.getString("unit"));
				cp.setBrand_id(rs.getInt("brand_id"));
				cp.setCommodity_No(rs.getString("Commodity_No"));
				cp.setWarehousing(rs.getInt("warehousing"));
				cp.setSort(rs.getInt("sort"));
				cp.setSelling_price(rs.getDouble("selling_price"));
				cp.setMarket_price(rs.getDouble("market_price"));
				cp.setWeight(rs.getString("weight"));
				cp.setCommodity_introduce(rs.getString("Commodity_introduce"));
				cp.setPutaway(rs.getInt("putaway"));
				cp.setNew_recommend(rs.getInt("new_recommend"));
				cp.setRecommend(rs.getInt("recommend"));
				cp.setGuarantee1(rs.getInt("guarantee1"));
				cp.setGuarantee2(rs.getInt("guarantee2"));
				cp.setGuarantee3(rs.getInt("guarantee3"));
				list.add(cp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeALL(rs,ps,conn);
		}
		return list;
	}
}
