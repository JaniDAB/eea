package com.janith.eea.Dto;

import com.janith.eea.Model.User;

public class Response {


    private String state;
    private String type;
    private UserDto user;

    public Response(String state, String type, UserDto user) {
        this.state = state;
        this.type = type;
        this.user = user;
    }

    public Response() {
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }
}
