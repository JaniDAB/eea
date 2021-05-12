package com.janith.eea.Service;

import com.janith.eea.Dto.ClassRoomDto;
import com.janith.eea.Model.ClassRoom;
import com.janith.eea.Repository.ClassRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClassRoomServiceImpl implements ClassRoomService{


    @Autowired
     private  final ClassRoomRepository roomRepository;

    public ClassRoomServiceImpl(ClassRoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public ClassRoom addRoom(ClassRoomDto classRoomDto) {
        ClassRoom classRoom = new ClassRoom();

        if(classRoomDto != null){
            classRoom.setRoomId(classRoomDto.getRoomId());
            classRoom.setRoomCapacity(classRoomDto.getRoomCapacity());
            classRoom.setRoomType(classRoomDto.getRoomType());

        }
        return roomRepository.save(classRoom);
    }

    @Override
    public List<ClassRoomDto> viewRooms() {
        List<ClassRoom> classRooms = roomRepository.findAll();

        List<ClassRoomDto> classRoomDtoslist =  new ArrayList<>();

        if(classRooms != null) {
            for (ClassRoom classRoom : classRooms) {

                ClassRoomDto classRoomDto = new ClassRoomDto();

                classRoomDto.setRoomId(classRoom.getRoomId());
                classRoomDto.setRoomCapacity(classRoom.getRoomCapacity());
                classRoomDto.setRoomType(classRoom.getRoomType());

                classRoomDtoslist.add(classRoomDto);
            }

        }
        return classRoomDtoslist;
    }
}
