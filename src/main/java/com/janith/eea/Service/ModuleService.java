package com.janith.eea.Service;


import com.janith.eea.Dto.BatchDto;
import com.janith.eea.Dto.ModuleDto;
import com.janith.eea.Model.Module;

import java.util.List;

public interface ModuleService {
    Module save(ModuleDto moduleDto) throws Exception;

    ModuleDto getModuleById(int id);

    List<ModuleDto> getAllModules();

Module editModule(ModuleDto moduleDto);

Module assignLecturer(ModuleDto moduleDto);

    String deAssignLecturer(int moduleDto);

List<ModuleDto> viewLecsModules(int userID);

List<BatchDto> getBatchListM(int  moduleID);

}
