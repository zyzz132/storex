package Impl;

import java.util.List;
import entity.commodity_px;

//接口
public interface commodity_pximpl {
    //增加
    int Addcommodity_px(commodity_px cp);
    //删除
    int Delcommodity_px(int com_id);
    //修改
    int Updcommodity_px(int com_id);
    //查询
    commodity_px Selcommodity_px(int Commodity_id);

}
