package com.janith.eea.WebController;

import com.janith.eea.Dto.ModuleDto;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
/**
 * All the  controllers need to lecturer (User)
 * @author janith dabare
 */
@Controller
@PreAuthorize("hasAuthority('LECTURER')")
public class LecturerController {


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

    public LecturerController(TimeTableServiceImpl timeTableService, BatchServiceImpl batchService, ModuleService moduleService, UserServiceImpl service, BatchValidator batchValidator) {
        this.timeTableService = timeTableService;
        this.batchService = batchService;
        this.moduleService = moduleService;
        this.service = service;
        this.batchValidator = batchValidator;
    }


    @GetMapping("/lecturer/getUpdateForm/{id}")
    public  String  getUpdateFormLecturer(@PathVariable(value = "id") int id , Model u)
    {
        try {
            UserDto userDto = new UserDto();
            UserDto userinfo = service.getUserById(id);
            u.addAttribute("userinfo", userinfo);
            u.addAttribute("lecturer", userDto);
            return "lecturerUpdate";
        } catch (Exception ex) {
            System.out.println(ex);
            u.addAttribute("lecturer", new UserDto());
            return "lecturerUpdate";
        }
    }
    @PostMapping("/lecturer/Updateform")
    public String updateLecturer(@ModelAttribute("lecturer") UserDto userDto , Model m)
    {
        try {
            final User update = service.updateStudent(userDto); // change service method
            m.addAttribute("Updated", "Updated Successfully");
            return "lecturerUpdate";
        }catch (Exception e){
            m.addAttribute("error", "  UnSuccessful");
            return "lecturerUpdate";
        }
    }

    @GetMapping("/lecturer/timetable/{id}")
    public String getLecturerTimetable(@PathVariable(value = "id") int id, Model timetable)
    {

        List<TimetableDto> timetableDtoList = timeTableService.getAllTimeTablestoLecturer(id);
        timetable.addAttribute("timetableList" , timetableDtoList);

        return "viewLecturerTimetable";

    }

    @GetMapping("/lecturer/timetables")
    public String getLecturerTimetableToday( Model timetable, Authentication auth)
    {
        // take the list from timetable list of current date.
        List<TimetableDto> timetableDtoLists = timeTableService.getTodayTablesByDate(service.getUser(auth.getName()).getUserId());

        // binding  the collected list to JSP
        timetable.addAttribute("timetableList" , timetableDtoLists);
        return "viewLecturerTimetable";

    }
    @GetMapping("/lecturer/search")
    public String getLecturerTimetable(Authentication auth , Model timetable , HttpServletRequest req)
    {   String date = req.getParameter("date");

        List<TimetableDto> timetableDtoList = timeTableService.searchLecturerTimetable(service.getUser(auth.getName()).getUserId(),date );
        timetable.addAttribute("timetableList" , timetableDtoList);

        return "viewLecturerTimetable";

    }


    @GetMapping("/getLecturerModuleList/{userID}")
    public String getModuleListLecturer(@PathVariable( name = "userID") int UserID, Model m)
    {
        try {
            List<ModuleDto> modelInfoList = moduleService.viewLecsModules(UserID);

            m.addAttribute("moduleInfoList", modelInfoList);

            return "LecturerModules";
        } catch (Exception ex) {
            System.out.println("Module not found"+ex);

            return "LecturerModules";
        }

    }


}
