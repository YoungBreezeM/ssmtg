package com.fw.domain;

import java.io.Serializable;


public class Role implements Serializable {
    private Integer rid;
    private String roleName;
    private Integer power;
    private String roleDescribe;


    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public String getroleDescribe() {
        return roleDescribe;
    }

    public void setroleDescribe(String roleDescribe) {
        this.roleDescribe = roleDescribe;
    }

    @Override
    public String toString() {
        return "Role{" +
                "rid=" + rid +
                ", roleName='" + roleName + '\'' +
                ", power=" + power +
                ", roleDescribe='" + roleDescribe + '\'' +
                '}';
    }
}
