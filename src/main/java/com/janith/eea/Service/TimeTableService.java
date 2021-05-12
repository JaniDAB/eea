package com.janith.eea.Service;

import com.janith.eea.Dto.TimetableDto;
import com.janith.eea.Model.Timetable;

public interface TimeTableService {

    Timetable addTimetable(TimetableDto timetableDto);
}
