package com.meituan.catering.management.shop.api.http.controller;

import com.meituan.catering.management.shop.api.http.model.HttpRequest.CreatHttpRquest;
import com.meituan.catering.management.shop.api.http.model.HttpRequest.SwitchShopHttpRequest;
import com.meituan.catering.management.shop.api.http.model.HttpRequest.UpdateHttpRequest;
import com.meituan.catering.management.shop.biz.model.ShopBO;
import com.meituan.catering.management.shop.api.http.model.HttpResponse.CommonResponse;
import com.meituan.catering.management.shop.biz.service.ShopServiceImpl;
import com.meituan.catering.management.shop.dao.model.request.SearchShopDataRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.Example;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author 邓紫棋的小跟班-YU.
 * @version 1.0
 * @date 2022/4/22 15:25
 */
@RestController
public class ShopController {
    @Resource
    private ShopServiceImpl shopService;
    /**
     * 根据商铺号查询
     * **/
    @GetMapping("/findShopById/{businessNo}")
    public CommonResponse<ShopBO> findShopByBusinessNo(@PathVariable Long businessNo){
        return  shopService.findByBusinessNo(businessNo);
    }
    /**
     * 添加商铺
     * **/
    @PutMapping("/createShop")
    public CommonResponse<?> creat(@RequestBody CreatHttpRquest creat){
        return shopService.creatShop(creat);
    }
    /**
     * 修改门店信息
     * **/
    @PutMapping("/update")
    public CommonResponse<?> update(@RequestBody UpdateHttpRequest update){
        return shopService.update(update);
    }

    /**
     * 开关门店
     * **/
    @PutMapping("/switchShop")
    public CommonResponse<?> switchShop(SwitchShopHttpRequest shop){
        return  shopService.switchShop(shop);
    }
    /**
     * 分页查询
     * **/
    @GetMapping("/searchAll")
    public CommonResponse<?> findAll(@RequestBody SearchShopDataRequest request){
        return shopService.findAll(request);
    }
}
