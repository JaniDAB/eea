package com.janith.eea.WebController;

import com.janith.eea.Dto.BatchDto;
import com.janith.eea.Dto.UserDto;
import com.janith.eea.Model.User;
import com.janith.eea.Service.BatchService;
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
import java.util.List;

/**
 * Login will be handled here
 * @author janith dabare
 */
@Controller
public class AuthenticationController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private BatchService batchService;


    @GetMapping("/login")
    public String getLogin() {
//        User user = userService.getUser(auth.getName());
//        if(user.getRole().getRoleName() == UserTypeUtil.ADMIN){
//
//        }
        return "login";
    }

    @GetMapping("/afterlogin")
    public String afterLogin(Authentication auth , Model a){
        User user = userService.getUser(auth.getName());

        if (user.getRole().getRoleName() == UserTypeUtil.STUDENT) {
            a.addAttribute("student", user);
            System.out.println( user.getBatch().getBatchCode());

            return "redirect:/student";
        }
       else if (user.getRole().getRoleName() == UserTypeUtil.ADMIN){

            return "redirect:/admin";
        }
        else if (user.getRole().getRoleName() == UserTypeUtil.LECTURER){
            a.addAttribute("lecturer", user);

            return "LecturerHome";
        }
else
        return "/login"; // /login

    }


    @GetMapping("/add")
    public String adduser(Model m) {

        List<BatchDto>  batchDtoList =  batchService.getAllBatches();
        m.addAttribute("user", new UserDto());
        m.addAttribute("batchList" , batchDtoList);
        return "addUser";
    }

    @GetMapping("/admin")
    public String adminHome() {

        return "adminHome";
    }

    @GetMapping("/student")
    public String studentHome(Authentication auth,Model a) {
        User user = userService.getUser(auth.getName());
        a.addAttribute("student", user);
        return "studentHome";
    }

    @GetMapping("/lecturer")
    public String lecturerHome(Authentication auth,Model a) {
        User user = userService.getUser(auth.getName());
        a.addAttribute("lecturer", user);
        return "LecturerHome";
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
