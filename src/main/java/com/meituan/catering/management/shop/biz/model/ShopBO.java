package com.meituan.catering.management.shop.biz.model;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author 邓紫棋的小跟班-YU.
 * @version 1.0
 * @date 2022/4/22 16:39
 */
@Data
@Component
public class ShopBO {
    private String tenantId;
    private Long businessNo;
    private String name;
    private String businessType;
    private String managementType;
    private ContactBO contact;
    private OpeningHoursBO openingHours;
    private String businessArea;
    private String comment;
    private Boolean enabled;
}
