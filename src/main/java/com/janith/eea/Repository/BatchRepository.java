package com.janith.eea.Repository;

import com.janith.eea.Dto.BatchDto;
import com.janith.eea.Model.Batch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BatchRepository extends JpaRepository<Batch,Integer> {

public Batch findBatchesByBatchCode(String bachCode);


}
