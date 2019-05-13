package com.longder.car.repository;

import com.longder.car.entity.po.SysUser;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Repository
public interface SysUserRepository {

    /**
     * 根据id查询一个
     * @param id
     * @return
     */
    @Select("SELECT * FROM SYS_USER WHERE id_=#{id}")
    @ResultMap("com.longder.car.repository.SysUserRepository.SysUserResultMap")
    SysUser getOne(Long id);

    /**
     * 新增插入一个用户
     * @param sysUser
     * @return 受影响的条数
     */
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("INSERT INTO SYS_USER(name_,login_name_,password_,gender_,active_) values(#{name},#{loginName},#{password},#{gender},#{active})")
    void insert(SysUser sysUser);

    /**
     * 根据用户名查询
     * @param loginName
     * @return
     */
    @Select("SELECT * FROM SYS_USER WHERE login_name_=#{loginName}")
    @ResultMap("com.longder.car.repository.SysUserRepository.SysUserResultMap")
    SysUser getByLoginName(String loginName);
}
