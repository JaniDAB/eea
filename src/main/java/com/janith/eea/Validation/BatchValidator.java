package com.janith.eea.Validation;

import com.janith.eea.Dto.BatchDto;
import com.janith.eea.Repository.BatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class BatchValidator implements Validator {

    @Autowired
    private final BatchRepository batchRepository;

    public BatchValidator(BatchRepository batchRepository) {
        this.batchRepository = batchRepository;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return BatchDto.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {

        BatchDto batchDto = (BatchDto) o;

        String batchregex = "^[a-zA-z]{1,4}[0-9]{1,5}[a-zA-z]{2,5}$";

        Pattern batchR = Pattern.compile(batchregex);

        Matcher matcher = batchR.matcher(batchDto.getBatchCode());

//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "batchCode", "NotEmpty");

//        if(!matcher.matches()){
//            errors.rejectValue("batchCode", "batch.batchCode.!invalid");
//        }
        if(batchRepository.findBatchesByBatchCode(batchDto.getBatchCode()) != null){
            errors.rejectValue("batchCode", "Duplicate.batchCode");
        }

//
//        if(batchDto.getDescription().trim().length() < 3 || batchDto.getDescription().trim().length() > 20){
//            errors.rejectValue("description", "Size.module.name");
//        }

    }
}

