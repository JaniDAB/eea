package com.janith.eea.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "class_room", uniqueConstraints = @UniqueConstraint(columnNames = "room_id"))
public class ClassRoom {
    @Id
    @Column(name = "room_id")
    @Getter
    @Setter
    private String roomId;

    @Column(name = "room_type")
    @Getter
    @Setter
    private  String roomType;


    @Column(name = "room_capacity")
    @Getter
    @Setter
    private  Integer roomCapacity;

    @Getter
    @Setter
    @OneToMany(mappedBy = "classRoom")
    private List<Timetable> timetableList;


}
