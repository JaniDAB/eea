package com.janith.eea.WebController;


import com.janith.eea.Dto.UserDto;
import com.janith.eea.Model.User;
import com.janith.eea.Service.UserServiceImpl;
import com.janith.eea.Validation.UserValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/registration")
public class UserRegistration {

    @Autowired
    private  final UserServiceImpl userService;

    @Autowired
    private UserValidation userValidation;

    public UserRegistration(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping
    public  String registerUser(@Valid @ModelAttribute("user")UserDto registerdto, BindingResult br) throws Exception {

userValidation.validate(registerdto ,br );

        if (br.hasErrors()) {
            return "addUser";
        } else {
            final User save = userService.save(registerdto);
            if (save == null) {
/// redirect to already registered page
                return "/alreadyRegistered";
            }
            return "adminHome";

        }
    }

}
