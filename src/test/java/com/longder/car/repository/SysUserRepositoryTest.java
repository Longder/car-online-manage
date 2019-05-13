package com.longder.car.repository;

import com.longder.car.BaseTest;
import com.longder.car.entity.po.SysUser;
import org.junit.Assert;
import org.junit.Test;

import javax.annotation.Resource;

public class SysUserRepositoryTest extends BaseTest {

    @Resource
    private SysUserRepository sysUserRepository;

    @Test
    public void testGetOne(){
        SysUser sysUser = sysUserRepository.getOne(1L);
        Assert.assertNotNull(sysUser);
        Assert.assertEquals("admin",sysUser.getLoginName());
    }

    @Test
    public void testInsert(){
        SysUser sysUser = new SysUser();
        sysUser.setName("test");
        sysUser.setLoginName("testLoginName");
        sysUser.setPassword("1234");
        sysUserRepository.insert(sysUser);
        System.out.println(sysUser.getId());

    }
}
