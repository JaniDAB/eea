package com.janith.eea.Repository;

import com.janith.eea.Model.Batch;
import com.janith.eea.Model.Timetable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimetableRepository extends JpaRepository<Timetable,Integer> {

//    public List<Timetable> findTimetableBy(int batchID);


    public List<Timetable> findTimetablesByBatchListEquals(Batch BatchID);

    public List<Timetable> findTimetablesByModule_LecUser_UserId(int userID);
}
