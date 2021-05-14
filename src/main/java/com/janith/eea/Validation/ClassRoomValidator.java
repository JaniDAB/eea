package com.janith.eea.Validation;

import com.janith.eea.Dto.ClassRoomDto;
import com.janith.eea.Repository.ClassRoomRepository;
import com.janith.eea.Service.ClassRoomServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class ClassRoomValidator implements Validator {

    @Autowired
    private  final ClassRoomServiceImpl classRoomService;

    @Autowired
    private final ClassRoomRepository classRoomRepository;

    public ClassRoomValidator(ClassRoomServiceImpl classRoomService, ClassRoomRepository classRoomRepository) {
        this.classRoomService = classRoomService;
        this.classRoomRepository = classRoomRepository;
    }


    @Override
    public boolean supports(Class<?> aClass) {
        return ClassRoomDto.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {

        ClassRoomDto classRoomDto = (ClassRoomDto)o;

        String regex = "^[L][0-9][C][R][0-9]{0,2}$";
        Pattern p = Pattern.compile(regex);
        Matcher matcher = p.matcher(classRoomDto.getRoomId());

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "roomId", "NotEmpty");
        if(!matcher.matches()){
            errors.rejectValue("roomId", "regex.room.!equals");
        }
        if (classRoomRepository.findById(classRoomDto.getRoomId()).isPresent()){
            errors.rejectValue("roomId", "classroom.exist");
        }


    }
}
