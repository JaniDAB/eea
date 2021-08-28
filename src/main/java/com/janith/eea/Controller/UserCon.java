package com.janith.eea.Controller;

import com.janith.eea.Dto.ClassRoomDto;
import com.janith.eea.Dto.TimetableDto;
import com.janith.eea.Dto.UserDto;
import com.janith.eea.Service.TimeTableService;
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

    @Autowired
    private TimeTableService timeTableService;

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

    @GetMapping("/view_studentsByBatch/{batchCode}")
    public List<UserDto> viewStudentsByBatch(@PathVariable("batchCode") String batchCode){

        return  userService.getAllStudentToAPIByBatchCode(batchCode);
    }

    @GetMapping("/view_lecturers/")
    public List<UserDto> viewLectures(){

        return  userService.getAllLecturersToAPI();
    }

    @GetMapping("/view_today_schedules/{userId}")
    public List<TimetableDto> viewStudentsTodaySchedules(@PathVariable("userId") String id){

        return  timeTableService.getTodayTablesByDateStduentsApi(id);
    }
    @GetMapping("/view_All_schedules/")
    public List<TimetableDto> viewAllSchedules(){

        return  timeTableService.getAllTimeTablesAPI();
    }

    @GetMapping("/student_search_schedules/{userId}/{date}")
    public List<TimetableDto> searchByStudentTimetable(@PathVariable("userId") String id,@PathVariable("date") String date){

        return  timeTableService.searchbyDateStudentAPI(date,id);
    }
    @GetMapping("/lecturer_today_schedules/{userId}")
    public List<TimetableDto> viewLecturerTodaySchedule(@PathVariable("userId") int id){

        return  timeTableService.getTodayLecturerTimetableAPI(id);
    }

    @GetMapping("/lecturer_search_schedules/{userId}/{date}")
    public List<TimetableDto> searchLecturerSchedule(@PathVariable("userId") int id,@PathVariable("date") String date){

        return  timeTableService.lecturerSearchTimetableAPI(id,date );
    }

    @GetMapping("/get_user/{userId}")
    public UserDto viewUserByID(@PathVariable("userId") int id){

        return  userService.getUserByIdAPI(id);
    }

    @PostMapping("/add_Schedule/")
    public HashMap<String, String> AddSchedule(@RequestBody TimetableDto timetableDto) throws Exception {
        HashMap<String, String> message = new HashMap<>();

//        ClassRoomDto classRoomDto =  new ClassRoomDto();
//
//        classRoomDto.setRoomType(request.get("roomType"));
//        classRoomDto.setRoomCapacity( Integer.parseInt(request.get("capacity")));
        try {
            timeTableService.mobileAddTimetable(timetableDto);

            message.put("result", "Added");
        } catch (Exception ex) {
            message.put("result", ex.getMessage());
            return message;
        }
        return message;
    }

    @GetMapping("/send_request_reschedule/{timetID}")
    public HashMap<String, String> lecRequestReschedule(@PathVariable("timetID") int id){
        HashMap<String, String> message = new HashMap<>();
try {
    timeTableService.lecturerRequestReschedule(id);
    message.put("result", "done");

}catch (Exception e)
{
    message.put("result", e.getMessage());
    return message;
}
        return message;
    }
    @GetMapping("/admin_search_schedules/{date}")
    public List<TimetableDto> searchAdminSchedule(@PathVariable("date") String date){

        return  timeTableService.adminSearchTimetables(date);
    }



}
