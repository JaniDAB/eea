package com.janith.eea.Controller;

import com.janith.eea.Dto.BatchDto;
import com.janith.eea.Dto.ClassRoomDto;
import com.janith.eea.Dto.ModuleDto;
import com.janith.eea.Model.User;
import com.janith.eea.Service.ModuleService;
import com.janith.eea.Service.UserService;
import com.janith.eea.Service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/mobile/")
public class ModuleCon {

    @Autowired
    private ModuleService moduleService;

    @Autowired
    private UserServiceImpl userService;


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

    @GetMapping("/view_module/")
    public ResponseEntity<List<ModuleDto>> viewModule(){

        List<ModuleDto> allModulestoAPI = moduleService.getAllModulestoAPI();

        return new ResponseEntity<>(allModulestoAPI, HttpStatus.OK);
    }

    @GetMapping("/get_batchList_Modules/{moduleId}")
    public List<BatchDto> getBatchListOfModuleId(@PathVariable("moduleId") int id){

        return  moduleService.getBatchListM(id);
    }

    @GetMapping("/view_lec_modules/")
    public List<ModuleDto> viewLecModules(Authentication auth){
        User user = userService.getUser(auth.getName());
        return  moduleService.viewLecsModulesAPI(user.getUserId());
    }

}
