package com.janith.eea.Service;

import com.janith.eea.Dto.TimetableDto;
import com.janith.eea.Model.Batch;
import com.janith.eea.Model.Timetable;
import com.janith.eea.Repository.BatchRepository;
import com.janith.eea.Repository.TimetableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TimeTableServiceImpl implements TimeTableService {

    @Autowired
    private final BatchRepository batchRepository;

    @Autowired
    private final TimetableRepository timetableRepo;

    public TimeTableServiceImpl(BatchRepository batchRepository, TimetableRepository timetableRepo) {
        this.batchRepository = batchRepository;
        this.timetableRepo = timetableRepo;
    }

    @Override
    public Timetable addTimetable(TimetableDto timetableDto) throws Exception {

        Timetable timetable = new Timetable();

        List<Batch> batchList = new ArrayList<>();
        timetable.setTimetableID(timetable.getTimetableID());
        if (timetableDto != null) {


            for (Batch batchInfor : timetableDto.getBatchList()) {
                batchList.add(batchRepository.findById(batchInfor.getBatchID()).get());
            }

            // List of timetable related to date and the respective CLassRoom
            List<Timetable> classRoomList = timetableRepo.findTimetablesByClassRoomAndDate(timetableDto.getClassRoom(), Date.valueOf(timetableDto.getDate()));

            for (int i = 0; i < classRoomList.size(); i++) {
                System.out.println(classRoomList.get(i).getTimetableID());
            }
            // 10:00 - 11:00
// 9:00 - 10:00
            for (Timetable timetableinfo : classRoomList) {

                if (timetableinfo.getStartTime().isBefore(LocalTime.parse(timetableDto.getStartTime()))) {


//                    11:00                              is after :00
                    if (timetableinfo.getEndTIme().isBefore(LocalTime.parse(timetableDto.getEndTIme()))) {
                        throw new Exception("Error, Already Time is scheduled");
                    }
                }

                if (timetableinfo.getStartTime().isAfter(LocalTime.parse(timetableDto.getStartTime()))){
                    if(timetableinfo.getEndTIme().isAfter(LocalTime.parse(timetableDto.getEndTIme())))
                    {
                        throw new Exception("Error, Please Schedule for another time");

                    }
                }
            }
            // List of timetable of a particular Date
//        List<Timetable> dateTimetable = timetableRepo.findTimetableByDate(Date.valueOf(timetableDto.getDate()));


            //List of timetables of batches and respective date
//            List<Timetable> batchesTable = timetableRepo.findByBatchListAndDate(batchList, Date.valueOf(timetableDto.getDate()));


            timetable.setBatchList(batchList);
            timetable.setDate(Date.valueOf(timetableDto.getDate()));
            timetable.setStartTime(LocalTime.parse(timetableDto.getStartTime()));
            timetable.setEndTIme(LocalTime.parse(timetableDto.getEndTIme()));
            timetable.setClassRoom(timetableDto.getClassRoom());
            timetable.setModule(timetableDto.getModule());
        }

        return timetableRepo.save(timetable);
    }

    @Override
    public List<TimetableDto> viewTableByBatch(int batchID) {

        Batch batch = batchRepository.findById(batchID).orElseThrow(RuntimeException::new);

        List<Timetable> timetablesDomain = timetableRepo.findTimetablesByBatchListEquals(batch);

        List<TimetableDto> timetableDtoList = new ArrayList<>();

        if (!timetablesDomain.isEmpty()) {
            for (Timetable timetable : timetablesDomain) {
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


        if (timetablesDomain.isPresent()) {
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
        List<Timetable> timetablesDomain = timetableRepo.findAll();

        List<TimetableDto> timetableDtoList = new ArrayList<>();

        if (!timetablesDomain.isEmpty()) {
            for (Timetable timetable : timetablesDomain) {
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

    //Lecturers time table of the current date
    @Override
    public List<TimetableDto> getTodayTablesByDate(int UserID) {

         // This object contains the current date value
        java.util.Date date = new java.util.Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(formatter.format(date));
        List<Timetable> timetablesDomain = timetableRepo.findTimetablesByDateAndModule_LecUser_UserId(Date.valueOf(formatter.format(date)),UserID);

        List<TimetableDto> timetableDtoList = new ArrayList<>();

        if (!timetablesDomain.isEmpty()) {
            for (Timetable timetable : timetablesDomain) {
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

    //Students view Time table of the curretn date
    @Override
    public List<TimetableDto> getTodayTablesByDateStduents(int batchID) {
        // This object contains the current date value
        java.util.Date date = new java.util.Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(formatter.format(date));

        Batch batch = batchRepository.findById(batchID).orElseThrow(RuntimeException::new);

        List<Timetable> timetablesDomain = timetableRepo.findTimetablesByBatchListEqualsAndDate(batch,Date.valueOf(formatter.format(date)));

        List<TimetableDto> timetableDtoList = new ArrayList<>();

        if (!timetablesDomain.isEmpty()) {
            for (Timetable timetable : timetablesDomain) {
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

    @Override
    public List<TimetableDto> searchbyDate(String Date , int batchid) {
        Batch batch = batchRepository.findById(batchid).orElseThrow(RuntimeException::new);

        List<Timetable> timetablesDomain = timetableRepo.findTimetablesByBatchListEqualsAndDateLike(batch, java.sql.Date.valueOf(Date));

        List<TimetableDto> timetableDtoList = new ArrayList<>();

        if (!timetablesDomain.isEmpty()) {
            for (Timetable timetable : timetablesDomain) {
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

        return timetableDtoList;    }

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
        } catch (Exception EX) {
            System.out.println(EX);
            return "error";
        }
    }
//Lecturers Time table
    @Override
    public List<TimetableDto> getAllTimeTablestoLecturer(int UserID) {
        List<Timetable> timetablesDomain = timetableRepo.findTimetablesByModule_LecUser_UserId(UserID);

        List<TimetableDto> timetableDtoList = new ArrayList<>();

        if (!timetablesDomain.isEmpty()) {
            for (Timetable timetable : timetablesDomain) {
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
    public List<TimetableDto> searchLecturerTimetable(int UserID, String Date) {
        List<Timetable> timetablesDomain = timetableRepo.findTimetablesByModule_LecUser_UserIdAndDateLike(UserID,java.sql.Date.valueOf(Date) );

        List<TimetableDto> timetableDtoListof = new ArrayList<>();

        if (!timetablesDomain.isEmpty()) {
            for (Timetable timetable : timetablesDomain) {
                TimetableDto tt = new TimetableDto();
                tt.setBatchList(timetable.getBatchList());
                tt.setModule(timetable.getModule());
                tt.setDate(String.valueOf(timetable.getDate()));
                tt.setStartTime(String.valueOf(timetable.getStartTime()));
                tt.setEndTIme(String.valueOf(timetable.getEndTIme()));
                tt.setTimetableID(timetable.getTimetableID());
                tt.setClassRoom(timetable.getClassRoom());
                timetableDtoListof.add(tt);
            }
        }

        return timetableDtoListof;    }
}
