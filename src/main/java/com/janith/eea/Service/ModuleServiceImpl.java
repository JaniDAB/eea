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
public class ModuleServiceImpl implements ModuleService {


    @Autowired
    private ModuleRepository moduleRepository;
    @Autowired
    private BatchRepository batchRepository;


    @Override
    public Module save(ModuleDto moduleDto) {
        Module modeldom = new Module();

//modeldom.setBatchList(batchRepository.findAll());

        if (moduleDto != null) {
            modeldom.setModuleName(moduleDto.getModuleName().trim());
            modeldom.setModuleCode(moduleDto.getModuleCode().trim());
        }
        return moduleRepository.save(modeldom);

    }

    @Override
    public ModuleDto getModuleById(int id) {

        Optional<Module> optionalModule = moduleRepository.findById(id);

        ModuleDto moduleDto = new ModuleDto();

        Module moduleinfo = null;
        if (optionalModule.isPresent()) {
            moduleinfo = optionalModule.get();

            moduleDto.setModule_id(moduleinfo.getModule_id());
            moduleDto.setModuleName(moduleinfo.getModuleName());
            moduleDto.setModuleCode(moduleinfo.getModuleCode());
        } else {
            throw new RuntimeException("No Module Found" + id);
        }
        return moduleDto;

    }

    @Override
    public List<ModuleDto> getAllModules() {
        List<Module> modeList = moduleRepository.findAll();

        List<ModuleDto> moduleDtoList = new ArrayList<>();

        if (modeList != null) {
            for (Module model : modeList) {
                ModuleDto moduleDto = new ModuleDto();

                moduleDto.setBatchList(model.getBatchList());
                moduleDto.setModule_id(model.getModule_id());
                moduleDto.setModuleName(model.getModuleName());
                moduleDto.setLecUser(model.getLecUser());
                moduleDto.setModuleCode(model.getModuleCode());

                moduleDtoList.add(moduleDto);
            }
        }
        return moduleDtoList;
    }

    @Override
    public Module editModule(ModuleDto moduleDto) {
        Optional<Module> optionalModule = moduleRepository.findById(moduleDto.getModule_id());

        Module module = optionalModule.get();

        if (module != null) {
//            module.setModule_id(moduleDto.getModule_id());
            module.setModuleName(moduleDto.getModuleName());

        }

        return moduleRepository.save(module);

    }

    @Override
    public Module assignLecturer(ModuleDto moduleDto) {

        Optional<Module> optionalModule = moduleRepository.findById(moduleDto.getModule_id());

        Module module = optionalModule.get();

        module.setLecUser(moduleDto.getLecUser());

        return moduleRepository.save(module);
    }

    @Override
    public String deAssignLecturer(int moduleDto) {
        try {
            Module optionalModule = moduleRepository.findById(moduleDto).get();
            optionalModule.setLecUser(null);
            moduleRepository.save(optionalModule);
            return "deleted";
        }
        catch (Exception EX)
        {
            System.out.println(EX);
            return "error";
        }
    }

    @Override
    public List<ModuleDto> viewLecsModules(int userID) {
        List<Module> moduleList = moduleRepository.findModuleByLecUser_UserId(userID);

        List<ModuleDto> moduleDtoList = new ArrayList<>();

        if (moduleList != null) {
            for (Module model : moduleList) {
                ModuleDto moduleDto = new ModuleDto();

                moduleDto.setModule_id(model.getModule_id());
                moduleDto.setModuleName(model.getModuleName());
                moduleDto.setLecUser(model.getLecUser());
                moduleDto.setBatchList(model.getBatchList());
                moduleDtoList.add(moduleDto);
            }
        }
        return moduleDtoList;
    }

    @Override
    public List<BatchDto> getBatchListM(int moduleID) {

        Optional<Module> optionalModule = moduleRepository.findById(moduleID);

        List<BatchDto> batchDtoList = new ArrayList<>();

        Module moduleInfo = null;

        if (optionalModule.isPresent()) {
            moduleInfo = optionalModule.get();
            for (Batch batch : moduleInfo.getBatchList()) {
                BatchDto batchDto = new BatchDto();
                batchDto.setBatchID(batch.getBatchID());
                batchDto.setBatchCode(batch.getBatchCode());
                batchDto.setDescription(batch.getDescription());
                batchDtoList.add(batchDto);
            }
        }
        return batchDtoList;
    }
}

