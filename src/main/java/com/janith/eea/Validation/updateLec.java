package com.janith.eea.Validation;

import com.janith.eea.Dto.UserDto;
import com.janith.eea.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class updateLec implements Validator {

    @Autowired
    private final UserRepository userRepository;

    public updateLec(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return UserDto.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        UserDto user= (UserDto) o;

        String regexPhoneNumber = "^(?:0|94|\\+94)?(?:(11|21|23|24|25|26|27|31|32|33|34|35|36|37|38|41|45|47|51|52|54|55|57|63|65|66|67|81|912)(0|2|3|4|5|7|9)|7(0|1|2|5|6|7|8)\\d)\\d{6}$";

        String emailRegex = "^(([^<>()\\[\\]\\\\.,;:\\s@\"]+(\\.[^<>()\\[\\]\\\\.,;:\\s@\"]+)*)|(\".+\"))@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        Pattern p = Pattern.compile(emailRegex);
        Matcher matcher = p.matcher(user.getEmail());

        Pattern mobp = Pattern.compile(regexPhoneNumber);
        Matcher matcherM = mobp.matcher(user.getMobile());


        if (userRepository.findUsersByEmail(user.getEmail()) != null) {
            // changed done return null;
            errors.rejectValue("email", "Duplicate.userForm.email");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty");

        if(!matcher.matches()){
            errors.rejectValue("email", "regex.email.!equals");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mobile", "NotEmpty");

        if(!matcherM.matches()){
            errors.rejectValue("mobile", "regex.mobile.!equals");
        }


    }
}
