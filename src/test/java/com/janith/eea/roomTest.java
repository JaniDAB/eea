package com.janith.eea;


import com.janith.eea.Dto.ClassRoomDto;
import com.janith.eea.Model.ClassRoom;
import com.janith.eea.Service.ClassRoomServiceImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class roomTest {


    @Autowired
    private ClassRoomServiceImpl classRoomService;

    @Autowired
    private CreatedDTO createdDTO;


    private String roomId;

    @BeforeAll
    public void init() throws Exception {

        roomId = createdDTO.roomCreation();

    }
    @Test
    public void testAddRoom() throws Exception {
        ClassRoomDto room = new ClassRoomDto();
        room.setRoomId("L3CR5");
        room.setRoomType("Hall");
room.setRoomCapacity(20);
        ClassRoom result = classRoomService.addRoom(room);

        assertNotNull(result);

        System.out.println("[TEST] Adding a room [PASSED]");
    }
    @Test
    public void testGetAllRooms() {
        List<ClassRoomDto> results = classRoomService.viewRooms();

        System.out.println(results.size());

        boolean isTrue = results.size() > 0;

        assertTrue(isTrue);

        System.out.println("[TEST] Get all rooms [PASSED]");
    }

    @Test
    public void testDeleteRoom()  {
        classRoomService.deleteRoom(roomId);
        List<ClassRoomDto> results = classRoomService.viewRooms();

        boolean isTrue = true;

        for (ClassRoomDto dto : results) {
            if (dto.getRoomId() == roomId) {
                isTrue = false;
                break;
            }
        }

        assertTrue(isTrue);

        System.out.println("[TEST] Delete room [PASSED]");
    }
}
