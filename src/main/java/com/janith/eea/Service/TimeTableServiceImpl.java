package com.janith.eea.Service;

import com.janith.eea.Dto.BatchDto;
import com.janith.eea.Dto.TimetableDto;
import com.janith.eea.Model.Batch;
import com.janith.eea.Model.ClassRoom;
import com.janith.eea.Model.Timetable;
import com.janith.eea.Model.User;
import com.janith.eea.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TimeTableServiceImpl implements TimeTableService {

    @Autowired
    private final BatchRepository batchRepository;

    @Autowired
    private final TimetableRepository timetableRepo;

    @Autowired
    private final ClassRoomService classRoomService;

    @Autowired
    private final ClassRoomRepository classRoomRepository;

    @Autowired
    private final ModuleRepository moduleRepository;

    @Autowired
    private EmailServiceImpl emailService;


    @Autowired
    private final ModuleService moduleService;

    @Autowired
    private final UserRepository userRepository;

    public TimeTableServiceImpl(BatchRepository batchRepository, TimetableRepository timetableRepo, ClassRoomService classRoomService, ClassRoomRepository classRoomRepository, ModuleRepository moduleRepository, ModuleService moduleService, UserRepository userRepository) {
        this.batchRepository = batchRepository;
        this.timetableRepo = timetableRepo;
        this.classRoomService = classRoomService;
        this.classRoomRepository = classRoomRepository;
        this.moduleRepository = moduleRepository;
        this.moduleService = moduleService;
        this.userRepository = userRepository;
    }

    @Override
    public Timetable addTimetable(TimetableDto timetableDto) throws Exception {

        Timetable timetable = new Timetable();

        List<Batch> batchList = new ArrayList<>();

        LocalTime startTime = LocalTime.parse(timetableDto.getStartTime());
        LocalTime endTime = LocalTime.parse(timetableDto.getEndTIme());

        if (timetableDto != null) {


            if(!checkTime(startTime,endTime)){
                throw new Exception("A Class Can be Schedule of Minimum, 30 Minutes & Maximum 2 Hours");

            }
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
                    //10 < 12
//                if (timetableinfo.getStartTime().isBefore(LocalTime.parse(timetableDto.getStartTime()))) {
//                    //10 < 12 && 11 < 13
//
////                    11:00                              is after :00
//                    if (timetableinfo.getEndTIme().isBefore(LocalTime.parse(timetableDto.getEndTIme()))) {
//                        throw new Exception("Error, Already Time is scheduled");
//                    }
//                }
//
//                if (timetableinfo.getStartTime().isAfter(LocalTime.parse(timetableDto.getStartTime()))){
//                    if(timetableinfo.getEndTIme().isAfter(LocalTime.parse(timetableDto.getEndTIme())))
//                    {
//                        throw new Exception("Error, Please Schedule for another time");
//
//                    }
//                }
                if((LocalTime.parse((timetableDto.getStartTime())).isBefore(timetableinfo.getStartTime()))
                        &&
                        (LocalTime.parse(timetableDto.getEndTIme()).isAfter(timetableinfo.getEndTIme()))){
                        throw new Exception("Error, Please Schedule for another time");

                }

                if ((LocalTime.parse(timetableDto.getStartTime()).isAfter(timetableinfo.getStartTime()))
                        &&
                        (LocalTime.parse(timetableDto.getStartTime()).isBefore(timetableinfo.getEndTIme()))) {

                    throw new Exception("Error Occured, Class Room ID : "+timetableDto.getClassRoom().getRoomId() +" Is already Booked at the Moment" );
                }
                if ((LocalTime.parse(timetableDto.getEndTIme()).isAfter(timetableinfo.getStartTime()))
                        &&
                        (LocalTime.parse(timetableDto.getEndTIme()).isBefore(timetableinfo.getEndTIme()))
                ){
                        throw new Exception("Error Occured, Class Room ID : "+timetableDto.getClassRoom().getRoomId() +" Is already Booked at the Moment" );
                }


            }

//              Scheduling Validation with Batch list
            for(Batch batchlistinfor:batchList){
                final List<Timetable> allByBatchListEqualsAndDateEquals = timetableRepo.getAllByBatchListEqualsAndDateEquals(batchlistinfor, Date.valueOf(timetableDto.getDate()));

                for (Timetable timetableinfo : allByBatchListEqualsAndDateEquals) {

                    if((LocalTime.parse((timetableDto.getStartTime())).isBefore(timetableinfo.getStartTime()))
                            &&
                            (LocalTime.parse(timetableDto.getEndTIme()).isAfter(timetableinfo.getEndTIme()))){
                        throw new Exception("Batch :" + batchlistinfor.getBatchCode() +" Is Already Having an Schedule  ");

                    }
                    if ((LocalTime.parse(timetableDto.getStartTime()).isAfter(timetableinfo.getStartTime()))
                            &&
                            (LocalTime.parse(timetableDto.getStartTime()).isBefore(timetableinfo.getEndTIme()))) {

                        throw new Exception("Batch :" + batchlistinfor.getBatchCode() +"Is Already Having an Schedule");
                    }
                    if ((LocalTime.parse(timetableDto.getEndTIme()).isAfter(timetableinfo.getStartTime()))
                            &&
                            (LocalTime.parse(timetableDto.getEndTIme()).isBefore(timetableinfo.getEndTIme()))
                    ){
                        throw new Exception("Batch :" + batchlistinfor.getBatchCode() +"Is Already Having an Schedule");
                    }

                }

            }


            // List of timetable of a particular Date
//        List<Timetable> dateTimetable = timetableRepo.findTimetableByDate(Date.valueOf(timetableDto.getDate()));


            //List of timetables of batches and respective date
//            List<Timetable> batchesTable = timetableRepo.findByBatchListAndDate(batchList, Date.valueOf(timetableDto.getDate()));

            timetable.setTimetableID(timetable.getTimetableID());
            timetable.setBatchList(batchList);
            timetable.setDate(Date.valueOf(timetableDto.getDate()));
            timetable.setStartTime(LocalTime.parse(timetableDto.getStartTime()));
            timetable.setEndTIme(LocalTime.parse(timetableDto.getEndTIme()));
            timetable.setClassRoom(timetableDto.getClassRoom());
            timetable.setModule(timetableDto.getModule());
            timetable.setRequestReschedule(false);

        }

        return timetableRepo.save(timetable);
    }

    @Override
    public Timetable mobileAddTimetable(TimetableDto timetableDto) throws Exception {
        Timetable timetable = new Timetable();

        List<Batch> batchList = new ArrayList<>();

        LocalTime startTime = LocalTime.parse(timetableDto.getStartTime());
        LocalTime endTime = LocalTime.parse(timetableDto.getEndTIme());

        if (timetableDto != null) {


            if(!checkTime(startTime,endTime)){
                throw new Exception("A Class Can be Schedule of Minimum, 30 Minutes & Maximum 2 Hours");

            }
            for (Batch batchInfor : timetableDto.getBatchList()) {
                batchList.add(batchRepository.findBatchesByBatchCode(batchInfor.getBatchCode()));

            }
            ClassRoom ss = classRoomRepository.findClassRoomByRoomId(timetableDto.getClassRoom().getRoomId());
            // List of timetable related to date and the respective CLassRoom
            List<Timetable> classRoomList = timetableRepo.findTimetablesByClassRoomAndDate(ss, Date.valueOf(timetableDto.getDate()));

            for (int i = 0; i < classRoomList.size(); i++) {
                System.out.println(classRoomList.get(i).getTimetableID());
            }
            // 10:00 - 11:00
// 9:00 - 10:00
            for (Timetable timetableinfo : classRoomList) {

                if((LocalTime.parse((timetableDto.getStartTime())).isBefore(timetableinfo.getStartTime()))
                        &&
                        (LocalTime.parse(timetableDto.getEndTIme()).isAfter(timetableinfo.getEndTIme()))){
                    throw new Exception("Error, Please Schedule for another time");

                }

                if ((LocalTime.parse(timetableDto.getStartTime()).isAfter(timetableinfo.getStartTime()))
                        &&
                        (LocalTime.parse(timetableDto.getStartTime()).isBefore(timetableinfo.getEndTIme()))) {

                    throw new Exception("Error Occured, Class Room ID : "+timetableDto.getClassRoom().getRoomId() +" Is already Booked at the Moment" );
                }
                if ((LocalTime.parse(timetableDto.getEndTIme()).isAfter(timetableinfo.getStartTime()))
                        &&
                        (LocalTime.parse(timetableDto.getEndTIme()).isBefore(timetableinfo.getEndTIme()))
                ){
                    throw new Exception("Error Occured, Class Room ID : "+timetableDto.getClassRoom().getRoomId() +" Is already Booked at the Moment" );
                }


            }

//              Scheduling Validation with Batch list
            for(Batch batchlistinfor:batchList){
                final List<Timetable> allByBatchListEqualsAndDateEquals = timetableRepo.getAllByBatchListEqualsAndDateEquals(batchlistinfor, Date.valueOf(timetableDto.getDate()));

                for (Timetable timetableinfo : allByBatchListEqualsAndDateEquals) {

                    if((LocalTime.parse((timetableDto.getStartTime())).isBefore(timetableinfo.getStartTime()))
                            &&
                            (LocalTime.parse(timetableDto.getEndTIme()).isAfter(timetableinfo.getEndTIme()))){
                        throw new Exception("Batch :" + batchlistinfor.getBatchCode() +" Is Already Having an Schedule  ");

                    }
                    if ((LocalTime.parse(timetableDto.getStartTime()).isAfter(timetableinfo.getStartTime()))
                            &&
                            (LocalTime.parse(timetableDto.getStartTime()).isBefore(timetableinfo.getEndTIme()))) {

                        throw new Exception("Batch :" + batchlistinfor.getBatchCode() +"Is Already Having an Schedule");
                    }
                    if ((LocalTime.parse(timetableDto.getEndTIme()).isAfter(timetableinfo.getStartTime()))
                            &&
                            (LocalTime.parse(timetableDto.getEndTIme()).isBefore(timetableinfo.getEndTIme()))
                    ){
                        throw new Exception("Batch :" + batchlistinfor.getBatchCode() +"Is Already Having an Schedule");
                    }

                }

            }



            timetable.setTimetableID(timetable.getTimetableID());
            timetable.setBatchList(batchList);
            timetable.setDate(Date.valueOf(timetableDto.getDate()));
            timetable.setStartTime(LocalTime.parse(timetableDto.getStartTime()));
            timetable.setEndTIme(LocalTime.parse(timetableDto.getEndTIme()));
            timetable.setClassRoom(ss);
            timetable.setRequestReschedule(false);
            timetable.setModule(moduleRepository.findById(timetableDto.getModule().getModule_id()).get());
        }

        return timetableRepo.save(timetable);    }

    public Boolean checkTime(LocalTime startTime, LocalTime endTime) {
        long hours;


        hours = ChronoUnit.MINUTES.between(startTime, endTime);

        int durationInHours = Integer.parseInt(String.valueOf(hours));
        if (durationInHours > 120 || durationInHours < 30) {

            return false;
        }
        return true;

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

                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
                try{
                    java.util.Date startime = sdf.parse(String.valueOf(timetable.getStartTime()));
                    java.util.Date endTime = sdf.parse(String.valueOf(timetable.getEndTIme()));

                    //new format
                    SimpleDateFormat sdf2 = new SimpleDateFormat("hh:mm aa");
                    //formatting the given time to new format with AM/PM

                    tt.setStartTime(sdf2.format(startime));
                    tt.setEndTIme(sdf2.format(endTime));
                }catch(ParseException e){
                    e.printStackTrace();
                }

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


                //old format
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
                try{
                    java.util.Date startime = sdf.parse(String.valueOf(timetable.getStartTime()));
                    java.util.Date endTime = sdf.parse(String.valueOf(timetable.getEndTIme()));

                    //new format
                    SimpleDateFormat sdf2 = new SimpleDateFormat("hh:mm aa");
                    //formatting the given time to new format with AM/PM

                    tt.setStartTime(sdf2.format(startime));
                    tt.setEndTIme(sdf2.format(endTime));
                }catch(ParseException e){
                    e.printStackTrace();
                }


                tt.setTimetableID(timetable.getTimetableID());
                tt.setClassRoom(timetable.getClassRoom());
                timetableDtoList.add(tt);
            }
        }

        return timetableDtoList;
    }

    @Override
    public List<TimetableDto> getRescheduleRequestedTimetables() {
        List<Timetable> timetablesDomain = timetableRepo.findTimetablesByRequestReschedule(true);

        List<TimetableDto> timetableDtoList = new ArrayList<>();

        if (!timetablesDomain.isEmpty()) {
            for (Timetable timetable : timetablesDomain) {
                TimetableDto tt = new TimetableDto();
                tt.setBatchList(timetable.getBatchList());
                tt.setModule(timetable.getModule());
                tt.setDate(String.valueOf(timetable.getDate()));


                //old format
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
                try{
                    java.util.Date startime = sdf.parse(String.valueOf(timetable.getStartTime()));
                    java.util.Date endTime = sdf.parse(String.valueOf(timetable.getEndTIme()));

                    //new format
                    SimpleDateFormat sdf2 = new SimpleDateFormat("hh:mm aa");
                    //formatting the given time to new format with AM/PM

                    tt.setStartTime(sdf2.format(startime));
                    tt.setEndTIme(sdf2.format(endTime));
                }catch(ParseException e){
                    e.printStackTrace();
                }


                tt.setTimetableID(timetable.getTimetableID());
                tt.setClassRoom(timetable.getClassRoom());
                timetableDtoList.add(tt);
            }
        }

        return timetableDtoList;    }

    //API
    @Override
    public List<TimetableDto> getAllTimeTablesAPI() {
        List<Timetable> timetablesDomain = timetableRepo.findAll();

        List<TimetableDto> timetableDtoList = new ArrayList<>();

        if (!timetablesDomain.isEmpty()) {
            for (Timetable timetable : timetablesDomain) {
                List<BatchDto> batchDtoList = new ArrayList<>();

                TimetableDto tt = new TimetableDto();

                for(Batch batchob: timetable.getBatchList() ){
                    BatchDto batch = new BatchDto();

                    batch.setBatchID(batchob.getBatchID());
                    batch.setBatchCode(batchob.getBatchCode());
                    batch.setDescription(batchob.getDescription());
                    batchDtoList.add(batch);
                }
                tt.setBatchListDto(batchDtoList);


                tt.setModuleDto( moduleService.getModuleByIdAPI(timetable.getModule().getModule_id()));

                tt.setDate(String.valueOf(timetable.getDate()));


                //old format
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
                try{
                    java.util.Date startime = sdf.parse(String.valueOf(timetable.getStartTime()));
                    java.util.Date endTime = sdf.parse(String.valueOf(timetable.getEndTIme()));

                    //new format
                    SimpleDateFormat sdf2 = new SimpleDateFormat("hh:mm aa");
                    //formatting the given time to new format with AM/PM

                    tt.setStartTime(sdf2.format(startime));
                    tt.setEndTIme(sdf2.format(endTime));
                }catch(ParseException e){
                    e.printStackTrace();
                }


                tt.setTimetableID(timetable.getTimetableID());
                tt.setClassRoomDTO(classRoomService.viewSingleRoom(timetable.getClassRoom().getRoomId()));
                timetableDtoList.add(tt);
            }
        }

        return timetableDtoList;    }


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

                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
                try{
                    java.util.Date startime = sdf.parse(String.valueOf(timetable.getStartTime()));
                    java.util.Date endTime = sdf.parse(String.valueOf(timetable.getEndTIme()));

                    //new format
                    SimpleDateFormat sdf2 = new SimpleDateFormat("hh:mm aa");
                    //formatting the given time to new format with AM/PM

                    tt.setStartTime(sdf2.format(startime));
                    tt.setEndTIme(sdf2.format(endTime));
                }catch(ParseException e){
                    e.printStackTrace();
                }


                tt.setTimetableID(timetable.getTimetableID());
                tt.setClassRoom(timetable.getClassRoom());
                timetableDtoList.add(tt);
            }
        }

        return timetableDtoList;
    }

    @Override
    public List<TimetableDto> getTodayLecturerTimetableAPI(int UserID) {
        java.util.Date date = new java.util.Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(formatter.format(date));

        List<Timetable> timetablesDomain = timetableRepo.findTimetablesByDateAndModule_LecUser_UserId(Date.valueOf(formatter.format(date)),UserID);

        List<TimetableDto> timetableDtoList = new ArrayList<>();

        if (!timetablesDomain.isEmpty()) {
            for (Timetable timetable : timetablesDomain) {
                TimetableDto tt = new TimetableDto();
                tt.setModuleDto(moduleService.getModuleByIdAPI(timetable.getModule().getModule_id()));
                tt.setDate(String.valueOf(timetable.getDate()));

                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
                try{
                    java.util.Date startime = sdf.parse(String.valueOf(timetable.getStartTime()));
                    java.util.Date endTime = sdf.parse(String.valueOf(timetable.getEndTIme()));

                    //new format
                    SimpleDateFormat sdf2 = new SimpleDateFormat("hh:mm aa");
                    //formatting the given time to new format with AM/PM

                    tt.setStartTime(sdf2.format(startime));
                    tt.setEndTIme(sdf2.format(endTime));
                }catch(ParseException e){
                    e.printStackTrace();
                }

                tt.setTimetableID(timetable.getTimetableID());
                tt.setClassRoomDTO(classRoomService.viewSingleRoom(timetable.getClassRoom().getRoomId()));
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

       return  convertToDTOTimetable(timetablesDomain);
    }

    // API service
    @Override
    public List<TimetableDto> getTodayTablesByDateStduentsApi(String userID) {
        // This object contains the current date value
        java.util.Date date = new java.util.Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(formatter.format(date));

       User userinfo = userRepository.findByUsername(userID);

        Batch batch = batchRepository.findById(userinfo.getBatch().getBatchID()).orElseThrow(RuntimeException::new);

        List<Timetable> timetablesDomain = timetableRepo.findTimetablesByBatchListEqualsAndDate(batch,Date.valueOf(formatter.format(date)));

        List<TimetableDto> timetableDtoList = new ArrayList<>();

        if (!timetablesDomain.isEmpty()) {
            for (Timetable timetable : timetablesDomain) {
                TimetableDto tt = new TimetableDto();
                tt.setModuleDto(moduleService.getModuleByIdAPI(timetable.getModule().getModule_id()));
                tt.setDate(String.valueOf(timetable.getDate()));

                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
                try{
                    java.util.Date startime = sdf.parse(String.valueOf(timetable.getStartTime()));
                    java.util.Date endTime = sdf.parse(String.valueOf(timetable.getEndTIme()));

                    //new format
                    SimpleDateFormat sdf2 = new SimpleDateFormat("hh:mm aa");
                    //formatting the given time to new format with AM/PM

                    tt.setStartTime(sdf2.format(startime));
                    tt.setEndTIme(sdf2.format(endTime));
                }catch(ParseException e){
                    e.printStackTrace();
                }

                tt.setTimetableID(timetable.getTimetableID());
                tt.setClassRoomDTO(classRoomService.viewSingleRoom(timetable.getClassRoom().getRoomId()));
                timetableDtoList.add(tt);
            }
        }

        return timetableDtoList;



    }

    public List<TimetableDto> convertToDTOTimetable(List<Timetable> timetablesDomain){
        List<TimetableDto> timetableDtoList = new ArrayList<>();

        if (!timetablesDomain.isEmpty()) {
            for (Timetable timetable : timetablesDomain) {
                TimetableDto tt = new TimetableDto();
//                tt.setBatch(timetable.getBatch());
                tt.setModule(timetable.getModule());
                tt.setDate(String.valueOf(timetable.getDate()));

                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
                try{
                    java.util.Date startime = sdf.parse(String.valueOf(timetable.getStartTime()));
                    java.util.Date endTime = sdf.parse(String.valueOf(timetable.getEndTIme()));

                    //new format
                    SimpleDateFormat sdf2 = new SimpleDateFormat("hh:mm aa");
                    //formatting the given time to new format with AM/PM

                    tt.setStartTime(sdf2.format(startime));
                    tt.setEndTIme(sdf2.format(endTime));
                }catch(ParseException e){
                    e.printStackTrace();
                }

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

                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
                try{
                    java.util.Date startime = sdf.parse(String.valueOf(timetable.getStartTime()));
                    java.util.Date endTime = sdf.parse(String.valueOf(timetable.getEndTIme()));

                    //new format
                    SimpleDateFormat sdf2 = new SimpleDateFormat("hh:mm aa");
                    //formatting the given time to new format with AM/PM

                    tt.setStartTime(sdf2.format(startime));
                    tt.setEndTIme(sdf2.format(endTime));
                }catch(ParseException e){
                    e.printStackTrace();
                }


                tt.setTimetableID(timetable.getTimetableID());
                tt.setClassRoom(timetable.getClassRoom());
                timetableDtoList.add(tt);
            }
        }

        return timetableDtoList;    }

        //API web service search by student
    @Override
    public List<TimetableDto> searchbyDateStudentAPI(String Date, String userId) {
        User userinfo = userRepository.findByUsername(userId);

        Batch batch = batchRepository.findById(userinfo.getBatch().getBatchID()).orElseThrow(RuntimeException::new);

        List<Timetable> timetablesDomain = timetableRepo.findTimetablesByBatchListEqualsAndDateLike(batch, java.sql.Date.valueOf(Date));

        List<TimetableDto> timetableDtoList = new ArrayList<>();

        if (!timetablesDomain.isEmpty()) {
            for (Timetable timetable : timetablesDomain) {
                TimetableDto tt = new TimetableDto();
                tt.setModuleDto(moduleService.getModuleByIdAPI(timetable.getModule().getModule_id()));
                tt.setDate(String.valueOf(timetable.getDate()));

                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
                try{
                    java.util.Date startime = sdf.parse(String.valueOf(timetable.getStartTime()));
                    java.util.Date endTime = sdf.parse(String.valueOf(timetable.getEndTIme()));

                    //new format
                    SimpleDateFormat sdf2 = new SimpleDateFormat("hh:mm aa");
                    //formatting the given time to new format with AM/PM

                    tt.setStartTime(sdf2.format(startime));
                    tt.setEndTIme(sdf2.format(endTime));
                }catch(ParseException e){
                    e.printStackTrace();
                }

                tt.setTimetableID(timetable.getTimetableID());
                tt.setClassRoomDTO(classRoomService.viewSingleRoom(timetable.getClassRoom().getRoomId()));
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
        timetables.setRequestReschedule(false);
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

    @Override
    public String lecturerRequestReschedule(int timetableID) {
        Timetable timetable= timetableRepo.findById(timetableID).orElseThrow(RuntimeException::new);

        timetable.setRequestReschedule(true);
        timetableRepo.save(timetable);

        emailService.RescheduleRequested(timetable);

        return "done";
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

                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
                try{
                    java.util.Date startime = sdf.parse(String.valueOf(timetable.getStartTime()));
                    java.util.Date endTime = sdf.parse(String.valueOf(timetable.getEndTIme()));

                    //new format
                    SimpleDateFormat sdf2 = new SimpleDateFormat("hh:mm aa");
                    //formatting the given time to new format with AM/PM

                    tt.setStartTime(sdf2.format(startime));
                    tt.setEndTIme(sdf2.format(endTime));
                }catch(ParseException e){
                    e.printStackTrace();
                }

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

                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
                try{
                    java.util.Date startime = sdf.parse(String.valueOf(timetable.getStartTime()));
                    java.util.Date endTime = sdf.parse(String.valueOf(timetable.getEndTIme()));

                    //new format
                    SimpleDateFormat sdf2 = new SimpleDateFormat("hh:mm aa");
                    //formatting the given time to new format with AM/PM

                    tt.setStartTime(sdf2.format(startime));
                    tt.setEndTIme(sdf2.format(endTime));
                }catch(ParseException e){
                    e.printStackTrace();
                }

                tt.setTimetableID(timetable.getTimetableID());
                tt.setClassRoom(timetable.getClassRoom());
                timetableDtoListof.add(tt);
            }
        }

        return timetableDtoListof;    }

    @Override
    public List<TimetableDto> lecturerSearchTimetableAPI(int UserID, String Date) {

        List<Timetable> timetablesDomain = timetableRepo.findTimetablesByModule_LecUser_UserIdAndDateLike(UserID,java.sql.Date.valueOf(Date) );

        List<TimetableDto> timetableDtoList = new ArrayList<>();

        if (!timetablesDomain.isEmpty()) {
            for (Timetable timetable : timetablesDomain) {
                TimetableDto tt = new TimetableDto();
                tt.setModuleDto(moduleService.getModuleByIdAPI(timetable.getModule().getModule_id()));
                tt.setDate(String.valueOf(timetable.getDate()));

                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
                try{
                    java.util.Date startime = sdf.parse(String.valueOf(timetable.getStartTime()));
                    java.util.Date endTime = sdf.parse(String.valueOf(timetable.getEndTIme()));

                    //new format
                    SimpleDateFormat sdf2 = new SimpleDateFormat("hh:mm aa");
                    //formatting the given time to new format with AM/PM

                    tt.setStartTime(sdf2.format(startime));
                    tt.setEndTIme(sdf2.format(endTime));
                }catch(ParseException e){
                    e.printStackTrace();
                }

                tt.setTimetableID(timetable.getTimetableID());
                tt.setClassRoomDTO(classRoomService.viewSingleRoom(timetable.getClassRoom().getRoomId()));
                timetableDtoList.add(tt);
            }
        }

        return timetableDtoList;    }
}
