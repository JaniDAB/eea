package com.janith.eea.Service;

import com.janith.eea.Dto.UserDto;
import com.janith.eea.Model.User;
import com.janith.eea.Model.UserRole;
import com.janith.eea.Repository.UserRepository;
import com.janith.eea.Util.UserTypeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder  passwordEncoder;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User save(UserDto registerUser) {
       User userdomain = new User();
UserRole  userRole = new UserRole();

       if(registerUser != null){
           userdomain.setUsername(registerUser.getUsername());
           userdomain.setFirstname(registerUser.getFirstname());
           userdomain.setLastname(registerUser.getLastname());
           userdomain.setEmail(registerUser.getEmail().toLowerCase(Locale.ROOT)); // validation
           userdomain.setMobile(registerUser.getMobile());
           userdomain.setPassword(passwordEncoder.encode(registerUser.getPassword()));
           userRole.setRoleName(UserTypeUtil.fromText(registerUser.getRole()));
           userdomain.setRole(userRole);
           userdomain.setDateOfBirth(registerUser.getDateOfBirth());
           //Collection <com.janith.eea.Model.UserRole>
       }
       return userRepository.save(userdomain);

    }

    @Override
    public boolean passwordencoder(String Password, String pass) {

return  passwordEncoder.matches(Password,pass);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }

}
