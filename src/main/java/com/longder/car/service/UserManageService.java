package com.longder.car.service;

import com.longder.car.entity.po.SysRole;
import com.longder.car.entity.po.SysUser;

import java.util.List;

public interface UserManageService {
    /**
     * 保存一个用户，新增和修改都可用
     * @param sysUser
     * @param role
     */
    void saveOneUser(SysUser sysUser, SysRole role);

    /**
     * 检查登录名
     * @param loginName
     * @return true:可以注册  false：不能注册
     */
    Boolean checkLoginName(String loginName);

    /**
     * 普通用户的列表
     * @return
     */
    List<SysUser> listCommonUser();

    /**
     * 删除一个用户
     * @param userId
     */
    void deleteUser(Long userId);

    /**
     * 修改密码
     * @param newPassword
     */
    void changePassword(String newPassword);
}
