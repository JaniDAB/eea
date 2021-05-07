package com.janith.eea.WebController;

import com.janith.eea.Dto.UserDto;
import com.janith.eea.Model.User;
import com.janith.eea.Service.UserServiceImpl;
import com.janith.eea.Util.UserTypeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

@Controller
public class AuthenticationController {

    @Autowired
    private UserServiceImpl userService;


    @GetMapping("/login")
    public String getLogin() {
//        User user = userService.getUser(auth.getName());
//        if(user.getRole().getRoleName() == UserTypeUtil.ADMIN){
//
//        }
        return "login";
    }

    @GetMapping("/afterlogin")
    public String afterLogin(Authentication auth){
        User user = userService.getUser(auth.getName());
        if (user.getRole().getRoleName() == UserTypeUtil.STUDENT) {
            return "/studentHome";
        }
        if (user.getRole().getRoleName() == UserTypeUtil.ADMIN){
            return "/adminHome";
        }
        if (user.getRole().getRoleName() == UserTypeUtil.LECTURER){
            return "/lecturerHome";
        }

        System.out.println("REACHED AFTER LOGIN");
        return "/login";

    }


    @GetMapping("/add")
    public String adduser(Model m) {
        m.addAttribute("user", new UserDto());
        return "addUser";
    }

    @GetMapping("/admin")
    public String adminHome() {
        return "adminHome";
    }

    @GetMapping("/home")
    public String Home() {
        return "/login";
    }


//    @PostConstruct
//    public  void  init(){
//        userService.save(new UserDto("janith", "janith", "daba", "janith@gmail.com","janith123","0712323","student"));
//    }

}
