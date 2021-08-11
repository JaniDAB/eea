package com.janith.eea.Service;

import com.janith.eea.Config.Auth;
import com.janith.eea.Dto.UserDto;
import com.janith.eea.Model.User;
import com.janith.eea.Model.UserRole;
import com.janith.eea.Repository.UserRepository;
import com.janith.eea.Util.UserTypeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private EmailServiceImpl emailService;

    public User getUser(String username) {
        return userRepository.findUsersByUsername(username);
    }

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

// function for save the timetable users
    @Override
    public User save(UserDto registerUser) throws Exception {
        User userdomain = new User();
        UserRole userRole = new UserRole();

        String DefaultPassword = "user123";
        String LecturerPwd = "lec123";
        if (userRepository.findUsersByUsername(registerUser.getUsername()) != null) {
          // changed done return null;
            throw  new Exception("User : " + registerUser.getUsername() + " is Already in System");
        } else {
            if (registerUser != null) {
                userdomain.setUsername(registerUser.getUsername().trim());
                userdomain.setFirstname(registerUser.getFirstname().trim());
                userdomain.setLastname(registerUser.getLastname().trim());
                userdomain.setEmail(registerUser.getEmail().toLowerCase(Locale.ROOT)); // validation
                userdomain.setMobile(registerUser.getMobile());

                userRole.setRoleName(UserTypeUtil.fromText(registerUser.getRole()));
                userdomain.setRole(userRole);
                if (userdomain.getRole().getRoleName().equals(UserTypeUtil.STUDENT)) {
                    userdomain.setPassword(passwordEncoder.encode(DefaultPassword));
                } else {
                    userdomain.setPassword(passwordEncoder.encode(LecturerPwd));
                }
                userdomain.setDateOfBirth(registerUser.getDateOfBirth());
                userdomain.setGender(registerUser.getGender());
                //Collection <com.janith.eea.Model.UserRole>
            }
            User save = userRepository.save(userdomain);
            emailService.sendEmail(registerUser); // send the email when saving in the database
            return save;

        }
    }

    @Override
    public boolean passwordencoder(String Password, String pass) {

        return passwordEncoder.matches(Password, pass);
    }


