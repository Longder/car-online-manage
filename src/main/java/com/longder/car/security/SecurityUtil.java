package com.longder.car.security;

import com.longder.car.entity.po.SysUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Created by Longder
 */
public class SecurityUtil {
    /**
     * 获取当前登录用户
     *
     * @return 当前登录用户
     */
    public static SysUser getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            return null;
        } else if ("anonymoususer".equalsIgnoreCase(String.valueOf(authentication.getPrincipal()))) {
            return null;
        }
        return authentication.getPrincipal() instanceof SysUser ? (SysUser) authentication.getPrincipal() : null;
    }
}
