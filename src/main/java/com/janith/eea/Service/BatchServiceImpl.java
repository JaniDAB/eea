package com.janith.eea.Service;

import com.janith.eea.Dto.BatchDto;
import com.janith.eea.Dto.ModuleDto;
import com.janith.eea.Model.Batch;
import com.janith.eea.Model.Module;
import com.janith.eea.Repository.BatchRepository;
import com.janith.eea.Repository.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BatchServiceImpl implements BatchService {

    @Autowired
    private BatchRepository batchRepo;

    @Autowired
    private ModuleRepository moduleRepository;

    @Override
    public Batch save(BatchDto batchinfo) throws Exception {
        Batch batchdom = new Batch();

        if(batchRepo.findBatchesByBatchCode(batchinfo.getBatchCode())!=null){
            throw new Exception("Batch :"+batchinfo.getBatchCode()+"Already Added");
        }
        if (batchinfo != null) {
//            batchdom.setBatchID(batchinfo.getBatchID());
            batchdom.setBatchCode(batchinfo.getBatchCode().trim());
            batchdom.setDescription(batchinfo.getDescription().trim());

        }
        return batchRepo.save(batchdom);
    }

    @Override
    public BatchDto getBatchById(int id) {
        Optional<Batch> optionalBatch = batchRepo.findById(id);

        BatchDto batchDto = new BatchDto();

        Batch batch = null;

        if (optionalBatch.isPresent()) {
            batch = optionalBatch.get();

            batchDto.setBatchID(batch.getBatchID());
            batchDto.setBatchCode(batch.getBatchCode());
            batchDto.setDescription(batch.getDescription());

        } else {
            throw new RuntimeException("No Batch Found by " + id);
        }
        return batchDto;

    }

    @Override
    public List<BatchDto> getAllBatches() {
        List<Batch> batchList = batchRepo.findAll();

        List<BatchDto> batchDtoList = new ArrayList<>();

        if (batchList != null) {
            for (Batch batch : batchList) {
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

        Optional<Batch> optionalBatch = batchRepo.findById(batchDto.getBatchID());


        ArrayList<Module> moduleArrayList = new ArrayList<>();

        Batch batch = optionalBatch.get();

        for (String s : batchDto.getModuleList()) {
            Optional<Module> byId = moduleRepository.findById(Integer.parseInt(s));

            moduleArrayList.add(byId.get());

            if (batch != null) {

//                batch.setBatchCode(batchDto.getBatchCode());
//                batch.setDescription(batchDto.getDescription());
                batch.setModuleList(moduleArrayList);
            }
        }
        return batchRepo.save(batch);
    }

    @Override
    public List<ModuleDto> getModuleList(int batchID) {
        // a convertion of module list to A dto TYPE

        Optional<Batch> optionalBatch = batchRepo.findById(batchID);



        List<ModuleDto> moduleDtoList = new ArrayList<>();


        Batch batchinfor = null;

        if (optionalBatch.isPresent()) {
            batchinfor = optionalBatch.get();

            for (Module mudulel : batchinfor.getModuleList()) {

                ModuleDto moduleDto = new ModuleDto();
                moduleDto.setModuleName(mudulel.getModuleName());
                moduleDto.setModule_id(mudulel.getModule_id());
                moduleDtoList.add(moduleDto);
            }
        }
        return moduleDtoList;
    }



    @Override
    public Batch editBatchInfo(BatchDto batchDto) {
        Optional<Batch> optionalBatch = batchRepo.findById(batchDto.getBatchID());


        Batch batch = optionalBatch.get();

        if (batch != null) {

                batch.setBatchCode(batchDto.getBatchCode());
                batch.setDescription(batchDto.getDescription());

        }

        return batchRepo.save(batch);
    }

    @Override
    public String deleteBatch(int BatchId) {
        try {
            this.batchRepo.deleteById(BatchId);
            return "deleted";
        }
        catch (Exception EX)
        {
            System.out.println(EX);
            return "error";
        }

    }
}
