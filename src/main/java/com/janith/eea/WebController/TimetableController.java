package com.janith.eea.WebController;

import com.janith.eea.Dto.BatchDto;
import com.janith.eea.Dto.ClassRoomDto;
import com.janith.eea.Dto.ModuleDto;
import com.janith.eea.Dto.TimetableDto;
import com.janith.eea.Model.ClassRoom;
import com.janith.eea.Model.Timetable;
import com.janith.eea.Service.BatchServiceImpl;
import com.janith.eea.Service.ClassRoomServiceImpl;
import com.janith.eea.Service.ModuleServiceImpl;
import com.janith.eea.Service.TimeTableServiceImpl;
import com.janith.eea.Validation.ClassRoomValidator;
import com.janith.eea.Validation.TimetableValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

/**
 * All the  controllers need in Timetable scheduling
 * @author janith dabare
 */
@Controller
@PreAuthorize("hasAuthority('ADMIN')")
public class TimetableController {

    @Autowired
    private final TimeTableServiceImpl timeTableService;

    @Autowired
    private final ClassRoomServiceImpl classRoomService;

    @Autowired
    private final ModuleServiceImpl moduleService;

    @Autowired
    private final BatchServiceImpl batchService;

    @Autowired
    private final ClassRoomValidator classRoomValidator;

    @Autowired
    private final TimetableValidator timetableValidator;

    public TimetableController(TimeTableServiceImpl timeTableService, ClassRoomServiceImpl classRoomService, ModuleServiceImpl moduleService, BatchServiceImpl batchService, ClassRoomValidator classRoomValidator, TimetableValidator timetableValidator) {
        this.timeTableService = timeTableService;
        this.classRoomService = classRoomService;
        this.moduleService = moduleService;
        this.batchService = batchService;
        this.classRoomValidator = classRoomValidator;
        this.timetableValidator = timetableValidator;
    }

    @GetMapping("/addRoom")
    public String AddRoom(Model r) {
        r.addAttribute("addRoom", new ClassRoomDto());
        r.addAttribute("success", "Room Added Successfully");
        return "addClassRoom";
    }

    @PostMapping("/admin/AddRoom")
    public String AddingRoom
            (@ModelAttribute("addRoom")@Valid ClassRoomDto classRoomDto,
             Model r,
             BindingResult br) {

        classRoomValidator.validate(classRoomDto, br);

        if (br.hasErrors()) {
            r.addAttribute("error", "Room  Was not Added Successfully");
            return "addClassRoom";
        } else {
            try {
                classRoomService.addRoom(classRoomDto);
                r.addAttribute("successful", "Room was Added Successfully");

            } catch (Exception ex) {
                r.addAttribute("error", "Room  Was not Added Successfully");
                return "addClassRoom";
            }
        }
        return "addClassRoom";
    }

//    @GetMapping("/addTimetable")
//    public String addTimetableDirect(Model t) {
//        List<ClassRoomDto> classRoomDtoList = classRoomService.viewRooms();
//        List<ModuleDto> moduleDtoList = moduleService.getAllModules();
//        List<BatchDto> batchDtoList = batchService.getAllBatches();
//        t.addAttribute("moduleList", moduleDtoList);
//        t.addAttribute("batchList", batchDtoList);
//        t.addAttribute("roomList", classRoomDtoList);
//        t.addAttribute("timetable", new Timetable());
//        t.addAttribute("success", "TimeTable  Added Successfully");
//        return "addTimeTable";
//    }

    @PostMapping("/admin/addTimetable")
    public String addingTimeTable(@Valid @ModelAttribute("timetable") TimetableDto timetableDto, Model r,BindingResult br) {
        try {

//            validate scheduling
timetableValidator.validate(timetableDto,br);

            final Timetable timetable = timeTableService.
                    addTimetable(timetableDto);
            if(br.hasErrors()){
                return "addTimeTable";
            }
            r.addAttribute("successful", "TimeTable Added Successfully");
        } catch (Exception ex) {
            System.out.println(ex);
            r.addAttribute("error", ex.getMessage());
        }
        return "addTimeTable";
    }

//    @GetMapping("/admin/timetable/listBatches")
//    public String viewBatches(Model b) {
//
//        List<BatchDto> batchDtoList;
//        batchDtoList = batchService.getAllBatches();
//        b.addAttribute("batches", batchDtoList);
//
//        return "selectBatchForSchedule";
//    }

    @GetMapping("/admin/timetable/listModules")
    public String listModules(Model b) {

//         get modules to schedule the timetable
         List<ModuleDto> moduleDtoList = moduleService.getAllModules();
        b.addAttribute("modules", moduleDtoList);

        return "selectModuleforSchedule";
    }

