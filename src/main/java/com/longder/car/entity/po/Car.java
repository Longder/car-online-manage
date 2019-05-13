package com.longder.car.entity.po;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created by Longder
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class Car extends BaseIdEntity{
    /**
     * 系统用户
     */
    private Long sysUserId;

    /**
     * 车牌号
     */
    private String license;

    /**
     * 汽车品牌
     */
    private String brand;

    /**
     * 发动机排量
     */
    private String displacement;
}
