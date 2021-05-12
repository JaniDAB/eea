package com.janith.eea.Service;

import com.janith.eea.Dto.BatchDto;
import com.janith.eea.Model.Batch;
import com.janith.eea.Repository.BatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BatchServiceImpl  implements BatchService{

    @Autowired
    private BatchRepository batchRepo;

    @Override
    public Batch save(BatchDto batchinfo) {
        Batch batchdom = new Batch();

        if(batchinfo != null){
//            batchdom.setBatchID(batchinfo.getBatchID());
            batchdom.setBatchCode(batchinfo.getBatchCode());
            batchdom.setDescription(batchinfo.getDescription());

        }
        return  batchRepo.save(batchdom);
    }

    @Override
    public BatchDto getBatchById(int id) {
        Optional<Batch> optionalBatch = batchRepo.findById(id);

        BatchDto batchDto =  new BatchDto();

        Batch batch = null;

        if (optionalBatch.isPresent())
        {
            batch =  optionalBatch.get();

            batchDto.setBatchID(batch.getBatchID());
            batchDto.setBatchCode(batch.getBatchCode());
            batchDto.setDescription(batch.getDescription());

        }

        else {
            throw new RuntimeException("No Batch Found by " +id);
        }
        return batchDto;

    }

    @Override
    public List<BatchDto> getAllBatches() {
        List<Batch> batchList =  batchRepo.findAll();

        List<BatchDto> batchDtoList =  new ArrayList<>();

        if(batchList != null){
            for(Batch batch :batchList){
                BatchDto batchDto = new BatchDto();

                batchDto.setBatchID(batch.getBatchID());
                batchDto.setBatchCode(batch.getBatchCode());
                batchDto.setDescription(batch.getDescription());

                batchDtoList.add(batchDto);
            }
        }
        return batchDtoList;
    }

    @Override
    public Batch editBatch(BatchDto batchDto) {

        Optional<Batch> optionalBatch =  batchRepo.findById(batchDto.getBatchID());


        Batch batch =optionalBatch.get();

        if (batch != null){

            batch.setBatchCode(batchDto.getBatchCode());
            batch.setDescription(batchDto.getDescription());
        }
        return batchRepo.save(batch);
    }


}
