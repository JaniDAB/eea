package com.janith.eea.Controller;

import com.janith.eea.Dto.ClassRoomDto;
import com.janith.eea.Dto.UserDto;
import com.janith.eea.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/mobile/")
public class UserCon {

    @Autowired
    private UserService userService;


    @PostMapping("/add_user/")
    public HashMap<String, String> addAUser(@RequestBody UserDto userDto) throws Exception {
        HashMap<String, String> message = new HashMap<>();

//        ClassRoomDto classRoomDto =  new ClassRoomDto();
//
//        classRoomDto.setRoomType(request.get("roomType"));
//        classRoomDto.setRoomCapacity( Integer.parseInt(request.get("capacity")));
        try {
           userService.save(userDto);

            message.put("result", "Added");
        } catch (Exception ex) {
            message.put("result", ex.getMessage());
            return message;
        }
        return message;
    }

    @GetMapping("/view_students/")
    public List<UserDto> viewStudents(){

        return  userService.getAllStudentToAPI();
    }

}
