package com.example;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Role {
    @JsonProperty()
    /**
     * User role name
     */
    private String role;

    public Role(){}
    public Role(String role){
        this.role = role;
    }
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
