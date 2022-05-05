package com.meituan.catering.management.shop.biz.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.meituan.catering.management.shop.biz.model.ContactBO;
import com.meituan.catering.management.shop.biz.model.OpeningHoursBO;


/**
 * @author 邓紫棋的小跟班-YU.
 * @version 1.0
 * @date 2022/4/22 17:16
 */
public class JSONConvert {
    public static String ContactToJson(String name, String adress, String cellPhone, String telphone) {
        ContactBO concat = new ContactBO();
        concat.setName(name);
        concat.setAddress(adress != null ? adress : "");
        concat.setCellphone(cellPhone != null ? cellPhone :"");
        concat.setTelephone(telphone != null ? telphone : "");
        return JSONObject.toJSON(concat).toString();
    }
    //联系方式带参
    public static String ContactToJson(ContactBO bo,String name, String adress, String cellPhone, String telphone) {
        ContactBO contacts = new ContactBO();
        contacts.setName(name !=null? name: bo.getName());
        contacts.setAddress(adress != null ? adress : bo.getAddress());
        contacts.setCellphone(cellPhone != null ? cellPhone : bo.getCellphone());
        contacts.setTelephone(telphone != null ? telphone : bo.getTelephone());
        return JSONObject.toJSON(contacts).toString();
    }
    //新增营业时间参数赋值
    public static String OpenHoursToJson(String start, String end) {
        OpeningHoursBO open = new OpeningHoursBO();
        open.setStart(start);
        open.setEnd(end);
        return JSONObject.toJSON(open).toString();
    }
    //营业时间带参
    public static String OpenHoursToJson(OpeningHoursBO bo,String start, String end) {
        OpeningHoursBO open = new OpeningHoursBO();
        open.setStart(start != null ? start : bo.getStart());
        open.setEnd(end != null ? end : bo.getEnd());
        return JSONObject.toJSON(open).toString();
    }
    public static ContactBO JsonToContact(String contact){
         return  JSONArray.parseObject(contact,ContactBO.class);
    }
    public static OpeningHoursBO JsonToOpenHours(String openHours){
        return  JSONArray.parseObject(openHours,OpeningHoursBO.class);
    }
}

