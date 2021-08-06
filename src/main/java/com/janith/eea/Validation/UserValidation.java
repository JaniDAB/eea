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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    String  regexEmail = "^[\\w.+\\-]+@gmail\\.com$";
 String emailRegex = "^(([^<>()\\[\\]\\\\.,;:\\s@\"]+(\\.[^<>()\\[\\]\\\\.,;:\\s@\"]+)*)|(\".+\"))@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        Pattern p = Pattern.compile(regexEmail);
        Matcher matcher = p.matcher(user.getEmail());
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");

        if(user.getUsername().trim().length() < 5 || user.getUsername().trim().length() > 30){
            errors.rejectValue("username", "Size.userForm.username");
        }
        if(userRepository.findUsersByUsername(user.getUsername()) != null){
            errors.rejectValue("username", "Duplicate.userForm.username");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty");

        if(!matcher.matches()){
            errors.rejectValue("email", "regex.email.!equals");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "role", "NotEmpty");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "gender", "NotGEmpty");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dateOfBirth", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mobile", "NotEmpty");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstname", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastname", "NotEmpty");


    }






}
