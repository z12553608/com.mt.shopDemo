package com.meituan.catering.management.shop.biz.BOconvert;

import com.alibaba.fastjson.JSONObject;
import com.meituan.catering.management.shop.biz.enumeration.BusinessTypeEnum;
import com.meituan.catering.management.shop.biz.enumeration.EnabledEnum;
import com.meituan.catering.management.shop.biz.model.ContactBO;
import com.meituan.catering.management.shop.biz.model.OpeningHoursBO;
import com.meituan.catering.management.shop.biz.model.ShopBO;
import com.meituan.catering.management.shop.dao.model.ShopDO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 邓紫棋的小跟班-YU.
 * @version 1.0
 * @date 2022/4/22 18:51
 */
@Component
public class DoConvertBo {
    public static ShopBO convertBo(ShopDO shopDO){
        ShopBO shopBO =new ShopBO();
        shopBO.setBusinessNo(shopDO.getBusinessNo());
        shopBO.setTenantId(shopDO.getTenantId());
        shopBO.setName(shopDO.getShopName());
        //枚举转换成对应字符串
        shopBO.setBusinessType(BusinessTypeEnum.valueOf(shopDO.getBusinessType()));
        shopBO.setManagementType(EnabledEnum.valueOf(shopDO.getManagementType()));
        //JSON转对象
        shopBO.setContact(JSONObject.toJavaObject(JSONObject.parseObject(shopDO.getContact()),ContactBO.class));
        shopBO.setOpeningHours(JSONObject.toJavaObject(JSONObject.parseObject(shopDO.getOpeningHours()),
                OpeningHoursBO.class));
        shopBO.setBusinessArea(shopDO.getBusinessArea());
        shopBO.setComment(shopDO.getComment());
        shopBO.setEnabled(shopDO.getEnabled());
        return shopBO;
    }
    public static List<ShopBO> convertBo(List<ShopDO> shopDO){
        List<ShopBO> list=new ArrayList<>();
        for (ShopDO item:shopDO){
            ShopBO BO =new ShopBO();
            BO.setBusinessNo(item.getBusinessNo());
            BO.setTenantId(item.getTenantId());
            BO.setName(item.getShopName());
            //枚举转换成对应字符串
            BO.setBusinessType(BusinessTypeEnum.valueOf(item.getBusinessType()));
            BO.setManagementType(EnabledEnum.valueOf(item.getManagementType()));
            //JSON转对象
            BO.setContact(JSONObject.toJavaObject(JSONObject.parseObject(item.getContact()),ContactBO.class));
            BO.setOpeningHours(JSONObject.toJavaObject(JSONObject.parseObject(item.getOpeningHours()),
                    OpeningHoursBO.class));
            BO.setBusinessArea(item.getBusinessArea());
            BO.setComment(item.getComment());
            BO.setEnabled(item.getEnabled());
            
            list.add(BO);
        }
        return list;
    }
}
