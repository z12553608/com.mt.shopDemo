package com.meituan.catering.management.shop.biz.service;

import com.meituan.catering.management.shop.api.http.model.HttpRequest.CreatHttpRquest;
import com.meituan.catering.management.shop.api.http.model.HttpRequest.SwitchShopHttpRequest;
import com.meituan.catering.management.shop.api.http.model.HttpRequest.UpdateHttpRequest;
import com.meituan.catering.management.shop.biz.model.ShopBO;
import com.meituan.catering.management.shop.api.http.model.HttpResponse.CommonResponse;
import com.meituan.catering.management.shop.dao.model.request.SearchShopDataRequest;
import com.meituan.catering.management.shop.dao.model.response.SearchShopDataResponse;

import java.util.List;


/**
 * @author 邓紫棋的小跟班-YU.
 * @version 1.0
 * @date 2022/4/22 17:16
 */
public interface ShopService {
    CommonResponse<ShopBO> findByBusinessNo(Long businessNo);
    CommonResponse<?> creatShop(CreatHttpRquest creatShop);
    CommonResponse<?> update(UpdateHttpRequest update);
    CommonResponse<?> switchShop(SwitchShopHttpRequest request);
    CommonResponse<SearchShopDataResponse> findAll(SearchShopDataRequest request);
}
