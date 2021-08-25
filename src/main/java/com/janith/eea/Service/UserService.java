package com.janith.eea.Service;

import com.janith.eea.Dto.UserDto;
import com.janith.eea.Model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    User save(UserDto registerUser) throws Exception;


    boolean passwordencoder(String Password, String pass);

    List<UserDto> getAllUsers();

    List<UserDto> getAllStudets();

    List<UserDto> getAllStudentToAPI();
    List<UserDto> getAllStudentToAPIByBatchCode(String batchCode);

    List<UserDto> getAllLecturersToAPI();


    List<UserDto> getAllLecturers();

     User editUser(UserDto userDto);

     UserDto getUserById(int id);

    UserDto getUserByIdAPI(int id);

    User assignBatch(UserDto userDto);

    String deAssignBatch(int id);

     String deleteUserByID(int ID);

     User updateStudent(UserDto userDto);


    User updatePasswordStudent(UserDto userDto);

    List<UserDto> searchUser(String fname);

    List<UserDto> listOfUsersBatch(int batchID);
}

