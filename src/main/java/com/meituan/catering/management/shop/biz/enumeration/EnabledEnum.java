package com.meituan.catering.management.shop.biz.enumeration;

/**
 * @author 邓紫棋的小跟班-YU.
 * @version 1.0
 * @date 2022/4/23 0:01
 */
public enum EnabledEnum {
    MANUfFACTURER(1, "直营"),
    JOININ(2, "加盟"),
    ;
    private int code;
    private String name;

    EnabledEnum(int code, String name) {
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
        for (EnabledEnum item : EnabledEnum.values()) {
            if (id == item.code) {
                return item.name;
            }
        }
        return null;
    }
}
