package com.fw.domain;

import java.io.Serializable;

public class Space implements Serializable {
    private Integer sid;
    private String spaceName;
    private String path;
    private Boolean hasSelect;
    private Boolean hasUpdate;
    private Boolean hasInsert;
    private Boolean hasDelete;

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSpaceName() {
        return spaceName;
    }

    public void setSpaceName(String spaceName) {
        this.spaceName = spaceName;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Boolean getHasSelect() {
        return hasSelect;
    }

    public void setHasSelect(Boolean hasSelect) {
        this.hasSelect = hasSelect;
    }

    public Boolean getHasUpdate() {
        return hasUpdate;
    }

    public void setHasUpdate(Boolean hasUpdate) {
        this.hasUpdate = hasUpdate;
    }

    public Boolean getHasInsert() {
        return hasInsert;
    }

    public void setHasInsert(Boolean hasInsert) {
        this.hasInsert = hasInsert;
    }

    public Boolean getHasDelete() {
        return hasDelete;
    }

    public void setHasDelete(Boolean hasDelete) {
        this.hasDelete = hasDelete;
    }

    @Override
    public String toString() {
        return "Space{" +
                "sid=" + sid +
                ", spaceName='" + spaceName + '\'' +
                ", path='" + path + '\'' +
                ", hasSelect=" + hasSelect +
                ", hasUpdate=" + hasUpdate +
                ", hasInsert=" + hasInsert +
                ", hasDelete=" + hasDelete +
                '}';
    }
}
