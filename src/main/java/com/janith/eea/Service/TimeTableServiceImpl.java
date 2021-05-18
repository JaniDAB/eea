package com.janith.eea.Service;

import com.janith.eea.Dto.TimetableDto;
import com.janith.eea.Model.Timetable;
import com.janith.eea.Repository.TimetableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
            timetable.setDate(Date.valueOf(timetableDto.getDate()));
            timetable.setStartTime(LocalTime.parse(timetableDto.getStartTime()));
            timetable.setEndTIme(LocalTime.parse(timetableDto.getEndTIme()));
            timetable.setClassRoom(timetableDto.getClassRoom());
            timetable.setBatch(timetableDto.getBatch());
            timetable.setModule(timetableDto.getModule());
        }
        return timetableRepo.save(timetable);
    }

    @Override
    public List<TimetableDto> viewTableByBatch(int batchID) {

        List<Timetable>  timetablesDomain = timetableRepo.findTimetableByBatch_BatchID(batchID);

        List<TimetableDto> timetableDtoList = new ArrayList<>();

        if(!timetablesDomain.isEmpty()){
            for(Timetable timetable: timetablesDomain){
                TimetableDto tt = new TimetableDto();
                tt.setBatch(timetable.getBatch());
                tt.setModule(timetable.getModule());
                tt.setDate(String.valueOf(timetable.getDate()));
                tt.setStartTime(String.valueOf(timetable.getStartTime()));
                tt.setEndTIme(String.valueOf(timetable.getEndTIme()));
                tt.setTimetableID(timetable.getTimetableID());
                tt.setClassRoom(timetable.getClassRoom());
                timetableDtoList.add(tt);
            }
        }

        return timetableDtoList;
    }

    @Override
    public TimetableDto viewTableByID(int timetableID) {
        Optional<Timetable> timetablesDomain = timetableRepo.findById(timetableID);


        TimetableDto tt = new TimetableDto();
        Timetable info = null;


        if( timetablesDomain.isPresent()){
            info = timetablesDomain.get();

                tt.setBatch(info.getBatch());
                tt.setModule(info.getModule());
                tt.setDate(String.valueOf(info.getDate()));
                tt.setStartTime(String.valueOf(info.getStartTime()));
                tt.setEndTIme(String.valueOf(info.getEndTIme()));
                tt.setTimetableID(info.getTimetableID());
                tt.setClassRoom(info.getClassRoom());

        }

        return tt;
    }

    @Override
    public List<TimetableDto> getAllTimeTables() {
        List<Timetable>  timetablesDomain = timetableRepo.findAll();

        List<TimetableDto> timetableDtoList = new ArrayList<>();

        if(!timetablesDomain.isEmpty()){
            for(Timetable timetable: timetablesDomain){
                TimetableDto tt = new TimetableDto();
                tt.setBatch(timetable.getBatch());
                tt.setModule(timetable.getModule());
                tt.setDate(String.valueOf(timetable.getDate()));
                tt.setStartTime(String.valueOf(timetable.getStartTime()));
                tt.setEndTIme(String.valueOf(timetable.getEndTIme()));
                tt.setTimetableID(timetable.getTimetableID());
                tt.setClassRoom(timetable.getClassRoom());
                timetableDtoList.add(tt);
            }
        }

        return timetableDtoList;
    }

    @Override
    public Timetable reSchedule(TimetableDto timetableDto) {

        Optional<Timetable> timetables = timetableRepo.findById(timetableDto.getTimetableID());

        Timetable timetableinfor = timetables.get();

        timetableinfor.setDate(Date.valueOf(timetableDto.getDate()));
        timetableinfor.setStartTime(LocalTime.parse(timetableDto.getStartTime()));
        timetableinfor.setEndTIme(LocalTime.parse(timetableDto.getEndTIme()));
        timetableinfor.setClassRoom(timetableDto.getClassRoom());
        timetableinfor.setBatch(timetableDto.getBatch());
        timetableinfor.setModule(timetableDto.getModule());

        return timetableRepo.save(timetableinfor);
    }

}
