package com.janith.eea.WebController;

import com.janith.eea.Dto.TimetableDto;
import com.janith.eea.Dto.UserDto;
import com.janith.eea.Model.User;
import com.janith.eea.Service.BatchServiceImpl;
import com.janith.eea.Service.ModuleService;
import com.janith.eea.Service.TimeTableServiceImpl;
import com.janith.eea.Service.UserServiceImpl;
import com.janith.eea.Validation.BatchValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@PreAuthorize("hasAuthority('STUDENT')")
public class StudentController {


    @Autowired
    private final TimeTableServiceImpl timeTableService;

    @Autowired
    private final BatchServiceImpl batchService;


    @Autowired
    private final ModuleService moduleService;


    @Autowired
    private final UserServiceImpl service;


    @Autowired
    private  final BatchValidator batchValidator;

    public StudentController(TimeTableServiceImpl timeTableService, BatchServiceImpl batchService, ModuleService moduleService, UserServiceImpl service, BatchValidator batchValidator) {
        this.timeTableService = timeTableService;
        this.batchService = batchService;
        this.moduleService = moduleService;
        this.service = service;
        this.batchValidator = batchValidator;
    }


    @GetMapping("/student/getUpdateForm/{id}")
    public  String  getUpdateFormStudent(@PathVariable(value = "id") int id , Model u)
    {
        try {
            UserDto userDto = new UserDto();
            UserDto userinfo = service.getUserById(id);
            u.addAttribute("userinfo", userinfo);
            u.addAttribute("student", userDto);
            return "updateStudent";
        } catch (Exception ex) {
            System.out.println(ex);
            u.addAttribute("student", new UserDto());
            return "updateStudent";
        }
    }

    @PostMapping("/student/Updateform")
    public String updateStudent(@ModelAttribute("student") UserDto userDto , Model m)
    {
        try {
            final User update = service.updateStudent(userDto); // change service method
            m.addAttribute("Updated", "Updated Successfully");
            return "updateStudent";
        }catch (Exception e){
            m.addAttribute("error", "  UnSuccessful");
            return "updateStudent";
        }
    }
    @GetMapping("/student/getPasswordUpdate/{id}")
    public  String  getPasswordUpdateStudent(@PathVariable(value = "id") int id , Model u)
    {
        try {
            UserDto userDto = new UserDto();
            UserDto userinfo = service.getUserById(id);
            u.addAttribute("userinfo", userinfo);
            u.addAttribute("UpdatePassword", userDto);
            return "updateStudentPwd";
        } catch (Exception ex) {
            System.out.println(ex);
            u.addAttribute("UpdatePassword", new UserDto());
            return "updateStudentPwd";
        }
    }
    @PostMapping("/student/updatePassword")
    public String UpdatePassword(@ModelAttribute("UpdatePassword") UserDto userDto , Model m)
    {
        try {
            final User update = service.updatePasswordStudent(userDto); // change service method
            m.addAttribute("Updated", "Updated Successfully");
            return "updateStudentPwd";
        }catch (Exception e){
            m.addAttribute("error", "  UnSuccessful");
            return "updateStudentPwd";
        }
    }





    @GetMapping("/student/timetable/{id}")
    public String getStudentTimetable(@PathVariable(value = "id") int id, Model timetable)
    {
        List<TimetableDto> timetableDtoList = timeTableService.viewTableByBatch(id);

        timetable.addAttribute("timetableList" , timetableDtoList);

        return "viewStudentTimetable";

    }
    @GetMapping("/student/TodayTimetable")
    public String getStudentTimetable(Authentication auth , Model timetable)
    {
        List<TimetableDto> timetableDtoList = timeTableService.getTodayTablesByDateStduents(service.getUser(auth.getName()).getBatch().getBatchID());

        timetable.addAttribute("timetableList" , timetableDtoList);

        return "viewStudentTimetable";

    }



}
