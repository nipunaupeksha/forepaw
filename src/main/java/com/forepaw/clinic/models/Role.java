package com.forepaw.clinic.models;

public class Role {
    private String roleId;
    private String roleName;
    private String rolePriority;
    private String roleDescription;

    public Role() {
    }

    public Role(String roleId, String roleName, String rolePriority, String roleDescription) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.rolePriority = rolePriority;
        this.roleDescription = roleDescription;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRolePriority() {
        return rolePriority;
    }

    public void setRolePriority(String rolePriority) {
        this.rolePriority = rolePriority;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }
}
