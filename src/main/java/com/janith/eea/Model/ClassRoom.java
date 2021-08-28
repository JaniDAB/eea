package com.janith.eea.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity
@NoArgsConstructor
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

    public ClassRoom(String roomId, String roomType, Integer roomCapacity) {
        this.roomId = roomId;
        this.roomType = roomType;
        this.roomCapacity = roomCapacity;
    }
}
