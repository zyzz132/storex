package serice;

import Dao.BrandDao;
import entity.Brand;

import java.util.List;

public class BrandSerice {
    //查询品牌数据
    public List<Brand> getBrandInfo(String brand_name, int currPageNo, int numsPerPage){
        BrandDao brandDao=new BrandDao();
        return brandDao.getBrandInfo(brand_name,currPageNo,numsPerPage);
    }
    public int getBrandInfoCount(String brand_name){
        BrandDao brandDao=new BrandDao();
        return brandDao.getBrandInfoCount(brand_name);
    }
}
