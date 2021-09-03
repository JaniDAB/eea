package com.janith.eea;

import com.janith.eea.Dto.BatchDto;
import com.janith.eea.Dto.ModuleDto;
import com.janith.eea.Model.Batch;
import com.janith.eea.Model.Module;
import com.janith.eea.Service.ModuleServiceImpl;
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
public class moduleTest {

    @Autowired
    private ModuleServiceImpl moduleService;

    @Autowired
    private CreatedDTO createdDTO;

    @BeforeAll
    public void init() throws Exception {
        Module m =  createdDTO.createModule();

    }

    @Test
    public void testAddModule() throws Exception {


        ModuleDto moduel = new ModuleDto();
        moduel.setModuleCode("cod");
        moduel.setModuleName("m11");

        Module mod = moduleService.save(moduel);

        assertNotNull(mod);

    }

    @Test
    public void testGetAllModules() throws Exception {


        List<ModuleDto> results = moduleService.getAllModules();

        System.out.println(results.size());

        boolean isTrue = results.size() > 0;

        assertTrue(isTrue);

        System.out.println("[TEST] Get all Batches [PASSED]");
    }
}
