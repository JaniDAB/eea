package com.janith.eea.Dto;

import java.io.Serializable;

public class JwtResponse implements Serializable {

    private static final long serialVersionUID = -8091879091924046844L;
    private final String jwtToken;

    private Integer userId;



    private String requestState;

    private String userType;

    private String username;

    private String firstName;

    private String lastName;

    public JwtResponse(String jwtToken, Integer userId, String requestState, String userType, String username, String firstName, String lastName) {
        this.jwtToken = jwtToken;
        this.userId = userId;
        this.requestState = requestState;
        this.userType = userType;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getRequestState() {
        return requestState;
    }

    public void setRequestState(String requestState) {
        this.requestState = requestState;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
