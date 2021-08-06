package com.janith.eea.Controller;



import com.janith.eea.Dto.Response;
import com.janith.eea.Dto.UserDto;
import com.janith.eea.Model.User;
import com.janith.eea.Repository.UserRepository;
import com.janith.eea.Service.UserService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/api/mobile/")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

//    ---LOGIN---

    @PostMapping("/login/")
    public Response authenticate(@RequestBody HashMap<String, String> request)  {
        Response jobj = new Response();

        User user = new User();

        user =userRepository.findByUsername(request.get("username"));

        UserDto usdto = new UserDto();


        String pwd = user.getPassword();

        if(user!=null){
            if(userService.passwordencoder(request.get("password"),pwd)){
                usdto.setUsername(user.getUsername());
                usdto.setLastname(user.getLastname());
                usdto.setEmail(user.getEmail());
                jobj.setUser(usdto);
                jobj.setState("Success" );
                jobj.setType(user.getRole().getRoleName().toString());
                return jobj;
            }
            else{
//                jobj.put("username","Invalid");
                jobj.setState("Incorrect");
//                jobj.put("Type","Invalid");
                return jobj;
            }
        }
        else {
            jobj.setState("Invalid");
            return jobj;
        }

    }


}

