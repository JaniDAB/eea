package com.janith.eea;

import com.janith.eea.Dto.BatchDto;
import com.janith.eea.Dto.ModuleDto;
import com.janith.eea.Dto.TimetableDto;
import com.janith.eea.Model.Batch;
import com.janith.eea.Model.Module;
import com.janith.eea.Model.Timetable;
import com.janith.eea.Service.BatchService;
import com.janith.eea.Service.ModuleService;
import com.janith.eea.Service.TimeTableService;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class scheduleTesting {

    @Autowired
    private ModuleService moduleService;
    @Autowired
    private CreatedDTO createdDTO;

    @Autowired
    private BatchService batchService;
@Autowired
    private TimeTableService timeTableService;

    @BeforeAll
    public void init() throws Exception {


    }
     @Test
    public  void createTable () throws Exception {


//    TimetableDto timetableDto = new TimetableDto();
//
//         ModuleDto moduel = new ModuleDto();
//         moduel.setModuleCode("m2");
//         moduel.setModuleName("M1");
//         Module mod = moduleService.save(moduel);
//         BatchDto batchDto=   new BatchDto();
//         batchDto.setBatchCode("HF2131SEeng");
//         batchDto.setDescription("Software Engineering");
//
//
//         Batch b= batchService.save(batchDto);
//
//         List<Batch> bl = new ArrayList<>();
//         bl.add(b);
//    timetableDto.setBatchList(bl);
//    timetableDto.setModule(mod);
//    timetableDto.setStartTime("11:00");
//    timetableDto.setEndTIme("12:00");
//    timetableDto.setDate("2021-09-07");
//
//   Timetable test=  timeTableService.addTimetable(timetableDto);
//    assertNotNull(test);

}

}
