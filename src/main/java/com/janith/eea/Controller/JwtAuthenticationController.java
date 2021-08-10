package com.janith.eea.Controller;

import com.janith.eea.Config.JwtTokenUtil;
import com.janith.eea.Dto.JwtResponse;
import com.janith.eea.Dto.UserDto;
import com.janith.eea.Model.User;
import com.janith.eea.Repository.UserRepository;
import com.janith.eea.Service.UserService;
import com.janith.eea.Util.UserTypeUtil;
import org.hibernate.usertype.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/mobile/")
public class JwtAuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserService jwtUserDetailsService;

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody UserDto userDto) throws Exception {

//        authenticate(userDto.getUsername(), userDto.getPassword());

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userDto.getUsername(), userDto.getPassword()));
        }
        catch (BadCredentialsException e) {

            JwtResponse jwtResponse = new JwtResponse(null,null, "INVALID CREDENTIALS", null, null);

            return  ResponseEntity.ok(jwtResponse);
        }
        final UserDetails userDetails = jwtUserDetailsService.loadUserByUsername(userDto.getUsername());

        String jwttoken = jwtTokenUtil.generateToken(userDetails);

        User usersD = userRepository.findByUsername(userDto.getUsername());

        JwtResponse jwtResponse = new JwtResponse(jwttoken, usersD.getUserId(), "Success", usersD.getRole().getRoleName().toString(), userDto.getUsername());

        return ResponseEntity.ok(jwtResponse);
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        }
        catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}

