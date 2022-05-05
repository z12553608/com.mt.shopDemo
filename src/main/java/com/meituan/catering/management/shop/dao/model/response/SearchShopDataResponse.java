package com.meituan.catering.management.shop.dao.model.response;

import com.meituan.catering.management.shop.biz.model.ShopBO;
import lombok.Data;

import java.util.LinkedList;
import java.util.List;

/**
 * @author 邓紫棋的小跟班-YU.
 * @version 1.0
 * @date 2022/4/22 17:09
 */
@Data
public class SearchShopDataResponse {
    /**
     * DB中符合条件的数据条数
     **/
    private Integer totalCount;
    /**
     * 当前分页包含的数据对象
     **/
    private List<ShopBO> shops = new LinkedList<>();
}
