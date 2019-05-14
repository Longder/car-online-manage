package com.longder.car.repository;

import com.longder.car.entity.po.SysUser;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

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
    @Insert("INSERT INTO SYS_USER(name_,login_name_,password_,gender_,active_,phone_) values(#{name},#{loginName},#{password},#{gender},#{active},#{phone})")
    void insert(SysUser sysUser);

    /**
     * 根据用户名查询
     * @param loginName
     * @return
     */
    @Select("SELECT * FROM SYS_USER WHERE login_name_=#{loginName}")
    @ResultMap("com.longder.car.repository.SysUserRepository.SysUserResultMap")
    SysUser getByLoginName(String loginName);

    /**
     * 查询所有普通用户
     * @return
     */
    @Select("SELECT U.* FROM SYS_USER U LEFT JOIN SYS_USER_ROLE UR on U.id_ = UR.sys_user_id_ WHERE UR.role_ = 'ROLE_USER'")
    @ResultMap("com.longder.car.repository.SysUserRepository.SysUserResultMap")
    List<SysUser> listCommonUser();

    /**
     * 删除用户
     * @param id
     */
    @Delete("DELETE FROM SYS_USER WHERE id_ = #{id}")
    void deleteById(Long id);

    /**
     * 修改用户
     * @param sysUser
     */
    @Update("UPDATE SYS_USER SET login_name_= #{loginName},name_ = #{name},password_ = #{password},gender_ = #{gender} WHERE id_ = #{id}")
    void update(SysUser sysUser);
}
