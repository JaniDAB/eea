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
import com.janith.eea.Validation.UserValidation;
import com.janith.eea.Validation.updateLec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

/**
 * All the  controllers need to lecturer (User)
 *
 * @author janith dabare
 */
@Controller
@PreAuthorize("hasAuthority('LECTURER')")
public class LecturerController {
    @Autowired
    private updateLec userValidation;

    @Autowired
    private final TimeTableServiceImpl timeTableService;

    @Autowired
    private final BatchServiceImpl batchService;


    @Autowired
    private final ModuleService moduleService;


    @Autowired
    private final UserServiceImpl service;


    @Autowired
    private final BatchValidator batchValidator;

    public LecturerController(TimeTableServiceImpl timeTableService, BatchServiceImpl batchService, ModuleService moduleService, UserServiceImpl service, BatchValidator batchValidator) {
        this.timeTableService = timeTableService;
        this.batchService = batchService;
        this.moduleService = moduleService;
        this.service = service;
        this.batchValidator = batchValidator;
    }


    @GetMapping("/lecturer/getUpdateForm/{id}")
    public String getUpdateFormLecturer(@PathVariable(value = "id") int id, Model u) {
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
    public String updateLecturer(@ModelAttribute("lecturer")@Valid UserDto userDto, BindingResult br, Model m) {
        userValidation.validate(userDto ,br );

        if (br.hasErrors()) {
            return "lecturerUpdate";
        }else

        try {
            final User update = service.updateStudent(userDto); // change service method
            m.addAttribute("Updated", "Updated Successfully");
            return "lecturerUpdate";
        } catch (Exception e) {
            m.addAttribute("error", "  UnSuccessful");
            return "lecturerUpdate";
        }
    }

    @GetMapping("/lecturer/timetable")
    public String getLecturerTimetable(Model timetable, Authentication auth) {
        User user = service.getUser(auth.getName());

        List<TimetableDto> timetableDtoList = timeTableService.getAllTimeTablestoLecturer(user.getUserId());
        timetable.addAttribute("timetableList", timetableDtoList);

        return "viewLecturerTimetable";

    }

    @GetMapping("/lecturer/timetables")
    public String getLecturerTimetableToday(Model timetable, Authentication auth) {
        // take the list from timetable list of current date.
        List<TimetableDto> timetableDtoLists = timeTableService.getTodayTablesByDate(service.getUser(auth.getName()).getUserId());

        // binding  the collected list to JSP
        timetable.addAttribute("timetableList", timetableDtoLists);
        return "viewLecturerTimetable";

    }

    @GetMapping("/lecturer/search")
    public String getLecturerTimetable(Authentication auth, Model timetable, HttpServletRequest req) {
        String date = req.getParameter("date");
        String date2 = req.getParameter("date2");
        List<TimetableDto> timetableDtoList = timeTableService.searchLecturerTimetable(service.getUser(auth.getName()).getUserId(), date , date2);
        timetable.addAttribute("timetableList", timetableDtoList);

        return "viewLecturerTimetable";

    }


    @GetMapping("/getLecturerModuleList/{userID}")
    public String getModuleListLecturer(@PathVariable(name = "userID") int UserID, Model m) {
        try {
            List<ModuleDto> modelInfoList = moduleService.viewLecsModules(UserID);

            m.addAttribute("moduleInfoList", modelInfoList);

            return "LecturerModules";
        } catch (Exception ex) {
            System.out.println("Module not found" + ex);

            return "LecturerModules";
        }

    }

    @GetMapping("/requestReschedule/{id}")
    public String requestReschedule(@PathVariable(value = "id") int tableID, Model mod, RedirectAttributes rd) {
        String s = timeTableService.lecturerRequestReschedule(tableID);
        if (s.equals("done")) {
            rd.addFlashAttribute("rescheduled", " Request for a Reschedule Message Has been Sent to Academic Admin");

        } else {
            mod.addAttribute("error", "Error.....Please try again later.");

        }
        return "redirect:/lecturer/timetable";
    }


}
