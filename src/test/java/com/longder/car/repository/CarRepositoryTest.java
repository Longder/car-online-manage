package com.longder.car.repository;

import com.longder.car.BaseTest;
import com.longder.car.entity.po.Car;
import org.junit.Assert;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Longder
 */
public class CarRepositoryTest extends BaseTest {
    @Resource
    private CarRepository carRepository;

    @Test
    public void testInsert(){
        Car car = new Car();
        car.setSysUserId(1L);
        car.setLicense("云A 89J57");
        car.setBrand("斯柯达");
        car.setDisplacement("1.4T");
        carRepository.insert(car);
        Assert.assertNotNull(car.getId());
    }

    @Test
    public void testListByUserId(){
        Long sysUserId = 1L;
        List<Car> carList =  carRepository.listByUserId(sysUserId);
        Assert.assertTrue(carList.size()>0);
    }
}
