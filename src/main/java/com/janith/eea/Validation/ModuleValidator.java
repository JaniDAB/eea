package com.janith.eea.Validation;

import com.janith.eea.Dto.BatchDto;
import com.janith.eea.Dto.ModuleDto;
import com.janith.eea.Repository.ModuleRepository;
import com.janith.eea.Service.ModuleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

        ModuleDto moduleDto = (ModuleDto) o;

        String moduelCodeReg = "^[a-zA-z]{4}[0-9]{1,5}$";

        Pattern maduleCo = Pattern.compile(moduelCodeReg);

        Matcher matcher = maduleCo.matcher(moduleDto.getModuleCode());


//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "moduleName", "NotEmpty");

        if(moduleRepository.findByModuleName(moduleDto.getModuleName().trim()) != null)
        {
            errors.rejectValue("moduleName", "Duplicate.module.moduleName");
        }
//        if(!matcher.matches()){
//            errors.rejectValue("moduleCode", "module.moduleCode.invalid");
//        }

        if(moduleRepository.findByModuleCode(moduleDto.getModuleCode()) != null){
            errors.rejectValue("moduleCode", "Duplicate.moduleCode");
        }

        if(moduleDto.getModuleName().trim().length() < 3 || moduleDto.getModuleName().trim().length() > 50){
            errors.rejectValue("moduleName", "Size.module.name");
        }
    }
}