//getting all the users from databse
    @Override
    public List<UserDto> getAllUsers() {

        List<User> userDomain = userRepository.findAll();
        List<UserDto> userDtoList = new ArrayList<>();

        if (!userDomain.isEmpty()) {
            for (User user : userDomain) {
                if (user.getRole().getRoleName().equals(UserTypeUtil.LECTURER) || user.getRole().getRoleName().equals(UserTypeUtil.STUDENT))
                {
                    UserDto userDto = new UserDto();
                    userDto.setUserId(user.getUserId());
                    userDto.setUsername(user.getUsername());
                    userDto.setEmail(user.getEmail());
                    userDto.setFirstname(user.getFirstname());
                    userDto.setLastname(user.getLastname());
                    userDto.setGender(user.getGender());
                    userDto.setRole(user.getRole().getRoleName().toString());
                    userDto.setDateOfBirth(user.getDateOfBirth());
                    userDto.setMobile(user.getMobile());
                    userDto.setPassword(user.getPassword());
                    userDtoList.add(userDto);
                }
            }
        }
        return userDtoList;
    }

    @Override
    public List<UserDto> getAllStudets() {
        List<User> userDomain = userRepository.findAll();

        return  convertToDTO(userDomain,UserTypeUtil.STUDENT);
    }

    @Override
    public List<UserDto> getAllStudentToAPI() {
        List<User> userDomain = userRepository.findAll();
        List<UserDto> userDtoList = new ArrayList<>();

        if (!userDomain.isEmpty()) {
            for (User user : userDomain) {
                if (user.getRole().getRoleName().equals(UserTypeUtil.STUDENT))
                {
                    UserDto userDto = new UserDto();
                    userDto.setUserId(user.getUserId());
                    userDto.setUsername(user.getUsername());
                    userDto.setEmail(user.getEmail());
                    userDto.setFirstname(user.getFirstname());
                    userDto.setDateOfBirth(user.getDateOfBirth());
                    userDto.setMobile(user.getMobile());
                    if(user.getBatch() == null){
                        userDto.setBatchCode("No Batch Assigned");
                    }else

                    userDto.setBatchCode(user.getBatch().getBatchCode());
                    userDtoList.add(userDto);
                }
            }
        }
        return userDtoList;
    }

    @Override
    public List<UserDto> getAllLecturersToAPI() {
        List<User> userDomain = userRepository.findAll();
        List<UserDto> userDtoList = new ArrayList<>();

        if (!userDomain.isEmpty()) {
            for (User user : userDomain) {
                if (user.getRole().getRoleName().equals(UserTypeUtil.LECTURER))
                {
                    UserDto userDto = new UserDto();
                    userDto.setUserId(user.getUserId());
                    userDto.setUsername(user.getUsername());
                    userDto.setEmail(user.getEmail());
                    userDto.setFirstname(user.getFirstname());
                    userDto.setDateOfBirth(user.getDateOfBirth());
                    userDto.setMobile(user.getMobile());
                    userDtoList.add(userDto);
                }
            }
        }
        return userDtoList;    }

    @Override
    public List<UserDto> getAllLecturers() {
        List<User> userDomain = userRepository.findAll();

      return convertToDTO(userDomain, UserTypeUtil.LECTURER);
    }

    private List<UserDto> convertToDTO(List<User> userList , UserTypeUtil userRole){

        List<UserDto> userDtoList = new ArrayList<>();

        if (!userList.isEmpty()) {
            for (User user : userList) {
                if (user.getRole().getRoleName().equals(userRole)) {
                    UserDto userDto = new UserDto();

                    userDto.setUserId(user.getUserId());
                    userDto.setUsername(user.getUsername());
                    userDto.setEmail(user.getEmail());
                    userDto.setFirstname(user.getFirstname());
                    userDto.setLastname(user.getLastname());
                    userDto.setGender(user.getGender());
                    userDto.setRole(user.getRole().getRoleName().toString());
                    userDto.setDateOfBirth(user.getDateOfBirth());
                    userDto.setMobile(user.getMobile());
                    userDto.setPassword(user.getPassword());
                    userDto.setBatch(user.getBatch());
                    userDtoList.add(userDto);
                }
            }

        }
        return userDtoList;
    }
    @Override
    public User editUser(UserDto userDto) {
// get the details of the domain student.
        Optional<User> userdomain = userRepository.findById(userDto.getUserId());

        User user = userdomain.get();


        if (user != null) {

            user.setUsername(userDto.getUsername());
            user.setFirstname(userDto.getFirstname());
            user.setLastname(userDto.getLastname());
            user.setEmail(userDto.getEmail().toLowerCase(Locale.ROOT)); // validation
            user.setMobile(userDto.getMobile());

        }
//        save the updated info
        return userRepository.save(user);


    }

    @Override
    public User updateStudent(UserDto userDto) {
        Optional<User> userdomain = userRepository.findById(userDto.getUserId());

        User user = userdomain.get();


        if (user != null) {


            user.setEmail(userDto.getEmail().toLowerCase(Locale.ROOT)); // validation
            user.setMobile(userDto.getMobile());

        }

        User save = userRepository.save(user);
        emailService.emailUserUpdate(user);

        return save;

    }



    @Override
    public User updatePasswordStudent(UserDto userDto) {
        User userdomain = userRepository.findById(userDto.getUserId()).get();

        userdomain.setPassword(passwordEncoder.encode(userDto.getPassword()));
        User save = userRepository.save(userdomain);
        emailService.emaiPasswordReset(userdomain);

        return save;
    }

    @Override
    public UserDto getUserById(int id) {
        Optional<User> optionalUser = userRepository.findById(id);

        UserDto userdom = new UserDto();
        User userinfo = null;

        if (optionalUser.isPresent()) {
            userinfo = optionalUser.get();

            userdom.setUserId(userinfo.getUserId());
            userdom.setUsername(userinfo.getUsername());
            userdom.setEmail(userinfo.getEmail());
            userdom.setFirstname(userinfo.getFirstname());
            userdom.setLastname(userinfo.getLastname());
            userdom.setBatch(userinfo.getBatch());
            userdom.setGender(userinfo.getGender());
            userdom.setDateOfBirth(userinfo.getDateOfBirth());
            userdom.setRole(userinfo.getRole().getRoleName().toString());
            userdom.setMobile(userinfo.getMobile());
            userdom.setPassword(userinfo.getPassword());

        } else {
            throw new RuntimeException("No use Found" + id);
        }
        return userdom;

    }

    // Assiging a batch to a Student
    @Override
    public User assignBatch(UserDto userDto) {
        // get the details of the domain student.
        Optional<User> userdomain = userRepository.findById(userDto.getUserId());

        User user = userdomain.get();

        user.setBatch(userDto.getBatch());

//        save the batch selected
        return userRepository.save(user);
    }

    @Override
    public String deAssignBatch(int id) {
        try {
            User userdomain = userRepository.findById(id).get();
            userdomain.setBatch(null);
            userRepository.save(userdomain);
            return "unAssigned";
        } catch (Exception EX) {
            System.out.println(EX);
            return "error";
        }

    }

    @Override
    public String deleteUserByID(int ID) {
        try {
            this.userRepository.deleteById(ID);
            return "deleted";
        } catch (Exception EX) {
            System.out.println(EX);
            return "error";
        }


    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findUsersByUsername(s);

        if (user == null) {
            throw new UsernameNotFoundException(String.format("%s not Found", s));
        } else {
            ArrayList<SimpleGrantedAuthority> grantedAuthorities = new ArrayList<>();
            grantedAuthorities.add(new SimpleGrantedAuthority(user.getRole().getRoleName().toString()));
            Auth auth = new Auth(grantedAuthorities, user.getUsername(), user.getPassword(), true, true, true, true);
            return auth;
        }
    }

    @Override
    public List<UserDto> searchUser(String fname) {
        List<User> userList =  new ArrayList<>();
        userList.addAll(userRepository.StudentSearch(fname));

        List<UserDto> userDtoList = new ArrayList<>();

        for(User user:userList)
        {
            UserDto usernew =  new UserDto();
            usernew.setUserId(user.getUserId());
            usernew.setUsername(user.getUsername());
            usernew.setEmail(user.getEmail());
            usernew.setFirstname(user.getFirstname());
            usernew.setLastname(user.getLastname());
            usernew.setGender(user.getGender());
            usernew.setRole(user.getRole().getRoleName().toString());
            usernew.setDateOfBirth(user.getDateOfBirth());
            usernew.setMobile(user.getMobile());
            usernew.setBatch(user.getBatch());
            userDtoList.add(usernew);
        }
        return userDtoList;
    }

    @Override
    public List<UserDto> listOfUsersBatch(int batchID) {
        return null;
    }


}
