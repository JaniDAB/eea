package com.janith.eea.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "classRoom")
public class ClassRoom {
    @Id
    @Column(name = "room_id")
    @Getter
    @Setter
    private Integer roomId;

    @Column(name = "room_type")
    @Getter
    @Setter
    private  String roomType;


    @Column(name = "room_capacity")
    @Getter
    @Setter
    private  Integer roomCapacity;

    public ClassRoom() {
    }

}
