package com.sdut.product.pojo;

/**
 * @ClassName RolePermission
 * @Discription
 * @Author yinyuchen
 * @Date 2019/4/3 10:54
 **/
public class RolePermission {
    private String roleId;
    private String permissionId;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
    }
}
