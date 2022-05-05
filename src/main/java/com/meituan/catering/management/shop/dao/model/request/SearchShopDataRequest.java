package com.meituan.catering.management.shop.dao.model.request;

import lombok.Data;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 邓紫棋的小跟班-YU.
 * @version 1.0
 * @date 2022/4/22 17:05
 */
@Data
public class SearchShopDataRequest {
    /**
     * 分页条件
     **/
    private final Page page = new Page();
    /**
     * 过滤条件
     * **/
    public final Condition condition = new Condition();
    /**
     * 排序条件
     **/
    private final List<OrderByItem> orderBy = new LinkedList<>();
    /**
     * 精准搜索条件
     * **/
    private final Accurate accurate=new Accurate();
    @Data
    private static class Page {
        private Integer index;
        private Integer size;

        public Integer getSkip() {
            if (index == null || size == null) {
                return null;
            }
            return (index - 1) * size;
        }
        public Integer getLimit() {
            return size;
        }
    }
    @Data
    public static class OrderByItem {
        /**
         * 排序字段
         */
        private String field;
        /**
         * 排序方向
         */
        private Direction direction;

        public enum Direction {
            ASC,
            DESC
        }
    }
    @Data
    public static class Condition {
        /**
         * 关键字
         * **/
        private String keys;

        private String getKeysLike() {
            if (keys == null) {
                return null;
            }
            return "%" + keys + "%";
        }
    }
    @Data
    public static class Accurate{
        /**
         * 精准搜索
         * **/
        private Integer businessType;
        private Integer managementType;
        private Boolean enabled;
    }

}
