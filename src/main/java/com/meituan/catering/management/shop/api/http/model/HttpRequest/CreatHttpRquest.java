package com.meituan.catering.management.shop.api.http.model.HttpRequest;

import lombok.Data;

/**
 * @author 邓紫棋的小跟班-YU.
 * @version 1.0
 * @date 2022/4/23 19:59
 */
@Data
public class CreatHttpRquest {
    private String prefix;
    private String shopName;
    private Integer businessType;
    private Integer managementType;
    //店铺联系方式
    private String name;
    private String address;
    private String cellphone;
    private String telephone;
    //营业时间
    private String start;
    private String end;
    //
    private String businessArea;
    private String comment;
    private Boolean enabled;

}
