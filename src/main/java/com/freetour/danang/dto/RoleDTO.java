package com.freetour.danang.dto;

import javax.persistence.Column;
import java.util.List;

public class RoleDTO {
    private Long id;
    private String roleName;
    private List<UserDTO> users ;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<UserDTO> getUsers() {
        return users;
    }

    public void setUsers(List<UserDTO> users) {
        this.users = users;
    }
}
