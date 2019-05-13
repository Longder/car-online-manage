package com.longder.car.service;

import com.longder.car.entity.po.SysRole;
import com.longder.car.entity.po.SysUser;

public interface UserManageService {
    /**
     * 保存一个用户，新增和修改都可用
     * @param sysUser
     * @param role
     */
    void saveOneUser(SysUser sysUser, SysRole role);
}
