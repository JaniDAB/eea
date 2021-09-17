package com.janith.eea.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


public class ClassRoomDto {

@Pattern(regexp = "^[L][0-9][C][R][0-9]{0,2}$",message = "Please Re - Enter the Room ID as Requested")
    private String roomId;


    private  String roomType;

    @Digits(integer = 2, fraction = 0, message = "Max is 50")
    @Max(50)
    private  Integer roomCapacity;

    public ClassRoomDto() {
    }

    public ClassRoomDto(String roomId, String roomType, Integer roomCapacity) {
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
