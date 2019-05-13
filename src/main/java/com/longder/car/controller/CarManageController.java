package com.longder.car.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 汽车管理的控制器
 */
@Controller
@RequestMapping("/admin/car")
public class CarManageController {
    /**
     * 车辆列表
     * @return
     */
    @GetMapping("/list")
    public String list(){
        return "car/list-for-user";
    }

    /**
     * 车辆详情
     * @return
     */
    @GetMapping("/detail")
    public String detail(){
        return "car/car-detail-modal";
    }
}
