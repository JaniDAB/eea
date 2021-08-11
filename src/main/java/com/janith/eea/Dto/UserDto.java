package com.janith.eea.Dto;

import com.janith.eea.Model.Batch;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.parameters.P;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;


@NoArgsConstructor
public class UserDto {
    @Getter
    @Setter
    private Integer userId;

    @Getter
    @Setter
    private String username;


    @Getter
    @Setter
    private String firstname;


    @Getter
    @Setter
    private String lastname;


    @Getter
    @Setter
    @Email
    private String email;


    @Getter
    @Setter
    private String password;


    @Getter
    @Setter
    private String mobile;

    @Getter
    @Setter
    private String role;


    @Getter
    @Setter
    private String dateOfBirth;

    @Getter
    @Setter
    private String gender;


    @Getter
    @Setter
    private String batchCode;

    @Getter
    @Setter
    private Batch batch;

    public UserDto( String username, String firstname, String lastname, @Email String email, String password, String mobile, String role, String dateOfBirth, String gender, Batch batch) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.mobile = mobile;
        this.role = role;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.batch = batch;
    }

    public UserDto(String username, String firstname, String lastname, @Email String email, String mobile, String role, String dateOfBirth, String gender) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.mobile = mobile;
        this.role = role;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
    }
}
