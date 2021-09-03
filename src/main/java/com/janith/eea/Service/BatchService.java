package com.janith.eea.Service;

import com.janith.eea.Dto.BatchDto;
import com.janith.eea.Dto.ModuleDto;
import com.janith.eea.Model.Batch;

import java.util.List;

public interface BatchService {
    Batch save(BatchDto batchinfo) throws Exception;

    BatchDto getBatchById(int id);

    List<BatchDto> getAllBatches();

    Object editBatch(BatchDto batchDto) throws Exception;

    List<ModuleDto> getModuleList(int id);

    Batch editBatchInfo(BatchDto batchDto);

    String deleteBatch(int BatchId) throws Exception;
}
