package com.janith.eea.Service;

import com.janith.eea.Dto.BatchDto;
import com.janith.eea.Model.Batch;

import java.util.List;

public interface BatchService {
    Batch save(BatchDto batchinfo);

    BatchDto getBatchById(int id);

    List<BatchDto> getAllBatches();

    Batch editBatch(BatchDto batchDto);


}
