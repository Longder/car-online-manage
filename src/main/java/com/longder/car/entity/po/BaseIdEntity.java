package com.longder.car.entity.po;

import lombok.Data;

import java.io.Serializable;

@Data
public class BaseIdEntity implements Serializable {
    /**
     * 主键
     */
    private Long id;
}
