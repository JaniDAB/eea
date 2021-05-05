package com.janith.eea.Service;

import com.janith.eea.Dto.ModuleDto;
import com.janith.eea.Model.Module;

public interface ModuleService {
    Module save(ModuleDto moduleDto);
}
