package com.longder.car.repository;


import com.longder.car.BaseTest;
import com.longder.car.entity.po.SysUserRole;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

public class SysUserRoleRepositoryTest extends BaseTest {
    @Resource
    private SysUserRoleRepository sysUserRoleRepository;

    @Test
    public void testListBySysUserId(){
        List<SysUserRole> sysUserRoleList = sysUserRoleRepository.listBySysUserId(1L);
        System.out.println(sysUserRoleList.size());
    }
}
