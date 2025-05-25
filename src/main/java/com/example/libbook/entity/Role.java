package com.example.libbook.entity;


public class Role {

    private int roleId;
    private String roleName;


    public Role( int roleId1, String roleName1) {
        this.roleId = roleId1;
        this.roleName = roleName1;

    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                '}';
    }}