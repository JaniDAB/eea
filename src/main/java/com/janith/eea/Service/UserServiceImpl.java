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

    public User getUser(String username) {
        return userRepository.findUsersByUsername(username);
    }

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }



    @Override
    public User save(UserDto registerUser) {
        User userdomain = new User();
        UserRole userRole = new UserRole();

        String DefaultPassword = "user123";
        if (userRepository.findUsersByUsername(registerUser.getUsername()) != null) {
            return null;
        } else {
            if (registerUser != null) {
                userdomain.setUsername(registerUser.getUsername());
                userdomain.setFirstname(registerUser.getFirstname());
                userdomain.setLastname(registerUser.getLastname());
                userdomain.setEmail(registerUser.getEmail().toLowerCase(Locale.ROOT)); // validation
                userdomain.setMobile(registerUser.getMobile());
                userdomain.setPassword(passwordEncoder.encode(DefaultPassword));
                userRole.setRoleName(UserTypeUtil.fromText(registerUser.getRole()));
                userdomain.setRole(userRole);
                userdomain.setDateOfBirth(registerUser.getDateOfBirth());
                userdomain.setGender(registerUser.getGender());
                //Collection <com.janith.eea.Model.UserRole>
            }
            return userRepository.save(userdomain);

        }
    }

    @Override
    public boolean passwordencoder(String Password, String pass) {

        return passwordEncoder.matches(Password, pass);
    }

    @Override
    public List<UserDto> getAllUsers() {

        List<User> userDomain = userRepository.findAll();
        List<UserDto> userDtoList = new ArrayList<>();

        if (!userDomain.isEmpty()) {
            for (User user : userDomain) {
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
        return userDtoList;
    }

    @Override
    public List<UserDto> getAllStudets() {
        List<User> userDomain = userRepository.findAll();
        List<UserDto> userDtoList = new ArrayList<>();

        if (!userDomain.isEmpty()) {
            for (User user : userDomain) {
                if (user.getRole().getRoleName().equals(UserTypeUtil.STUDENT)) {
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
    public List<UserDto> getAllLecturers() {
        List<User> userDomain = userRepository.findAll();
        List<UserDto> userDtoList = new ArrayList<>();

        if (!userDomain.isEmpty()) {
            for (User user : userDomain) {
                if (user.getRole().getRoleName().equals(UserTypeUtil.LECTURER)) {
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
    public User editUser(UserDto userDto) {

        Optional<User> userdomain = userRepository.findById(userDto.getUserId());

        User user = userdomain.get();


            if (user != null) {

                user.setUsername(userDto.getUsername());
                user.setFirstname(userDto.getFirstname());
                user.setLastname(userDto.getLastname());
                user.setEmail(userDto.getEmail().toLowerCase(Locale.ROOT)); // validation
                user.setMobile(userDto.getMobile());
                user.setPassword(passwordEncoder.encode(userDto.getPassword()));
//                user.setBatch(userDto.getBatch());


            }
            return userRepository.save(user);


    }

    @Override
    public UserDto getUserById(int id) {
        Optional<User> optionalUser = userRepository.findById(id);

        UserDto userdom = new UserDto();
        User userinfo = null;

        if(optionalUser.isPresent()){
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

        }
        else {
            throw new RuntimeException("No use Found" +id);
        }
        return userdom;

    }

    @Override
    public User assignBatch(UserDto userDto) {
        Optional<User> userdomain = userRepository.findById(userDto.getUserId());

        User user = userdomain.get();

        if (user != null) {

            user.setBatch(userDto.getBatch());

        }
        return userRepository.save(user);
    }

    @Override
    public void deleteUserByID(int ID) {
        this.userRepository.deleteById(ID);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findUsersByUsername(s);
        System.out.println(user.getPassword());

        if (user == null) {
            throw new UsernameNotFoundException(String.format("%s not Found", s));
        } else {
            ArrayList<SimpleGrantedAuthority> grantedAuthorities = new ArrayList<>();
            grantedAuthorities.add(new SimpleGrantedAuthority(user.getRole().getRoleName().toString()));
            Auth auth = new Auth(grantedAuthorities, user.getUsername(), user.getPassword(), true, true, true, true);
            return auth;
        }
    }

}
