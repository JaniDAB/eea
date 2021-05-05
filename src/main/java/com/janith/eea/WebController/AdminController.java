package com.janith.eea.WebController;

import com.janith.eea.Dto.BatchDto;
import com.janith.eea.Dto.ModuleDto;
import com.janith.eea.Dto.UserDto;
import com.janith.eea.Model.Batch;
import com.janith.eea.Model.Module;
import com.janith.eea.Service.BatchServiceImpl;
import com.janith.eea.Service.ModuleService;
import com.janith.eea.Service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AdminController {


    @Autowired
    private  final BatchServiceImpl batchService;


    @Autowired
    private  final ModuleService moduleService;


    @Autowired
    UserServiceImpl service;

    public AdminController(BatchServiceImpl batchService, ModuleService moduleService) {
        this.batchService = batchService;
        this.moduleService = moduleService;
    }

    @GetMapping("/admin/users")
    public String viewUsers(Model a) {
        List<UserDto>  userList;
        userList = service.getAllUsers();

        a.addAttribute("users", userList);
        return "/viewUsers";
    }
    @GetMapping("/admin/users/allStudents")
    public String viewAllStudents(Model a) {
        List<UserDto>  userList;
        userList = service.getAllStudets();

        a.addAttribute("users", userList);
        return "/viewAllStudents";
    }
    @GetMapping("/admin/users/allLectruer")
    public String viewAllLectueres(Model a) {
        List<UserDto>  userList;
        userList = service.getAllLecturers();

        a.addAttribute("users", userList);
        return "/viewAllLectuers";
    }

    @GetMapping("/addBatch")
    public String AddBatch(Model a){
        a.addAttribute("batch" , new BatchDto());
        return "/addBatch";
    }

    @PostMapping("/admin/addBatch")
    public  String AddAABath(@ModelAttribute("batch")BatchDto batchDto){
         final Batch  save = batchService.save(batchDto);
         return "/addBatch";
    }
    @GetMapping("/addModule")
    public String AddmODULE(Model a){
        a.addAttribute("module" , new ModuleDto());
        return "/addModule";
    }
    @PostMapping("/admin/addModule")
    public  String addAModule(@ModelAttribute("module") ModuleDto moduleDto){
        final Module save = moduleService.save(moduleDto);
        return "/addModule";
    }






}
