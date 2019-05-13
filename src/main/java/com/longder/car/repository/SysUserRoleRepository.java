package com.longder.car.repository;

import com.longder.car.entity.po.SysUserRole;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysUserRoleRepository {

    @Select("SELECT * FROM SYS_USER_ROLE WHERE sys_user_id_ = #{sysUserId}")
    @ResultMap("com.longder.car.repository.SysUserRoleRepository.SysUserRoleResultMap")
    List<SysUserRole> listBySysUserId(Long sysUserId);

    @Insert("INSERT INTO SYS_USER_ROLE(sys_user_id_,role_) VALUES(#{sysUserId},#{sysRole})")
    void insert(SysUserRole sysUserRole);
}
