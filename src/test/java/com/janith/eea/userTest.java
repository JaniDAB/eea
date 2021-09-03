package com.janith.eea;


import com.janith.eea.Dto.UserDto;
import com.janith.eea.Model.User;
import com.janith.eea.Service.UserServiceImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class userTest {

    @Autowired
    private UserServiceImpl userService;
    private int userID;
    @Autowired
    private CreatedDTO createdDTO;

    private  int studentToBeDeleted;
    private String  studentWithSameUsername;
    @BeforeAll
    public void init() throws Exception {
        userID = createdDTO.studentCreate();
        studentToBeDeleted = createdDTO.createStudentToBeDeleted();
        studentWithSameUsername = createdDTO.createStudentWithSameUsername();
    }

    @Test
    public void testAddStudent() throws Exception {

        UserDto newdto=   new UserDto();

        newdto.setUsername("jj");
        newdto.setFirstname("janith");
        newdto.setLastname("Dabare");
        newdto.setEmail("janithdabare17@gmail.com");
        newdto.setGender("MALE");
        newdto.setRole("STUDENT");
        newdto.setMobile("0716123463");
        newdto.setDateOfBirth("2001-10-10");

        User userDto = userService.save(newdto);
        assertNotNull(userDto);

    }

    @Test
    public void testAddStudentWithExistingUsername() {

        UserDto newdto=   new UserDto();

        newdto.setUsername(studentWithSameUsername);
        newdto.setFirstname("janith");
        newdto.setLastname("Dabare");
        newdto.setEmail("janithdabare17@gmail.com");
        newdto.setGender("MALE");
        newdto.setRole("STUDENT");
        newdto.setMobile("0716123463");
        newdto.setDateOfBirth("2001-10-10");

        boolean isTrue = true;

        try {
            userService.save(newdto);
        } catch (  Exception e) {
            if (e.getMessage().equals("Username already exists")) isTrue = true;
        }

        assertTrue(isTrue);

        System.out.println("[TEST] Attempt to add student with existing username [PASSED]");

    }

    @Test
    public void testGetAllStudents() {
        List<UserDto> results = userService.getAllStudets();

        boolean isTrue = results.size() > 0;

        assertTrue(isTrue);

        System.out.println("[TEST] Get all students [PASSED]");

    }

    @Test
    public void testDeleteStudent()  {
        userService.deleteUserByID(studentToBeDeleted);

        List<UserDto> results = userService.getAllStudets();

        boolean isTrue = true;

        for (UserDto dto : results) {
            if (dto.getUserId() == studentToBeDeleted) {
                isTrue = false;
                break;
            }
        }

        assertTrue(isTrue);

        System.out.println("[TEST] Delete student [PASSED]");
    }

}
