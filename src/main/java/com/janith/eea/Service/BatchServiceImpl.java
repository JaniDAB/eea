package com.janith.eea.Service;

import com.janith.eea.Dto.BatchDto;
import com.janith.eea.Model.Batch;
import com.janith.eea.Repository.BatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
