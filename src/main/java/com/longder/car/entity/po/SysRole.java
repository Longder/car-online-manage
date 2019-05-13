package com.longder.car.entity.po;


import org.springframework.security.core.GrantedAuthority;

/**
 * 系统角色枚举
 */
public enum SysRole implements GrantedAuthority {
    ROLE_ADMIN("ROLE_ADMIN","管理员","系统管理员"),
    ROLE_USER("ROLE_USER","普通用户","普通用户");
    /**
     * 名称
     */
    private String name;
    /**
     * 展示名
     */
    private String displayName;
    /**
     * 描述
     */
    private String describe;

    SysRole(String name, String displayName, String describe) {
        this.name = name;
        this.displayName = displayName;
        this.describe = describe;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    @Override
    public String getAuthority() {
        return this.name;
    }

    public boolean equals(SysRole role){
        return this.name.equals(role.name);
    }
}
