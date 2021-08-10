package com.janith.eea.Controller;

import com.janith.eea.Dto.BatchDto;
import com.janith.eea.Dto.ClassRoomDto;
import com.janith.eea.Dto.ModuleDto;
import com.janith.eea.Service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

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

    @GetMapping("/view_modules/")
    public List<ModuleDto> viewModules(){

        return  moduleService.getAllModulestoAPI();
    }

}
