package com.longder.car.repository;

import com.longder.car.entity.po.Car;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Longder
 */
@Repository
public interface CarRepository {

    /**
     * 新增插入一个车
     * @param sysUser
     * @return 受影响的条数
     */
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("INSERT INTO CAR(sys_user_id_,license_,brand_,displacement_) values(#{sysUserId},#{license},#{brand},#{displacement})")
    void insert(Car sysUser);

    /**
     * 更具用户查询车辆
     * @param sysUserId
     * @return
     */
    @Select("SELECT * FROM CAR WHERE sys_user_id_ = #{sysUserId}")
    @ResultMap("com.longder.car.repository.CarRepository.CarResultMap")
    List<Car> listByUserId(Long sysUserId);
}
