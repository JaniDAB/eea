package com.janith.eea.Service;

import com.janith.eea.Dto.ModuleDto;
import com.janith.eea.Model.Module;
import com.janith.eea.Repository.BatchRepository;
import com.janith.eea.Repository.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public ModuleDto getModuleById(int id) {
        return null;
    }

    @Override
    public List<ModuleDto> getAllModules() {
       List<Module> modeList = moduleRepository.findAll();

       List<ModuleDto> moduleDtoList = new ArrayList<>();

       if(modeList != null){
           for( Module model :modeList){
               ModuleDto moduleDto = new ModuleDto();

               moduleDto.setModule_id(model.getModule_id());
               moduleDto.setModuleName(model.getModuleName());

               moduleDtoList.add(moduleDto);
           }
       }
       return  moduleDtoList;
    }

}
