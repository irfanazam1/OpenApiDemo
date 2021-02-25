package com.example;


import com.fasterxml.jackson.annotation.JsonProperty;

public class User {

    @JsonProperty
    private String id;

    @JsonProperty
    private String name;

    @JsonProperty
    private Role role;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
