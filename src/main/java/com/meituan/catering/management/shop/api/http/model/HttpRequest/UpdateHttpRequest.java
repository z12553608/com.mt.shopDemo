package com.meituan.catering.management.shop.api.http.model.HttpRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 邓紫棋的小跟班-YU.
 * @version 1.0
 * @date 2022/4/24 14:11
 */
@Data
public class UpdateHttpRequest {
    //需要商铺NO进行索引
    private String tenantId;
    private Long businessNo;
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
