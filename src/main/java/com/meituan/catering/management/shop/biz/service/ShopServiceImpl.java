package com.meituan.catering.management.shop.biz.service;

import com.meituan.catering.management.shop.api.http.model.HttpRequest.CreatHttpRquest;
import com.meituan.catering.management.shop.api.http.model.HttpRequest.SwitchShopHttpRequest;
import com.meituan.catering.management.shop.api.http.model.HttpRequest.UpdateHttpRequest;
import com.meituan.catering.management.shop.api.http.model.HttpResponse.CommonResponse;
import com.meituan.catering.management.shop.biz.model.response.ContactBizResponse;
import com.meituan.catering.management.shop.biz.BOconvert.DoConvertBo;
import com.meituan.catering.management.shop.biz.model.OpeningHoursBO;
import com.meituan.catering.management.shop.dao.model.request.SearchShopDataRequest;
import com.meituan.catering.management.shop.dao.model.response.SearchShopDataResponse;
import org.springframework.transaction.support.TransactionTemplate;
import com.meituan.catering.management.shop.dao.mapper.ShopMapper;
import com.meituan.catering.management.shop.biz.util.IDGenerator;
import com.meituan.catering.management.shop.biz.util.JSONConvert;
import com.meituan.catering.management.shop.biz.model.ContactBO;
import com.meituan.catering.management.shop.biz.model.ShopBO;
import com.meituan.catering.management.shop.dao.model.ShopDO;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @author 邓紫棋的小跟班-YU.
 * @version 1.0
 * @date 2022/4/22 16:14
 */
@Service
@Slf4j
public class ShopServiceImpl implements ShopService {
    @Resource
    private TransactionTemplate transactionTemplate;
    @Resource
    private ShopMapper shopMapper;

    @Override
    @Transactional(rollbackFor = Throwable.class, readOnly = true)
    public CommonResponse<ShopBO> findByBusinessNo(Long businessNo) {
        //根据商铺号查询店铺信息
        ShopDO response = shopMapper.findByBusinessNo(businessNo);
        //判断是否有信息
        if (response != null) {
            return CommonResponse.ok(DoConvertBo.convertBo(response));
        } else {
            return CommonResponse.ok();
        }
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public CommonResponse<?> creatShop(CreatHttpRquest creatShop) {
        if (creatShop == null) {
            return CommonResponse.fail(701, "参数不齐");
        }
        //生成ID
        String tenantId = IDGenerator.generateID(creatShop.getPrefix());
        Long businessNo = IDGenerator.generateNo();
        //创建DO对象
        ShopDO shop = new ShopDO();
        //赋值
        shop.setTenantId(tenantId);
        shop.setBusinessNo(businessNo);
        //联系方式转json
        shop.setContact(JSONConvert.ContactToJson(creatShop.getName(),
                creatShop.getAddress(),
                creatShop.getCellphone(),
                creatShop.getTelephone()));
        //营业时间转json
        shop.setOpeningHours(JSONConvert.OpenHoursToJson(creatShop.getStart(), creatShop.getEnd()));
        //拷贝
        try {
            BeanUtils.copyProperties(shop, creatShop);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("拷贝对象出错");
        }
        transactionTemplate.executeWithoutResult(status -> {
            int response = shopMapper.creatShop(shop);
            if (response != 1) {
                status.setRollbackOnly();
                log.error("插入失败");
                throw new IllegalStateException();
            }
        });
        return CommonResponse.ok();
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public CommonResponse<?> update(UpdateHttpRequest update) {
        if (update == null) {
            return CommonResponse.fail(701, "参数不齐");
        }
        ShopDO shop = new ShopDO();
        try {
            BeanUtils.copyProperties(shop, update);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("拷贝对象出错");
        }
        ContactBizResponse response = shopMapper.searchJson(update.getBusinessNo());
        ContactBO conBo = JSONConvert.JsonToContact(response.getContact());
        OpeningHoursBO openBo = JSONConvert.JsonToOpenHours(response.getOpeningHours());
        shop.setContact(JSONConvert.ContactToJson(conBo, update.getName(), update.getAddress(),
                update.getCellphone(), update.getTelephone()));
        shop.setOpeningHours(JSONConvert.OpenHoursToJson(openBo, update.getStart(), update.getEnd()));
        transactionTemplate.executeWithoutResult(status -> {
            int res = shopMapper.updateShop(shop);
            if (res != 1) {
                status.setRollbackOnly();
                log.error("修改失败");
                throw new IllegalStateException();
            }
        });
        return CommonResponse.ok();
    }

    @Override
    public CommonResponse<?> switchShop(SwitchShopHttpRequest request) {
        if (request == null) {
            return CommonResponse.fail(701, "需要的参数不全");
        }
        ShopDO shop = new ShopDO();
        try {
            BeanUtils.copyProperties(shop, request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (shopMapper.updateShop(shop) == 0) {
            return CommonResponse.fail(500, "服务器错误，修改失败！");
        }
        return CommonResponse.ok();
    }

    @Override
    public CommonResponse<SearchShopDataResponse> findAll(SearchShopDataRequest request) {
        SearchShopDataResponse response = new SearchShopDataResponse();
        try {
            int total = shopMapper.findAllCount(request);
            List<ShopDO> shopDOs = shopMapper.findAll(request);
            response.setTotalCount(total);
            //得到的结果转为对应字符
            response.setShops(DoConvertBo.convertBo(shopDOs));
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResponse.fail(500, "服务器错误");
        }
        return CommonResponse.ok(response);
    }
}
