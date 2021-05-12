package com.janith.eea.Dto;

import com.janith.eea.Model.Batch;
import com.janith.eea.Model.ClassRoom;
import com.janith.eea.Model.Module;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class TimetableDto {
    @Getter
    @Setter
    private Integer timetableID;
    @Getter
    @Setter
    private String startTime;
    @Getter
    @Setter
    private String endTIme;
    @Getter
    @Setter
    private ClassRoom classRoom;

    @Getter
    @Setter
    private Batch batch;

    @Getter
    @Setter
    private Module module;

}
