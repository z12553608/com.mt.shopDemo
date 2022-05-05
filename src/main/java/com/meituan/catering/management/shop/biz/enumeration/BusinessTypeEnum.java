package com.meituan.catering.management.shop.biz.enumeration;

/**
 * @author 邓紫棋的小跟班-YU.
 * @version 1.0
 * @date 2022/4/23 0:00
 */
public enum BusinessTypeEnum {
    DiINNER(1, "正餐"),
    FAST_FOOD(2, "快餐"),
    HOT_POT(3, "火锅"),
    BARBECUE(4, "烧烤"),
    WESTERN_FOOD(5, "西餐");
    private int code;
    private String name;

    BusinessTypeEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public static String valueOf(int id) {
        for (BusinessTypeEnum item : BusinessTypeEnum.values()) {
            if (id == item.code) {
                return item.name;
            }
        }
        return null;
    }
}
