package com.longder.car.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 用户管理的Controller
 */
@Controller
@RequestMapping("/admin/user")
public class UserManageController {

    /**
     * 用户列表
     * @return
     */
    @GetMapping("/list")
    public String toUserList(){
        return "user/list";
    }

    /**
     * 用户下的绑定车辆列表页面
     * @return
     */
    @GetMapping("/userCarList")
    public String userCarList(){
        return "car/list-for-admin-modal";
    }
}
