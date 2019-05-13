package com.longder.car.service;

import com.longder.car.BaseTest;
import com.longder.car.entity.po.SysRole;
import com.longder.car.entity.po.SysUser;
import org.junit.Test;

import javax.annotation.Resource;

public class UserManageServiceTest extends BaseTest {
    @Resource
    private UserManageService userManageService;

    @Test
    public void testSaveUser(){
        SysUser sysUser = new SysUser();
        sysUser.setName("test");
        sysUser.setLoginName("testLoginName");
        sysUser.setPassword("1234");
        userManageService.saveOneUser(sysUser, SysRole.ROLE_USER);
    }
}
