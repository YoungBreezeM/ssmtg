package com.fw.domain;


import java.io.Serializable;
import java.util.List;

public class RoleSpace implements Serializable{
    private Role role;
    private List<Space> spaces;
    private Space space;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Space> getSpaces() {
        return spaces;
    }

    public void setSpaces(List<Space> spaces) {
        this.spaces = spaces;
    }

    public Space getSpace() {
        return space;
    }

    public void setSpace(Space space) {
        this.space = space;
    }


    @Override
    public String toString() {
        return "RoleSpace{" +
                ", role=" + role +
                ", spaces=" + spaces +
                ", space=" + space +
                '}';
    }
}
