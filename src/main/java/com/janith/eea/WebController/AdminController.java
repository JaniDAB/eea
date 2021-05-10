package com.janith.eea.WebController;

import com.janith.eea.Dto.BatchDto;
import com.janith.eea.Dto.ModuleDto;
import com.janith.eea.Dto.UserDto;
import com.janith.eea.Model.Batch;
import com.janith.eea.Model.Module;
import com.janith.eea.Model.User;
import com.janith.eea.Service.BatchServiceImpl;
import com.janith.eea.Service.ModuleService;
import com.janith.eea.Service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AdminController {


    @Autowired
    private final BatchServiceImpl batchService;


    @Autowired
    private final ModuleService moduleService;


    @Autowired
    private final UserServiceImpl service;

    public AdminController(BatchServiceImpl batchService, ModuleService moduleService, UserServiceImpl userService, UserServiceImpl service) {
        this.batchService = batchService;
        this.moduleService = moduleService;
        this.service = service;
    }

    // Users Functions  ----------------------------------------------------------------------------------------
    @GetMapping("/admin/users")
    public String viewUsers(Model a) {
        List<UserDto> userList;
        userList = service.getAllUsers();

        a.addAttribute("users", userList);
        return "/viewUsers";
    }

    @GetMapping("/admin/users/allStudents")
    public String viewAllStudents(Model a) {
        List<UserDto> userList;
        userList = service.getAllStudets();

        a.addAttribute("users", userList);
        return "/viewAllStudents";
    }

    @GetMapping("/admin/users/allLectruer")
    public String viewAllLectueres(Model a) {
        List<UserDto> userList;
        userList = service.getAllLecturers();

        a.addAttribute("users", userList);
        return "/viewAllLectuers";
    }

    @GetMapping("/showFormUpdate/{id}")
    public String updateFormDirect(@PathVariable(value = "id") int id, Model model) {
        try {
            int num = id;
            UserDto userDto = new UserDto();
            UserDto userinfo = service.getUserById(num);
            List<BatchDto> batchDtoList;
            batchDtoList = batchService.getAllBatches();
            model.addAttribute("userinfo", userinfo);
            model.addAttribute("user", userDto);
            model.addAttribute("batchlist",batchDtoList);
            return "updateUser";
        } catch (Exception ex) {
            System.out.println(ex);
            model.addAttribute("user", new UserDto());
            return "updateUser";
        }
    }





    @PostMapping("/modifyUser")
    public String modifyUser(@ModelAttribute("user") UserDto userDto) {
        final User save = service.editUser(userDto);
        return "/adminHome";
    }




    /// Batch functions ----------------------------------------------------------------
    @GetMapping("/addBatch")
    public String AddBatch(Model a) {
        a.addAttribute("batch", new BatchDto());
        a.addAttribute("success", "Batch Added Successfully");
        return "/addBatch";
    }

    @PostMapping("/admin/addBatch")
    public String AddAABath(@ModelAttribute("batch") BatchDto batchDto , Model a) {
        try {
            final Batch save = batchService.save(batchDto);
            a.addAttribute("successful", "Batch Added Successfully");
        }
        catch (Exception e){
            a.addAttribute("fail", " Failed");
        }

        return "/addBatch";
    }

    @GetMapping("/admin/listBatches")
    public String viewBatches(Model b) {
        List<BatchDto> batchDtoList;
        batchDtoList = batchService.getAllBatches();
        b.addAttribute("batches", batchDtoList);

        return "viewBatches";

    }

    @GetMapping("/directUpdateMBatchForm/{id}")
    public String updateBatchForm(@PathVariable(value = "id") int id, Model batchModel) {
        try {
            int batchId = id;
            BatchDto batchDto = new BatchDto();
            BatchDto batchInfo = batchService.getBatchById(batchId);

            batchModel.addAttribute("batchInfo", batchInfo);
            batchModel.addAttribute("batchupdate", batchDto);

            return "updateBatch";
        } catch (Exception ex) {
            System.out.println( "bATCH Update"  +ex);
            batchModel.addAttribute("batchupdate", new BatchDto());

            return "updateBatch";

        }
    }

    @PostMapping("/modifyBatch")
    public String modifyBatch(@ModelAttribute("batchupdate") BatchDto batchDto) {
       final Batch batch = batchService.editBatch(batchDto);
        return "adminHome";
    }

    // Module Functionss ------------------------------------------------------------------------
    @GetMapping("/addModule")
    public String AddmODULE(Model a) {
        a.addAttribute("module", new ModuleDto());
        return "/addModule";
    }

    @PostMapping("/admin/addModule")
    public String addAModule(@ModelAttribute("module") ModuleDto moduleDto) {
        final Module save = moduleService.save(moduleDto);
        return "/addModule";
    }

    @GetMapping("/admin/listModules")
    public String viewModules(Model m) {
        List<ModuleDto> moduleDtoList;

        moduleDtoList = moduleService.getAllModules();
        m.addAttribute("modules", moduleDtoList);

        return "viewModules";

    }

//    @GetMapping("/directUpdateModule/{moduleID}")
//            public String updateModuleForm(@PathVariable(value = "moduleID") int moduleID,Model m)
//    {
//        try{
//
//        }
//        catch (Exception ex){
//
//            System.out.println("module update "+ex);
//
//        }

    }


