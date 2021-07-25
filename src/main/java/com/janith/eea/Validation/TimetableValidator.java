package com.janith.eea.Validation;

import com.janith.eea.Dto.TimetableDto;
import com.janith.eea.Model.Timetable;
import com.janith.eea.Repository.TimetableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.sql.Date;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;

@Component
public class TimetableValidator implements Validator {

    @Autowired
    private final TimetableRepository timetableRepository;

    public TimetableValidator(TimetableRepository timetableRepository) {
        this.timetableRepository = timetableRepository;
    }


    @Override
    public boolean supports(Class<?> aClass) {
        return TimetableValidator.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {

        TimetableDto timetableDto = (TimetableDto) o;

        // List of timetable related to date and the respective CLassRoom
        List<Timetable> classRoomList = timetableRepository.findTimetablesByClassRoomAndDate(timetableDto.getClassRoom(), Date.valueOf(timetableDto.getDate()));

        for (int i = 0; i < classRoomList.size(); i++) {
            System.out.println(classRoomList.get(i).getTimetableID());
        }
        // 10:00 - 11:00
// 9:00 - 10:00
        for (Timetable timetableinfo : classRoomList) {
//                                  8:00       is before                  10:00
//            if (timetableinfo.getStartTime().isBefore(LocalTime.parse(timetableDto.getStartTime()))) {
//
//
////                    9:00            is before                             10:00
//                if (timetableinfo.getEndTIme().isBefore(LocalTime.parse(timetableDto.getStartTime()))) {
//                 errors.rejectValue("startTime", "timetable.validate");
//                    errors.rejectValue("classRoom", "timetable.validate.cls");
//                }
//            }
////
//            if (timetableinfo.getStartTime().isAfter(LocalTime.parse(timetableDto.getStartTime()))){
//                if(timetableinfo.getEndTIme().isAfter(LocalTime.parse(timetableDto.getEndTIme())))
//                {
//         errors.rejectValue("endTIme", "timetable.validate.end");
//                }
//            }
//new  time isbefore   db start time
//            new endtime is after  db endtime

            if((LocalTime.parse((timetableDto.getStartTime())).isBefore(timetableinfo.getStartTime()))
            &&
                    (LocalTime.parse(timetableDto.getEndTIme()).isAfter(timetableinfo.getEndTIme()))){
//                errors.rejectValue("startTime", "timetable.validate");
                errors.rejectValue("classRoom", "  This  Class is Already booked" );



            }
            if ((LocalTime.parse(timetableDto.getStartTime()).isAfter(timetableinfo.getStartTime()))
                    &&
                    (LocalTime.parse(timetableDto.getStartTime()).isBefore(timetableinfo.getEndTIme()))) {

                errors.rejectValue("startTime", "timetable.validate");
                String obj =timetableinfo.getClassRoom().getRoomId();
                errors.rejectValue("classRoom", "timetable.validate.cls",Arrays.toString(new String[]{obj}));


            }
            if ((LocalTime.parse(timetableDto.getEndTIme()).isAfter(timetableinfo.getStartTime()))
            &&
                    (LocalTime.parse(timetableDto.getEndTIme()).isBefore(timetableinfo.getEndTIme()))
            ){
                         errors.rejectValue("endTIme", "timetable.validate.end");
            }

        }


        if (!checkTime(LocalTime.parse(timetableDto.getStartTime()), LocalTime.parse(timetableDto.getEndTIme()))) {
            errors.rejectValue("endTIme", "timetable.validate.MAX");

        }


    }

    public Boolean checkTime(LocalTime startTime, LocalTime endTime) {
        long hours;


        hours = ChronoUnit.MINUTES.between(startTime, endTime);

        int durationInHours = Integer.parseInt(String.valueOf(hours));
        if (durationInHours > 120 || durationInHours < 30) {

            return false;
        }
        return true;

    }
}
