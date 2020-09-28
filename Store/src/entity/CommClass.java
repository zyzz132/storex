package entity;
//商品分类实体类
public class CommClass {
    private int CommClass_ID;           //商品分类ID
    private int parentClass;            //上级分类id
    private String CommClass_Name;      //分类名称
    private int isShow;                 //是否显示
    private int isNavShow;              //是否在导航显示
    private String keyWrod;             //关键词
    private String ClassDescribe;       //分类描述
    private int sort;                   //排序
    private int CommodiyCount;          //分类下的商品数量

    public CommClass(int commClass_ID, int parentClass, String commClass_Name, int isShow, int isNavShow,
			String keyWrod, String classDescribe, int sort, int commodiyCount) {
		super();
		CommClass_ID = commClass_ID;
		this.parentClass = parentClass;
		CommClass_Name = commClass_Name;
		this.isShow = isShow;
		this.isNavShow = isNavShow;
		this.keyWrod = keyWrod;
		ClassDescribe = classDescribe;
		this.sort = sort;
		CommodiyCount = commodiyCount;
	}

	public int getCommodiyCount() {
		return CommodiyCount;
	}

	public void setCommodiyCount(int commodiyCount) {
		CommodiyCount = commodiyCount;
	}

	public int getCommClass_ID() {
        return CommClass_ID;
    }

    public void setCommClass_ID(int commClass_ID) {
        CommClass_ID = commClass_ID;
    }

    public int getParentClass() {
        return parentClass;
    }

    public void setParentClass(int parentClass) {
        this.parentClass = parentClass;
    }

    public String getCommClass_Name() {
        return CommClass_Name;
    }

    public void setCommClass_Name(String commClass_Name) {
        CommClass_Name = commClass_Name;
    }

    public int getIsShow() {
        return isShow;
    }

    public void setIsShow(int isShow) {
        this.isShow = isShow;
    }

    public int getIsNavShow() {
        return isNavShow;
    }

    public void setIsNavShow(int isNavShow) {
        this.isNavShow = isNavShow;
    }

    public String getKeyWrod() {
        return keyWrod;
    }

    public void setKeyWrod(String keyWrod) {
        this.keyWrod = keyWrod;
    }

    public String getClassDescribe() {
        return ClassDescribe;
    }

    public void setClassDescribe(String classDescribe) {
        ClassDescribe = classDescribe;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public CommClass(int commClass_ID, int parentClass, String commClass_Name, int isShow, int isNavShow, String keyWrod, String classDescribe, int sort) {
        CommClass_ID = commClass_ID;
        this.parentClass = parentClass;
        CommClass_Name = commClass_Name;
        this.isShow = isShow;
        this.isNavShow = isNavShow;
        this.keyWrod = keyWrod;
        ClassDescribe = classDescribe;
        this.sort = sort;
    }

    public CommClass(int parentClass, String commClass_Name, int isShow, int isNavShow, String keyWrod, String classDescribe, int sort) {
        this.parentClass = parentClass;
        CommClass_Name = commClass_Name;
        this.isShow = isShow;
        this.isNavShow = isNavShow;
        this.keyWrod = keyWrod;
        ClassDescribe = classDescribe;
        this.sort = sort;
    }
}
