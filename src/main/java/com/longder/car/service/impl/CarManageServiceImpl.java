package com.longder.car.service.impl;

import com.longder.car.entity.po.Car;
import com.longder.car.entity.po.SysUser;
import com.longder.car.repository.CarRepository;
import com.longder.car.security.SecurityUtil;
import com.longder.car.service.CarManageService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Longder
 */
@Service
public class CarManageServiceImpl implements CarManageService {

    @Resource
    private CarRepository carRepository;

    /**
     * 存储新增一辆车
     *
     * @param car
     */
    @Override
    @Transactional
    public void saveOneCar(Car car) {
        //取当前用户
        SysUser currentUser = SecurityUtil.getCurrentUser();
        assert currentUser != null;
        car.setSysUserId(currentUser.getId());
        carRepository.insert(car);
    }

    /**
     * 查看当前用户名下的车辆
     *
     * @return
     */
    @Override
    public List<Car> listCarForCurrentUser() {
        //取当前用户
        SysUser currentUser = SecurityUtil.getCurrentUser();
        assert currentUser != null;
        return carRepository.listByUserId(currentUser.getId());
    }

    /**
     * 查看某个用户名下的车辆
     *
     * @param userId
     * @return
     */
    @Override
    public List<Car> listCarForUser(Long userId) {
        return carRepository.listByUserId(userId);
    }

    /**
     * 通过id获取一辆汽车
     *
     * @param carId
     * @return
     */
    @Override
    public Car getOneCar(Long carId) {
        return carRepository.getOne(carId);
    }

    /**
     * 解绑一辆车
     *
     * @param carId
     */
    @Override
    @Transactional
    public void deleteOneCar(Long carId) {
        carRepository.delete(carId);
    }
}
