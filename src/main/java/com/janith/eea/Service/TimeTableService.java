package com.janith.eea.Service;

import com.janith.eea.Dto.TimetableDto;
import com.janith.eea.Model.Timetable;

import java.util.List;

public interface TimeTableService {

    Timetable addTimetable(TimetableDto timetableDto);

    List<TimetableDto> viewTableByBatch(int Batchcode);

 TimetableDto viewTableByID(int timetableID);

    List<TimetableDto> getAllTimeTables();

    Timetable reSchedule(TimetableDto timetableDto);

    String deleteTimetableByID(int ID);


    List<TimetableDto> getAllTimeTablestoLecturer(int UserID);

}
