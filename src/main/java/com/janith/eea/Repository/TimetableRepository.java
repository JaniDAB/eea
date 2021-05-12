package com.janith.eea.Repository;

import com.janith.eea.Model.Timetable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimetableRepository extends JpaRepository<Timetable,Integer> {
}
