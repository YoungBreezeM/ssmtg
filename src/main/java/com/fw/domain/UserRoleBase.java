package com.fw.domain;

import java.io.Serializable;

public class UserRoleBase implements Serializable {
    private Integer ur_id;
    private Integer uid;
    private Integer rid;

    public Integer getUr_id() {
        return ur_id;
    }

    public void setUr_id(Integer ur_id) {
        this.ur_id = ur_id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    @Override
    public String toString() {
        return "UserRoleBase{" +
                "ur_id=" + ur_id +
                ", uid=" + uid +
                ", rid=" + rid +
                '}';
    }
}
