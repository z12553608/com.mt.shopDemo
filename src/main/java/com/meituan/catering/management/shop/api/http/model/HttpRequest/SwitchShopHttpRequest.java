package com.meituan.catering.management.shop.api.http.model.HttpRequest;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author 邓紫棋的小跟班-YU.
 * @version 1.0
 * @date 2022/4/25 9:18
 */
@Data
public class SwitchShopHttpRequest {
    //商铺号索引
    @ApiModelProperty(value="商铺id",name="businessNo",example="3113552765")
    private Long businessNo;
    //店铺开店关店
    @ApiModelProperty(value="商铺状态",name="enabled",example="true")
    private Boolean enabled;
}
