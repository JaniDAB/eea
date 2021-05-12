package com.janith.eea.Service;


import com.janith.eea.Dto.ModuleDto;
import com.janith.eea.Model.Module;

import java.util.List;

public interface ModuleService {
    Module save(ModuleDto moduleDto);

    ModuleDto getModuleById(int id);

    List<ModuleDto> getAllModules();

Module editModule(ModuleDto moduleDto);

Module assignLecturer(ModuleDto moduleDto);


}
