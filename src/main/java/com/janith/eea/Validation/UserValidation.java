package com.janith.eea.Validation;

import com.janith.eea.Dto.UserDto;
import com.janith.eea.Model.User;
import com.janith.eea.Repository.UserRepository;
import com.janith.eea.Service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidation implements Validator {

    @Autowired
    private final UserServiceImpl userService;

    @Autowired
    private final UserRepository userRepository;

    public UserValidation(UserServiceImpl userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }


    @Override
    public boolean supports(Class<?> aClass) {
        return UserDto.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
 UserDto user= (UserDto) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
        if(user.getUsername().length() < 6 || user.getUsername().length() > 32){
            errors.rejectValue("username", "Size.userForm.username");
        }
        if(userRepository.findUsersByUsername(user.getUsername()) != null){
            errors.rejectValue("username", "Duplicate.userForm.username");
        }


    }





}
