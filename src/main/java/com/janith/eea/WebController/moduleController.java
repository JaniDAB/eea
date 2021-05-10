package com.janith.eea.WebController;

import com.janith.eea.Dto.ModuleDto;
import com.janith.eea.Dto.UserDto;
import com.janith.eea.Model.Module;
import com.janith.eea.Service.ModuleServiceImpl;
import com.janith.eea.Service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class moduleController {


    @Autowired
    private final ModuleServiceImpl moduleService;

    @Autowired
    private final UserServiceImpl userService;

    public moduleController(ModuleServiceImpl moduleService, UserServiceImpl userService) {
        this.moduleService = moduleService;
        this.userService = userService;
    }

    @GetMapping("/updateModuleForm/{id}")
    public String updateModuleDirectForm(@PathVariable(value = "id") int id, Model model) {
        try {
            int moduleID = id;

            ModuleDto moduleDto = new ModuleDto();

            ModuleDto modelInfo = moduleService.getModuleById(moduleID);

            model.addAttribute("moduleInfo", modelInfo);

            model.addAttribute("moduleupdate", moduleDto);

            return "updateModule";
        } catch (Exception ex) {
            System.out.println("Module not found"+ex);
            model.addAttribute("module" , new ModuleDto());
            return "updateModule";
        }

    }

    @PostMapping("/modifyModule")
    public String modifyBatch(@ModelAttribute("moduleupdate") ModuleDto moduleDto) {
       final Module update = moduleService.editModule(moduleDto);
        return "redirect:/admin/listModules";
    }

    @GetMapping("/assignModuleForm/{id}")
    public  String assignModuleForm(@PathVariable(name = "id") int id, Model u){
        try {
            int moduleID = id;

            ModuleDto moduleDto = new ModuleDto();

            ModuleDto modelInfo = moduleService.getModuleById(moduleID);


            List<UserDto> lecturerList;
            lecturerList = userService.getAllLecturers();

            u.addAttribute("moduleInfos", modelInfo);

            u.addAttribute("assignModule", moduleDto);

            u.addAttribute("lecturerList" , lecturerList);

            return "assignLecturerToModule";
        } catch (Exception ex) {
            System.out.println("Module not found"+ex);
            u.addAttribute("assignModule" , new ModuleDto());
            return "assignLecturerToModule";
        }
    }

    @PostMapping("/assignLecturer")
    public String assignModule(@ModelAttribute("assignModule") ModuleDto moduleDto){

        final  Module assign = moduleService.assignLecturer(moduleDto);

        return "redirect:/admin/listModules";

    }



}
