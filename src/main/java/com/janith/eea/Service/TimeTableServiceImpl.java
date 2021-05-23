package com.janith.eea.Service;

import com.janith.eea.Dto.TimetableDto;
import com.janith.eea.Model.Batch;
import com.janith.eea.Model.Timetable;
import com.janith.eea.Repository.BatchRepository;
import com.janith.eea.Repository.TimetableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TimeTableServiceImpl implements  TimeTableService{

    @Autowired
    private final BatchRepository batchRepository;

    @Autowired
    private final TimetableRepository timetableRepo;

    public TimeTableServiceImpl(BatchRepository batchRepository, TimetableRepository timetableRepo) {
        this.batchRepository = batchRepository;
        this.timetableRepo = timetableRepo;
    }

    @Override
    public Timetable addTimetable(TimetableDto timetableDto) {

        Timetable timetable = new Timetable();

        List<Batch> batchList = new ArrayList<>();
        timetable.setTimetableID(timetable.getTimetableID());
        if(timetableDto != null){
        for(Batch batchInfor : timetableDto.getBatchList())
        {
            batchList.add(batchRepository.findById(batchInfor.getBatchID()).get());
        }
        timetable.setBatchList(batchList);
            timetable.setDate(Date.valueOf(timetableDto.getDate()));
            timetable.setStartTime(LocalTime.parse(timetableDto.getStartTime()));
            timetable.setEndTIme(LocalTime.parse(timetableDto.getEndTIme()));
            timetable.setClassRoom(timetableDto.getClassRoom());
//            timetable.setBatch(timetableDto.getBatchList().get());
            timetable.setModule(timetableDto.getModule());
        }

        return timetableRepo.save(timetable);
    }

    @Override
    public List<TimetableDto> viewTableByBatch(int batchID) {

        Batch batch = batchRepository.findById(batchID).orElseThrow(RuntimeException::new);

        List<Timetable>  timetablesDomain = timetableRepo.findTimetablesByBatchListEquals(batch);

        List<TimetableDto> timetableDtoList = new ArrayList<>();

        if(!timetablesDomain.isEmpty()){
            for(Timetable timetable: timetablesDomain){
                TimetableDto tt = new TimetableDto();
//                tt.setBatch(timetable.getBatch());
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
// :: new exception invoke

    @Override
    public TimetableDto viewTableByID(int timetableID) {
        Optional<Timetable> timetablesDomain = timetableRepo.findById(timetableID);


        TimetableDto tt = new TimetableDto();
        Timetable info = null;


        if( timetablesDomain.isPresent()){
            info = timetablesDomain.get();

                tt.setBatchList(info.getBatchList());
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
                tt.setBatchList(timetable.getBatchList());
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

        Timetable timetables = timetableRepo.findById(timetableDto.getTimetableID()).orElseThrow(RuntimeException::new);

        timetables.setDate(Date.valueOf(timetableDto.getDate()));
        timetables.setStartTime(LocalTime.parse(timetableDto.getStartTime()));
        timetables.setEndTIme(LocalTime.parse(timetableDto.getEndTIme()));
        timetables.setClassRoom(timetableDto.getClassRoom());
        return timetableRepo.save(timetables);
    }

    @Override
    public String deleteTimetableByID(int ID) {
        try {
            this.timetableRepo.deleteById(ID);

            return "deleted";
        }
        catch (Exception EX)
        {
            System.out.println(EX);
            return "error";
        }
    }

    @Override
    public List<TimetableDto> getAllTimeTablestoLecturer(int UserID) {
        List<Timetable>  timetablesDomain = timetableRepo.findTimetablesByModule_LecUser_UserId(UserID);

        List<TimetableDto> timetableDtoList = new ArrayList<>();

        if(!timetablesDomain.isEmpty()){
            for(Timetable timetable: timetablesDomain){
                TimetableDto tt = new TimetableDto();
                tt.setBatchList(timetable.getBatchList());
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
}
