package com.janith.eea.Service;

import com.janith.eea.Dto.TimetableDto;
import com.janith.eea.Model.Timetable;

import java.sql.Date;
import java.util.List;

public interface TimeTableService {

    Timetable addTimetable(TimetableDto timetableDto) throws Exception;

    List<TimetableDto> viewTableByBatch(int Batchcode);

 TimetableDto viewTableByID(int timetableID);

    List<TimetableDto> getAllTimeTables();

    Timetable reSchedule(TimetableDto timetableDto);

    String deleteTimetableByID(int ID);


    List<TimetableDto> getAllTimeTablestoLecturer(int UserID);

    List<TimetableDto> getTodayTablesByDate(int UserID);

    List<TimetableDto> getTodayTablesByDateStduents(int Batchcode);

    List<TimetableDto> searchbyDate(String Date , int batchid);

    List<TimetableDto> searchLecturerTimetable(int UserID ,String Date );


}
