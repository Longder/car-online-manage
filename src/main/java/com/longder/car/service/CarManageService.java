package com.longder.car.service;

import com.longder.car.entity.po.Car;

import java.util.List;

/**
 * 车辆管理业务
 * Created by Longder
 */
public interface CarManageService {
    /**
     * 存储新增一辆车
     * @param car
     */
    void saveOneCar(Car car);

    /**
     * 查看当前用户名下的车辆
     * @return
     */
    List<Car> listCarForCurrentUser();
}
