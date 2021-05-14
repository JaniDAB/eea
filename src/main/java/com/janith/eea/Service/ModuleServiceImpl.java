package com.janith.eea.Service;

import com.janith.eea.Dto.ModuleDto;
import com.janith.eea.Model.Module;
import com.janith.eea.Repository.BatchRepository;
import com.janith.eea.Repository.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ModuleServiceImpl implements ModuleService{


    @Autowired
    private ModuleRepository moduleRepository;
    @Autowired
    private BatchRepository batchRepository;



    @Override
    public Module save(ModuleDto moduleDto) {
        Module modeldom = new Module();

//modeldom.setBatchList(batchRepository.findAll());

        if(moduleDto != null){
            modeldom.setModuleName(moduleDto.getModuleName());
        }
        return moduleRepository.save(modeldom);

    }

    @Override
    public ModuleDto getModuleById(int id) {

        Optional<Module> optionalModule = moduleRepository.findById(id);

        ModuleDto moduleDto = new ModuleDto();

        Module moduleinfo =null;
        if(optionalModule.isPresent()){
            moduleinfo = optionalModule.get();

            moduleDto.setModule_id(moduleinfo.getModule_id());
            moduleDto.setModuleName(moduleinfo.getModuleName());
        }

        else {
            throw new RuntimeException("No Module Found" +id);
        }
        return moduleDto;

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
               moduleDto.setLecUser(model.getLecUser());

               moduleDtoList.add(moduleDto);
           }
       }
       return  moduleDtoList;
    }

    @Override
    public Module editModule(ModuleDto moduleDto) {
        Optional<Module> optionalModule = moduleRepository.findById(moduleDto.getModule_id());

        Module module = optionalModule.get();

        if( module !=null){
//            module.setModule_id(moduleDto.getModule_id());
            module.setModuleName(moduleDto.getModuleName());

        }

        return moduleRepository.save(module);

    }

    @Override
    public Module assignLecturer(ModuleDto moduleDto) {

        Optional<Module> optionalModule = moduleRepository.findById(moduleDto.getModule_id());

        Module module = optionalModule.get();

        if(module != null){
            module.setLecUser(moduleDto.getLecUser());

        }
        return moduleRepository.save(module);
    }

}
