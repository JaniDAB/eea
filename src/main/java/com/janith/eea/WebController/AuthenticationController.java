package com.janith.eea.WebController;

import com.janith.eea.Dto.UserDto;
import com.janith.eea.Service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.PostConstruct;

@Controller
public class AuthenticationController {

    @Autowired
    private UserServiceImpl userService;


    @GetMapping("/login")
    public String getLogin(){
        return "login";
    }

    @GetMapping("/add")
    public String adduser(){
        return "addUser";
    }

    @GetMapping("/admin")
    public String adminHome(){
        return "adminHome";
    }
    @GetMapping("/home")
    public String Home(){
        return "home";
    }


//    @PostConstruct
//    public  void  init(){
//        userService.save(new UserDto("janith", "janith", "daba", "janith@gmail.com","janith123","0712323","student"));
//    }

}
