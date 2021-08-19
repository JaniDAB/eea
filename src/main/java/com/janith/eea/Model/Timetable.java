package com.janith.eea.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "timetable")
public class Timetable {
    @Id
    @Column(name = "timetable_id")
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer timetableID;

    @Column(name = "date")
    @Getter
    @Setter
    private Date date;

    @Column(name = "start_time")
    @Getter
    @Setter
    private LocalTime startTime;

    @Column(name = "end_time")
    @Getter
    @Setter
    private LocalTime endTIme;

    @Column(name = "request_Reschedule")
    @Getter
    @Setter
    private boolean requestReschedule;

@ManyToOne
@JoinColumn(name = "room_id")
@Getter
@Setter
private ClassRoom classRoom;

//    @ManyToOne
//    @JoinColumn(name = "batch_id")
    @Setter
    @Getter
//    private Batch batch;
@ManyToMany
@JoinTable(name = "timetable_batch",
        joinColumns = @JoinColumn(name = "timetable_id"),
        inverseJoinColumns = @JoinColumn(name = "batch_id"))
private List<Batch> batchList;

    @ManyToOne
    @JoinColumn(name = "module_id")
    @Setter
    @Getter
    private Module module;


    public Timetable() {
    }

}
