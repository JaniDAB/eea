package com.janith.eea;

import com.janith.eea.Dto.BatchDto;
import com.janith.eea.Dto.ClassRoomDto;
import com.janith.eea.Dto.UserDto;
import com.janith.eea.Model.ClassRoom;
import com.janith.eea.Model.User;
import com.janith.eea.Service.*;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreatedDTO {

    @Autowired
    private ModuleService moduleService;

    @Autowired
    private UserService userService;

    @Autowired
    private BatchService batchService;


    @Autowired
    private ClassRoomService classRoomService;

    @Autowired
    private TimeTableService timeTableService;

    public String roomCreation() throws Exception {
        ClassRoomDto room  =  new ClassRoomDto();

        room.setRoomId("L4CR5");
        room.setRoomType("Hall");
        room.setRoomCapacity(20);

        ClassRoom r = classRoomService.addRoom(room);

        return r.getRoomId();
    }

    public int batchCreat() throws Exception {
        BatchDto batchDto  =  new BatchDto();

        batchDto.setBatchCode("HF1242SEeng");
        batchDto.setDescription("Netowrk sTUDENTS");

        return  batchService.save(batchDto).getBatchID();
    }


    public int studentCreate() throws Exception {
     UserDto newdto=   new UserDto();

     newdto.setUsername("JanithD");
     newdto.setFirstname("janith");
     newdto.setLastname("Dabare");
     newdto.setEmail("janithdabare17@gmail.com");
     newdto.setGender("MALE");
     newdto.setRole("STUDENT");
     newdto.setMobile("0716123463");
     newdto.setDateOfBirth("2001-10-10");

User userDto = userService.save(newdto);
return userDto.getUserId();
    }

    public String createStudentToBeDeleted(int userID) throws Exception {

        UserDto newdto=   new UserDto();

        newdto.setUsername("jDelete");
        newdto.setFirstname("janith");
        newdto.setLastname("Dabare");
        newdto.setEmail("janithdabare17@gmail.com");
        newdto.setGender("MALE");
        newdto.setRole("STUDENT");
        newdto.setMobile("0716123463");
        newdto.setDateOfBirth("2001-10-10");

        return userService.save(newdto).getUsername();
    }

    public String createStudentWithSameUsername( ) throws Exception {

        UserDto newdto=   new UserDto();

        newdto.setUsername("dddddd");
        newdto.setFirstname("janith");
        newdto.setLastname("Dabare");
        newdto.setEmail("janithdabare17@gmail.com");
        newdto.setGender("MALE");
        newdto.setRole("STUDENT");
        newdto.setMobile("0716123463");
        newdto.setDateOfBirth("2001-10-10");

        return userService.save(newdto).getUsername();
    }
}
