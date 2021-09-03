package com.janith.eea;

import com.janith.eea.Dto.BatchDto;
import com.janith.eea.Dto.ClassRoomDto;
import com.janith.eea.Dto.UserDto;
import com.janith.eea.Model.Batch;
import com.janith.eea.Model.Module;
import com.janith.eea.Model.User;
import com.janith.eea.Service.BatchService;
import com.janith.eea.Service.BatchServiceImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class batchTest {

    @Autowired
    private CreatedDTO createdDTO;

    int BatchId;
    @Autowired

    private BatchService batchService;
    @BeforeAll
    public void init() throws Exception {
         BatchId = createdDTO.batchCreate();

    }

    @Test
    public void testAddBatch() throws Exception {

        BatchDto batchDto=   new BatchDto();
batchDto.setBatchCode("HF1231SEeng");
batchDto.setDescription("Software Engineering");


        Batch save = batchService.save(batchDto);
        assertNotNull(save);

    }

//    @Test
//    public void testGetAllBatches() throws Exception {
//
//        Module m =  createdDTO.createModule();
//        BatchId = createdDTO.batchCreate();
//        Object b =   createdDTO.setModules();
//
//        List<BatchDto> results = batchService.getAllBatches();
//
//        System.out.println(results.size());
//
//        boolean isTrue = results.size() > 0;
//
//        assertTrue(isTrue);
//
//        System.out.println("[TEST] Get all Batches [PASSED]");
//    }
}
