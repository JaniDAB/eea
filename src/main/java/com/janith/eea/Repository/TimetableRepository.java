package com.janith.eea.Repository;

import com.janith.eea.Model.Timetable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimetableRepository extends JpaRepository<Timetable,Integer> {

    public List<Timetable> findTimetableByBatch_BatchID(int batchID);


}
