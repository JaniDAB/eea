package com.janith.eea.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "timetable")
public class Timetable {
    @Id
    @Column(name = "timetable_id")
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer timetableID;

    @Column(name = "start_time")
    @Getter
    @Setter
    private String startTime;

    @Column(name = "end_time")
    @Getter
    @Setter
    private String endTIme;


@ManyToOne
@JoinColumn(name = "room_id")
@Getter
@Setter
private ClassRoom classRoom;

    public Timetable() {
    }

}
