package com.janith.eea.Service;


import com.janith.eea.Dto.BatchDto;
import com.janith.eea.Dto.ModuleDto;
import com.janith.eea.Model.Module;

import java.util.List;

public interface ModuleService {
    Module save(ModuleDto moduleDto) throws Exception;

    ModuleDto getModuleById(int id);
    ModuleDto getModuleByIdAPI(int id);
    List<ModuleDto> getAllModules();

    List<ModuleDto> getAllModulestoAPI();

Module editModule(ModuleDto moduleDto);

Module assignLecturer(ModuleDto moduleDto);

    Module deAssignLecturer(int moduleDto) throws Exception;

List<ModuleDto> viewLecsModules(int userID);

    List<ModuleDto> viewLecsModulesAPI(int userID);


List<BatchDto> getBatchListM(int  moduleID);

}
