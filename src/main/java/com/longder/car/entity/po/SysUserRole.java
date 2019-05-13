package com.longder.car.entity.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

/**
 * 用户角色关联表，实体
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SysUserRole extends BaseIdEntity implements GrantedAuthority {
    /**
     * 用户id
     */
    private Long sysUserId;

    /**
     * 用户角色
     */
    private SysRole sysRole;

    @Override
    public String getAuthority() {
        return sysRole.getName();
    }
}
