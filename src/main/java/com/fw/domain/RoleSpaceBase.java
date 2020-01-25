package com.fw.domain;

import java.io.Serializable;

public class RoleSpaceBase implements Serializable {

    private Integer rs_id;
    private Integer rid;
    private Integer sid;
    private Boolean hasSelect;
    private Boolean hasInsert;
    private Boolean hasUpdate;
    private Boolean hasDelete;

    public Integer getRs_id() {
        return rs_id;
    }

    public void setRs_id(Integer rs_id) {
        this.rs_id = rs_id;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Boolean getHasSelect() {
        return hasSelect;
    }

    public void setHasSelect(Boolean hasSelect) {
        this.hasSelect = hasSelect;
    }

    public Boolean getHasInsert() {
        return hasInsert;
    }

    public void setHasInsert(Boolean hasInsert) {
        this.hasInsert = hasInsert;
    }

    public Boolean getHasUpdate() {
        return hasUpdate;
    }

    public void setHasUpdate(Boolean hasUpdate) {
        this.hasUpdate = hasUpdate;
    }

    public Boolean getHasDelete() {
        return hasDelete;
    }

    public void setHasDelete(Boolean hasDelete) {
        this.hasDelete = hasDelete;
    }

    @Override
    public String toString() {
        return "roleSpaceBase{" +
                "rs_id=" + rs_id +
                ", rid=" + rid +
                ", sid=" + sid +
                ", hasSelect=" + hasSelect +
                ", hasInsert=" + hasInsert +
                ", hasUpdate=" + hasUpdate +
                ", hasDelete=" + hasDelete +
                '}';
    }
}
