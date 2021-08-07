package com.janith.eea.Controller;

import com.janith.eea.Dto.BatchDto;
import com.janith.eea.Dto.ModuleDto;
import com.janith.eea.Service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/api/mobile/")
public class ModuleCon {

    @Autowired
    private ModuleService moduleService;


    @PostMapping("/add_Module/")
    public HashMap<String, String> addaModule(@RequestBody ModuleDto moduleDto) throws Exception {
        HashMap<String, String> message = new HashMap<>();

        try {
            moduleService.save(moduleDto);

            message.put("result", "Added");
        } catch (Exception ex) {
            message.put("result", ex.getMessage());
            return message;
        }
        return message;
    }

}
