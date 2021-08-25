package com.janith.eea.Repository;

import com.janith.eea.Model.Batch;
import com.janith.eea.Model.ClassRoom;
import com.janith.eea.Model.Timetable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface TimetableRepository extends JpaRepository<Timetable,Integer> {

//    public List<Timetable> findTimetableBy(int batchID);



     List<Timetable> findTimetablesByBatchListEquals(Batch BatchID);

     List<Timetable> findTimetablesByModule_LecUser_UserId(int userID);

     List<Timetable> findTimetablesByClassRoomAndDate(ClassRoom classRoom, Date date);

//public  List<Timetable> findTimetableByDate(Date date);

//    public  List<Timetable> findTimetableByBatchListAndDate(List<Batch> batchList, Date date);

//    public List<Timetable> findByBatchListAndDate(List<Batch> batchList, Date date);

      List<Timetable> findTimetablesByDateAndModule_LecUser_UserId(Date date, Integer module_lecUser_userId);

     List<Timetable> findTimetablesByBatchListEqualsAndDate(Batch BatchID,Date Date);

        List<Timetable> findTimetablesByBatchListEqualsAndDateLike(Batch BatchID,Date date);

     List<Timetable> findTimetablesByModule_LecUser_UserIdAndDateLike(int userID , Date date);

    List<Timetable> getAllByBatchListEqualsAndDateEquals(Batch batch , Date date);


    List<Timetable> findTimetablesByRequestReschedule(boolean state);

    List<Timetable> findAllByOrderByDateDesc();
}
