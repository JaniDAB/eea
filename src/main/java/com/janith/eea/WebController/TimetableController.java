package com.janith.eea.WebController;

import com.janith.eea.Dto.BatchDto;
import com.janith.eea.Dto.ClassRoomDto;
import com.janith.eea.Dto.ModuleDto;
import com.janith.eea.Dto.TimetableDto;
import com.janith.eea.Model.Timetable;
import com.janith.eea.Service.BatchServiceImpl;
import com.janith.eea.Service.ClassRoomServiceImpl;
import com.janith.eea.Service.ModuleServiceImpl;
import com.janith.eea.Service.TimeTableServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class TimetableController {

    @Autowired
    private final TimeTableServiceImpl timeTableService;

    @Autowired
    private final ClassRoomServiceImpl classRoomService;

    @Autowired
    private final ModuleServiceImpl moduleService;

    @Autowired
    private final BatchServiceImpl batchService;

    public TimetableController(TimeTableServiceImpl timeTableService, ClassRoomServiceImpl classRoomService, ModuleServiceImpl moduleService, BatchServiceImpl batchService) {
        this.timeTableService = timeTableService;
        this.classRoomService = classRoomService;
        this.moduleService = moduleService;
        this.batchService = batchService;
    }

    @GetMapping("/addRoom")
    public String AddRoom(Model r) {
        r.addAttribute("addRoom", new ClassRoomDto());
        r.addAttribute("success", "Room Added Successfully");
        return "addClassRoom";
    }

    @PostMapping("/admin/AddRoom")
    public String AddingRoom
            (@Valid
             @ModelAttribute("addRoom") ClassRoomDto classRoomDto,
             Model r,
             BindingResult br) {

        if (br.hasErrors()) {
            r.addAttribute("error", "Room  Was not Added Successfully");
            return "addTimeTable";
        } else {
            try {
                classRoomService.addRoom(classRoomDto);
                r.addAttribute("successful", "Room Added Successfully");

            } catch (Exception ex) {
                r.addAttribute("error", "Room  Was not Added Successfully");
                return "addClassRoom";
            }
        }
        return "addClassRoom";
    }

    @GetMapping("/addTimetable")
    public String addTimetableDirect(Model t) {
        List<ClassRoomDto> classRoomDtoList = classRoomService.viewRooms();
        List<ModuleDto> moduleDtoList = moduleService.getAllModules();
        List<BatchDto>  batchDtoList = batchService.getAllBatches();
        t.addAttribute("moduleList",moduleDtoList);
        t.addAttribute("batchList",batchDtoList);
        t.addAttribute("roomList", classRoomDtoList);
        t.addAttribute("timetable", new Timetable());
        t.addAttribute("success", "TimeTable  Added Successfully");
        return "addTimeTable";
    }

    @PostMapping("/admin/addTimetable")
    public String addingTimeTable(@ModelAttribute("timetable") TimetableDto timetableDto, Model r) {
        try {

            final Timetable timetable = timeTableService.addTimetable(timetableDto);
            r.addAttribute("successful", "TimeTable Added Successfully");
        } catch (Exception ex) {
            r.addAttribute("error", "Timetable   Was not Added Successfully");
        }
        return "addTimeTable";
    }
}

