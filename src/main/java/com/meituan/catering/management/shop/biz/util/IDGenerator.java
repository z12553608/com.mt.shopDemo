package com.meituan.catering.management.shop.biz.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


/**
 * @author 邓紫棋的小跟班-YU.
 * @version 1.0
 * @date 2022/4/22 17:16
 */
public class IDGenerator {
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
    /**
     * 生成租户号
     */
    public static String generateID(String prefix) {
        if (prefix==null) {
            throw new IllegalArgumentException("参数不齐");
        }
        String time = LocalDate.now().format(formatter);
        return prefix + time;
    }
    /**
     * 生成商铺号
     */
    public static Long generateNo() {
        //时间戳转(毫秒)换为十位Long型
        return Long.valueOf(String.format("%010d", System.currentTimeMillis()/1000));
    }

    public static void main(String[] args) {
        System.out.println(generateID("TX"));
        System.out.println(generateNo());
    }

}
