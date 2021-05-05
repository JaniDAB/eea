package com.janith.eea.Service;

import com.janith.eea.Dto.BatchDto;
import com.janith.eea.Model.Batch;

public interface BatchService {
    Batch save(BatchDto batchinfo);

}
