package com.janith.eea.WebController;

import com.janith.eea.Dto.ModuleDto;
import com.janith.eea.Dto.UserDto;
import com.janith.eea.Model.Module;
import com.janith.eea.Service.ModuleServiceImpl;
import com.janith.eea.Service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * All the  controllers need in  Modules
 *
 * @author janith dabare
 */
@Controller
@PreAuthorize("hasAuthority('ADMIN')")
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
            System.out.println("Module not found" + ex);
            model.addAttribute("module", new ModuleDto());
            return "updateModule";
        }

    }

    @PostMapping("/modifyModule")
    public String modifyBatch(@ModelAttribute("moduleupdate") ModuleDto moduleDto) {
        final Module update = moduleService.editModule(moduleDto);
        return "redirect:/admin/listModules";
    }

    @GetMapping("/assignModuleForm/{id}")
    public String assignModuleForm(@PathVariable(name = "id") int id, Model u) {
        try {
            int moduleID = id;

            ModuleDto moduleDto = new ModuleDto();

            ModuleDto modelInfo = moduleService.getModuleById(moduleID);


            List<UserDto> lecturerList;
            lecturerList = userService.getAllLecturers();

            u.addAttribute("moduleInfos", modelInfo);

            u.addAttribute("assignModule", moduleDto);

            u.addAttribute("lecturerList", lecturerList);
            u.addAttribute("successful","");
            u.addAttribute("fail","");
            return "assignLecturerToModule";
        } catch (Exception ex) {
            System.out.println("Module not found" + ex);
            u.addAttribute("assignModule", new ModuleDto());
            return "assignLecturerToModule";
        }
    }

    @PostMapping("/assignLecturer")
    public String assignModule(@ModelAttribute("assignModule") ModuleDto moduleDto, Model a) {
        try {
            final Module assign = moduleService.assignLecturer(moduleDto);
            List<ModuleDto> moduleDtoList;
            moduleDtoList = moduleService.getAllModules();
            a.addAttribute("modules", moduleDtoList);
            a.addAttribute("successful", "Lecturer: "+assign.getLecUser().getFirstname()+" is Assigned  to "+assign.getModuleCode()+" Successfully. ");

        } catch (Exception e) {
            a.addAttribute("fail", "Error Occurred Please try again later.");
        }
        return "viewModules";

    }

    @GetMapping("/deAssign/{id}")
    public String deAssignLecturerModule(@PathVariable(value = "id") int ID, Model m, RedirectAttributes rd) throws Exception {
        Module mm = this.moduleService.deAssignLecturer(ID);
        if (mm != null) {
            rd.addFlashAttribute("deleted", "Lecturer  is De-Assigned  By "+mm.getModuleCode()+" Successfully. ");
        } else {
            rd.addFlashAttribute("error", "De-Assign UnSuccessful");
        }

        return "redirect:/admin/listModules";

    }


//    @GetMapping("/getLecturerModuleList/{userID}")
//    public String getModuleListLecturer(@PathVariable( name = "userID") int UserID, Model m)
//    {
//        try {
//            List<ModuleDto> modelInfoList = moduleService.viewLecsModules(UserID);
//
//            m.addAttribute("moduleInfoList", modelInfoList);
//
//            return "LecturerModules";
//        } catch (Exception ex) {
//            System.out.println("Module not found"+ex);
//
//            return "LecturerModules";
//        }
//
//    }


}
