package com.longder.car.controller;

import com.longder.car.entity.po.Car;
import com.longder.car.service.CarManageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * 汽车管理的控制器
 */
@Controller
@RequestMapping("/admin/car")
public class CarManageController {

    @Resource
    private CarManageService carManageService;
    /**
     * 车辆列表
     * @return
     */
    @GetMapping("/list")
    public String list(Model model){
        model.addAttribute("carList",carManageService.listCarForCurrentUser());
        return "car/list-for-user";
    }

    /**
     * 车辆详情modal
     * @return
     */
    @GetMapping("/detail")
    public String detail(Long carId,Model model){
        model.addAttribute("car",carManageService.getOneCar(carId));
        return "car/car-detail";
    }

    /**
     * 去添加汽车
     * @return
     */
    @GetMapping("/toAdd")
    public String toAdd(){
        return "car/add-car-modal";
    }

    /**
     * 添加车辆
     * @return
     */
    @PostMapping("/add")
    public String add(Car car){
        carManageService.saveOneCar(car);
        return "redirect:/admin/car/list";
    }

    /**
     * 解除绑定汽车
     * @param carId
     * @return
     */
    @GetMapping("/delete")
    public String deleteCar(Long carId){
        carManageService.deleteOneCar(carId);
        return "redirect:/admin/car/list";
    }
}
