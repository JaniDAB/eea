package com.janith.eea;

import com.janith.eea.Dto.ModuleDto;
import com.janith.eea.Model.Module;

import com.janith.eea.Repository.ModuleRepository;
import com.janith.eea.Service.ModuleServiceImpl;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class addModuleTest  extends Module {

    @Autowired
   private ModuleServiceImpl moduleService;

@MockBean
private ModuleRepository moduleRepository;

    @Test
    @DisplayName("Test SHould pass when module is added successfully")
    public void addModule() throws Exception{
//        ModuleDto moduleDto =  new ModuleDto("English");
//
//       Module module =  moduleService.save(moduleDto);

        when(moduleRepository.findAll()).thenReturn
                (Stream.of(
                        new Module("COSE1223","English" ),
                        new Module( "COSE2221","Network"))
                        .collect(Collectors.toList()));
assertEquals(2, moduleService.getAllModules().size());
    }


 

}
