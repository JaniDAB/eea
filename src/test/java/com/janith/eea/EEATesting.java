package com.janith.eea;

import com.janith.eea.Dto.ModuleDto;
import com.janith.eea.Model.*;

import com.janith.eea.Model.Module;
import com.janith.eea.Repository.*;
import com.janith.eea.Service.*;

import com.janith.eea.Util.UserTypeUtil;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EEATesting extends Module {

    @Autowired
   private ModuleServiceImpl moduleService;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private BatchServiceImpl batchService;


    @Autowired
    private ClassRoomServiceImpl classRoomService;

    @Autowired
    private TimeTableServiceImpl timeTableService;

    @MockBean
private ModuleRepository moduleRepository;

    @MockBean
    private UserRepository userRepository;
    @MockBean
    private BatchRepository batchRepository;

    @MockBean
    private ClassRoomRepository classRoomRepository;

    @MockBean
    private TimetableRepository timetableRepository;




    @Test
    @DisplayName("Test Should pass when module is added successfully")
    public void addModule() throws Exception{
//        ModuleDto moduleDto =  new ModuleDto("English");

//       Module module =  moduleService.save(moduleDto);

        when(moduleRepository.findAll()).thenReturn
                (Stream.of(
                        new Module("COSE1223","English" ),
                        new Module( "COSE2221","Network"))
                        .collect(Collectors.toList()));
assertEquals(2, moduleService.getAllModules().size());
    }
    @Test
    public void addUser(){
        UserRole userRole = new UserRole();
        userRole.setRoleName(UserTypeUtil.STUDENT);

        when(userRepository.findAll()).thenReturn(
                Stream.of(new User("JanithD","janith","Dabare","janithdabare17@gmail.com",
                        "1234567","0761346373","2001-10-10","Male",userRole ),
                        new User("JD","venuli","Rana","Venuli@gmail.com",
                                "1234567","0761346373","2001-06-10","Female",userRole )
                ).collect(Collectors.toList()));
        assertEquals(2,userService.getAllUsers().size());
    }

//    @Test
//    public  void addAndViewBatch(){
//        when(batchRepository.findAll()).thenReturn(
//                Stream.of(new Batch("HF2131SEeng","sOFTWARE enGINEERING"),
//                        new Batch("HNSF12sSA","JDSDAA")
//                ).collect(Collectors.toList()));
//        assertEquals(2,batchService.getAllBatches().size());
//    }


    @Test
    public  void addAndViewClassRoom(){
        when(classRoomRepository.findAll()).thenReturn(
                Stream.of(new ClassRoom("L4CR1","Hall",20),
                        new ClassRoom("L5CR1","Lab",15)
                ).collect(Collectors.toList()));
        assertEquals(2,classRoomService.viewRooms().size());
    }

    @Test
    public  void addAndViewModules(){
        when(classRoomRepository.findAll()).thenReturn(
                Stream.of(new ClassRoom("L4CR1","Hall",20),
                        new ClassRoom("L5CR1","Lab",15)
                ).collect(Collectors.toList()));
        assertEquals(2,classRoomService.viewRooms().size());
    }



    @Test
    public  void addAndViewSchedule(){

        ClassRoom room =new ClassRoom();
        room.setRoomId("L4CR5");
        room.setRoomCapacity(20);
        room.setRoomType("Hall");

        Module module = new Module();
        module.setModule_id(1);
        module.setModuleName("test");
        module.setModuleCode("cccddd");


        Batch batch1 = new Batch();
        batch1.setBatchID(1);
        batch1.setDescription("ddsdsds");
        batch1.setBatchCode("ccdddd");

        List<Batch> batchList = new ArrayList<>();
        batchList.add(batch1);
        Date date = new Date(System.currentTimeMillis());
        LocalTime startTime = LocalTime.parse("10:00");
        LocalTime endTime = LocalTime.parse("11:00");


        when(timetableRepository.findAll()).thenReturn(
                Stream.of(new Timetable(date,startTime,endTime,room,batchList,module)

                ).collect(Collectors.toList()));
        assertEquals(1,timeTableService.getAllTimeTables().size());
    }





}
