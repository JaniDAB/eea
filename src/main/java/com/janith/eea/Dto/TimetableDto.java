package com.janith.eea.Dto;

import com.janith.eea.Model.Batch;
import com.janith.eea.Model.ClassRoom;
import com.janith.eea.Model.Module;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
public class TimetableDto {
    @Getter
    @Setter
    private Integer timetableID;

    @Getter
    @Setter
    private String Date;

    @Getter
    @Setter
    private String startTime;

    @Getter
    @Setter
    private String endTIme;

    @Getter
    @Setter
    private ClassRoom classRoom;

    //API
    @Getter
    @Setter
    private ClassRoomDto classRoomDTO;

    @Getter
    @Setter
    private List<Batch> batchList;

    //API
    @Getter
    @Setter
    private List<BatchDto> batchListDto;

    @Getter
    @Setter
    private Module module;

    //API
    @Getter
    @Setter
    private ModuleDto moduleDto;

}
