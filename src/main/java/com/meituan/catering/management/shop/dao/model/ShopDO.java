package com.meituan.catering.management.shop.dao.model;
import lombok.Data;


/**
 * @author 邓紫棋的小跟班-YU.
 * @version 1.0
 * @date 2022/4/22 16:03
 */
@Data
public class ShopDO {
    private String tenantId;
    private Long businessNo;
    private String shopName;
    private Integer businessType;
    private Integer managementType;
    private String contact;
    private String openingHours;
    private String businessArea;
    private String comment;
    private Boolean enabled;

}
