package com.janith.eea.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Pattern;


public class ClassRoomDto {

    @Pattern(regexp = "^[L][0-9][C][R][0-9]{0,2}$", message = "Invalid Room ID")
    private String roomId;


    private  String roomType;

    private  Integer roomCapacity;

    public ClassRoomDto() {
    }

    public ClassRoomDto(@Pattern(regexp = "^[L][0-9][C][R][0-9]{0,2}$", message = "Invalid Room ID") String roomId, String roomType, Integer roomCapacity) {
        this.roomId = roomId;
        this.roomType = roomType;
        this.roomCapacity = roomCapacity;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public Integer getRoomCapacity() {
        return roomCapacity;
    }

    public void setRoomCapacity(Integer roomCapacity) {
        this.roomCapacity = roomCapacity;
    }
}
