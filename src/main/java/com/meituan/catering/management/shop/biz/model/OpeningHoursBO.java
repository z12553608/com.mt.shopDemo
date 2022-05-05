package com.meituan.catering.management.shop.biz.model;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author 邓紫棋的小跟班-YU.
 * @version 1.0
 * @date 2022/4/22 19:45
 */
@Data
@Component
public class OpeningHoursBO {
    private String start;
    private String end;
}
