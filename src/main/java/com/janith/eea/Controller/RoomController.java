package com.janith.eea.Controller;

import com.janith.eea.Dto.ClassRoomDto;
import com.janith.eea.Service.ClassRoomService;
import com.janith.eea.Service.ClassRoomServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/api/mobile/")
public class RoomController {

    @Autowired
    private ClassRoomService classRoomService;

    @PostMapping("/add_room/")
    public HashMap<String, String> addARoom(@RequestBody ClassRoomDto classRoomDto) throws Exception {
        HashMap<String, String> message = new HashMap<>();

//        ClassRoomDto classRoomDto =  new ClassRoomDto();
//
//        classRoomDto.setRoomType(request.get("roomType"));
//        classRoomDto.setRoomCapacity( Integer.parseInt(request.get("capacity")));
        try {
            classRoomService.addRoom(classRoomDto);

            message.put("result", "Added");
        } catch (Exception ex) {
            message.put("result", ex.getMessage());
            return message;
        }
        return message;
    }

}
