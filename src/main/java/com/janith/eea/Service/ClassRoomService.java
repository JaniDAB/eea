package com.janith.eea.Service;

import com.janith.eea.Dto.ClassRoomDto;
import com.janith.eea.Model.ClassRoom;

import java.util.List;

public interface ClassRoomService {
    ClassRoom addRoom(ClassRoomDto classRoomDto) throws Exception;

    List<ClassRoomDto> viewRooms();

    ClassRoom editRoom(ClassRoomDto classRoomDto);

    String deleteRoom(String roomID);

    ClassRoomDto viewSingleRoom(String ID);
}
