package com.janith.eea;

import com.janith.eea.Dto.UserDto;
import com.janith.eea.Model.Batch;
import com.janith.eea.Model.User;
import com.janith.eea.Model.UserRole;
import com.janith.eea.Repository.UserRepository;
import com.janith.eea.Service.UserServiceImpl;

import com.janith.eea.Util.UserTypeUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.Mockito.when;
import static org.junit.Assert.*;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import javax.validation.constraints.Email;


@RunWith(SpringRunner.class)
@SpringBootTest
public class addUserTest extends User {


    @Autowired
    private WebApplicationContext webApplicationContext;


    @Autowired
    UserServiceImpl userService;

    @MockBean
    private UserRepository userRepository;

    private MockMvc mockMvc;

@Before
    private void  setup(){
mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }


//    @Test
//    void save() throws Exception {
//
//
//    }
}
