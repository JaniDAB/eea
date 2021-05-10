package com.janith.eea.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class ClassRoom {
    @Getter
    @Setter
    private Integer roomId;
    @Getter
    @Setter
    private  String roomType;
    @Getter
    @Setter
    private  Integer roomCapacity;

}
