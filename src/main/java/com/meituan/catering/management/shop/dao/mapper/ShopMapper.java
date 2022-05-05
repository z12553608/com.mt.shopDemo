package com.meituan.catering.management.shop.dao.mapper;

import com.meituan.catering.management.shop.biz.model.response.ContactBizResponse;
import com.meituan.catering.management.shop.dao.model.ShopDO;
import com.meituan.catering.management.shop.dao.model.request.SearchShopDataRequest;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

/**
 * @author 邓紫棋的小跟班-YU.
 * @version 1.0
 * @date 2022/4/22 16:15
 */
@Mapper
public interface ShopMapper {
    Integer findAllCount(SearchShopDataRequest request);
    List<ShopDO> findAll(SearchShopDataRequest request);
    ShopDO findByBusinessNo(Long businessNo);
    int creatShop(ShopDO shopDO);
    int updateShop(ShopDO shopDO);
    //biz层根据商铺号查询对应的JSON数据
    ContactBizResponse searchJson(Long businessNo);
}
