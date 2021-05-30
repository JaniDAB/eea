package com.janith.eea.Validation;

import com.janith.eea.Dto.ModuleDto;
import com.janith.eea.Repository.ModuleRepository;
import com.janith.eea.Service.ModuleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ModuleValidator implements Validator {


    @Autowired
    private final ModuleServiceImpl moduleService;

    @Autowired
    private  final ModuleRepository moduleRepository;

    public ModuleValidator(ModuleServiceImpl moduleService, ModuleRepository moduleRepository) {
        this.moduleService = moduleService;
        this.moduleRepository = moduleRepository;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return ModuleDto.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {

        ModuleDto moduleDto =(ModuleDto)o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "moduleName", "NotEmpty");

        if(moduleRepository.findByModuleName(moduleDto.getModuleName().trim()) != null)
        {
            errors.rejectValue("moduleName", "Duplicate.module.moduleName");
        }

    }
}
