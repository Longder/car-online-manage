package com.longder.car.service.impl;

import com.longder.car.entity.po.SysRole;
import com.longder.car.entity.po.SysUser;
import com.longder.car.entity.po.SysUserRole;
import com.longder.car.repository.SysUserRepository;
import com.longder.car.repository.SysUserRoleRepository;
import com.longder.car.service.UserManageService;
import com.longder.car.util.EncryptionUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;

/**
 * 用户管理业务
 */
@Service
public class UserManageServiceImpl implements UserManageService {
    @Resource
    private SysUserRepository sysUserRepository;
    @Resource
    private SysUserRoleRepository sysUserRoleRepository;
    /**
     * 保存一个用户，新增和修改都可用
     *
     * @param sysUser
     * @param role
     */
    @Override
    @Transactional
    public void saveOneUser(SysUser sysUser, SysRole role) {
        if(ObjectUtils.isEmpty(sysUser.getId())){//空的 新增
            //处理下密码
            sysUser.setPassword(EncryptionUtil.encrypt(sysUser.getPassword()));
            sysUserRepository.insert(sysUser);
            SysUserRole userRole = new SysUserRole(sysUser.getId(),role);
            sysUserRoleRepository.insert(userRole);
        }
    }
}
