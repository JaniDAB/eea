package com.janith.eea.Service;

import com.janith.eea.Dto.ModuleDto;
import com.janith.eea.Model.Module;
import com.janith.eea.Repository.BatchRepository;
import com.janith.eea.Repository.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ModuleServiceImpl implements ModuleService{


    @Autowired
    private ModuleRepository moduleRepository;
    @Autowired
    private BatchRepository batchRepository;



    @Override
    public Module save(ModuleDto moduleDto) {
        Module modeldom = new Module();
modeldom.setBatchList(batchRepository.findAll());
        if(moduleDto != null){
            modeldom.setModuleName(moduleDto.getModuleName());
        }
        return moduleRepository.save(modeldom);

    }
}
