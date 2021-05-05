package com.janith.eea.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "timetable")
public class Timetable {
    @Id
    @Column(name = "timetable_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer timetableID;

    @Column(name = "start_time")
    private String startTime;

    @Column(name = "end_time")
    private String endTIme;



    public Timetable() {
    }

    public Integer getTimetableID() {
        return timetableID;
    }

    public void setTimetableID(Integer timetableID) {
        this.timetableID = timetableID;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTIme() {
        return endTIme;
    }

    public void setEndTIme(String endTIme) {
        this.endTIme = endTIme;
    }
}
