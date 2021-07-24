package com.janith.eea.Service;

import com.janith.eea.Dto.BatchDto;
import com.janith.eea.Model.Batch;
import com.janith.eea.Repository.BatchRepository;
import com.janith.eea.WebController.BatchController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class BatchServiceTest {

    @Autowired
    private BatchService batchService;

    @MockBean
    private BatchRepository batchRepository;

    @Test
    void findBatchTest() {
        when(batchRepository.findAll()).thenReturn(
                Stream.of(new Batch("HF12SEeng","Software batch")).collect(
                        Collectors.toList()
                )
        );
        assertEquals(1,batchService.getAllBatches().size());
    }

    @Test
    void saveBatch() {
        Batch batch = new Batch("HF12SEeng","Software batch");
        BatchDto batchDto = null;
 
        when(batchRepository.save(batch)).thenReturn(batch);

        assertEquals(batch ,batchService.save(batchDto));
    }
}