    @GetMapping("/admin/addTimetable/{id}")
    public String addTimetableD(@PathVariable(value = "id")int id, Model t) {

        try {
            int module = id;
            ModuleDto moduleinfor = moduleService.getModuleById(module);

// get the relevant Batches  respective to the module
            List<BatchDto> batchDtoList = moduleService.getBatchListM(module);

            //list of rooms
            List<ClassRoomDto> classRoomDtoList = classRoomService.viewRooms();

            t.addAttribute("batchList", batchDtoList);
            t.addAttribute("moduleInfo", moduleinfor);
            t.addAttribute("roomList", classRoomDtoList);
            t.addAttribute("timetable", new TimetableDto());

            t.addAttribute("success", "Scheduled  Successfully");
            return "addTimeTable";

        }catch (Exception e){
            System.out.println(e);
            return "addTimeTable";
        }
    }

//    @GetMapping("/student/timetable/{id}")
//    public String getStudentTimetable(@PathVariable(value = "id") int id, Model timetable)
//    {
//        List<TimetableDto> timetableDtoList = timeTableService.viewTableByBatch(id);
//
//        timetable.addAttribute("timetableList" , timetableDtoList);
//
//        return "viewStudentTimetable";
//
//    }



    @GetMapping("/getAllSchedules")
    public  String getAllTimetables(Model model)
    {

//        list of timetables
        List<TimetableDto> timetableList = timeTableService.getAllTimeTables();

        model.addAttribute("allSchedules", timetableList);

        return "timetableList";
    }


    @GetMapping("/getRequestedTimetables")
    public  String getRequestedReschedules(Model model)
    {

//        list of timetables
        List<TimetableDto> timetableList = timeTableService.getRescheduleRequestedTimetables();

        model.addAttribute("allSchedules", timetableList);

        return "timetableList";
    }

    @GetMapping("/admin/rescheduleDirect/{timetableId}")
    public  String getRescheduleForm(@PathVariable(value="timetableId") int timetableid, Model timetableM)
    {
       TimetableDto timetableDtoInfo  = timeTableService.viewTableByID(timetableid);
//        List<ModuleDto>  ModuleList = batchService.getModuleList(BatchId);
        List<ClassRoomDto> classRoomDtoList = classRoomService.viewRooms();

        timetableM.addAttribute("roomList", classRoomDtoList);
//        timetableM.addAttribute("moduleList", ModuleList);
       timetableM.addAttribute("timetableinfor" , timetableDtoInfo);
       timetableM.addAttribute("rescheduleTime", new TimetableDto());


       return "rescedule";

    }

    @PostMapping("/admin/rescheduleTimetable")
public  String setRescheduleTimetable(@ModelAttribute("rescheduleTime") TimetableDto timetableDto, Model m,BindingResult br)
    {
        if(br.hasErrors()){
            return "rescedule";
        }

        try {
            final Timetable update = timeTableService.reSchedule(timetableDto);
            m.addAttribute("Updated", "Rescheduled Successfully");
            return "rescedule";
        }catch (Exception e){
            m.addAttribute("error", e.getMessage());
        }
        return "rescedule";
    }


    @GetMapping("/deleteTimetable/{id}")
            public String deleteTimetable(@PathVariable(value = "id")int tableID, Model mod, RedirectAttributes rd)
    {
        String s = timeTableService.deleteTimetableByID(tableID);
        if (s.equals("deleted")){
            rd.addFlashAttribute("deleted", "Schedule Deleted");

        }
        else {
            mod.addAttribute("error", "Error.....Please try again later.");

        }
        return "redirect:/getAllSchedules";
    }

    @GetMapping("/admin/room/listrooms")
    public String viewRooms(Model b) {
        List<ClassRoomDto> classRoomDtoList;
        classRoomDtoList = classRoomService.viewRooms();
        b.addAttribute("rooms", classRoomDtoList);

        return "viewClassRooms";
    }
    @GetMapping("/admin/deleteRoom/{id}")
    public String deleteRoom(@PathVariable(value = "id")String roomID, Model mod, RedirectAttributes rd)
    {
        String s = classRoomService.deleteRoom(roomID);
        if (s.equals("deleted")){
            rd.addFlashAttribute("deleted", " Class Room Deleted");

        }
        else if(s.equals("error")){
            rd.addFlashAttribute("errorDelete", "Error Removing, Room: "+roomID+" is  having a scheduled. ");

        }
        return "redirect:/admin/room/listrooms";
    }
    @GetMapping("/admin/updateRoom/{id}")
    public  String getRoominfo(@PathVariable(value="id") String roomID, Model m)
    {
        ClassRoomDto cl = classRoomService.viewSingleRoom(roomID);

        m.addAttribute("roominfo", cl);
        m.addAttribute("editRoom", new ClassRoomDto());

        return "RoomUpdate";
    }
    @PostMapping("/admin/updateRoom")
    public  String setRescheduleTimetable(@ModelAttribute("editRoom") ClassRoomDto classRoomDto, Model m)
    {
        try {
            final ClassRoom update = classRoomService.editRoom( classRoomDto);
            m.addAttribute("Updated", "Updated Successfully");
            return "RoomUpdate";
        }catch (Exception e){
            m.addAttribute("error", "  UnSuccessful");
        }
        return "RoomUpdate";
    }



//
//    @GetMapping("/lecturer/timetable/{id}")
//    public String getLecturerTimetable(@PathVariable(value = "id") int id, Model timetable)
//    {
//        List<TimetableDto> timetableDtoList = timeTableService.getAllTimeTablestoLecturer(id);
//
//        timetable.addAttribute("timetableList" , timetableDtoList);
//
//        return "viewLecturerTimetable";
//
//    }


}

