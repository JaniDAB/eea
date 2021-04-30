package com.janith.eea.WebController;


import com.janith.eea.Dto.UserDto;
import com.janith.eea.Service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class UserRegistration {

    @Autowired
    private  final UserServiceImpl userService;


    public UserRegistration(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping
    public  String registerUser(@ModelAttribute("user")UserDto registerdto){
        userService.save(registerdto);
        return "redirect:/login";
    }
}
