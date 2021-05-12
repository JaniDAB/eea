package com.janith.eea.Service;

import com.janith.eea.Dto.TimetableDto;
import com.janith.eea.Model.Timetable;
import com.janith.eea.Repository.TimetableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TimeTableServiceImpl implements  TimeTableService{



    @Autowired
    private final TimetableRepository timetableRepo;

    public TimeTableServiceImpl(TimetableRepository timetableRepo) {
        this.timetableRepo = timetableRepo;
    }

    @Override
    public Timetable addTimetable(TimetableDto timetableDto) {

        Timetable timetable = new Timetable();

        if(timetableDto != null){
            timetable.setStartTime(timetableDto.getStartTime());
            timetable.setEndTIme(timetableDto.getEndTIme());
            timetable.setClassRoom(timetableDto.getClassRoom());
            timetable.setBatch(timetableDto.getBatch());
            timetable.setModule(timetableDto.getModule());
        }
        return timetableRepo.save(timetable);
    }
}
