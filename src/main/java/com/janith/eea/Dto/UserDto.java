package com.janith.eea.Dto;

import com.janith.eea.Model.Batch;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
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
    private Batch batch;

}
