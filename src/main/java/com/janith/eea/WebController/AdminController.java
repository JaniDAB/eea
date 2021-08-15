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
import com.janith.eea.Validation.BatchValidator;
import com.janith.eea.Validation.ModuleValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
/**
 * All the  controllers   Admin needs
 * @author janith dabare
 */
@Controller
@PreAuthorize("hasAuthority('ADMIN')")
public class AdminController {


    @Autowired
    private final BatchServiceImpl batchService;


    @Autowired
    private final ModuleService moduleService;


    @Autowired
    private final UserServiceImpl service;


    @Autowired
    private  final BatchValidator batchValidator;


    @Autowired
    private final ModuleValidator moduleValidator;

    public AdminController(BatchServiceImpl batchService, ModuleService moduleService, UserServiceImpl userService, UserServiceImpl service, BatchValidator batchValidator, ModuleValidator moduleValidator) {
        this.batchService = batchService;
        this.moduleService = moduleService;
        this.service = service;
        this.batchValidator = batchValidator;
        this.moduleValidator = moduleValidator;
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
    @GetMapping("/admin/searchUser")
    public String search(HttpServletRequest req , Model a)
    {
        String name = req.getParameter("searchByName");
        List<UserDto> userDtoList = service.searchUser(name);

        a.addAttribute("users", userDtoList);
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
            UserDto userDto = new UserDto();
            UserDto userinfo = service.getUserById(id);
            model.addAttribute("userinfo", userinfo);
            model.addAttribute("user", userDto);
            return "updateUser";
        } catch (Exception ex) {
            System.out.println(ex);
            model.addAttribute("user", new UserDto());
            return "updateUser";
        }
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable(value = "id")int ID, Model m, RedirectAttributes rd)
    {

            String s = this.service.deleteUserByID(ID);
            if (s.equals("deleted")) {
                rd.addFlashAttribute("deleted", "Record Deleted Successfully");
            }else {
                rd.addFlashAttribute("error", "Record Deletion UnSuccessful");
            }

        return "redirect:/admin/users/allStudents";

    }
    @GetMapping("/admin/deAssignBatch/{id}")
    public String deAssignBatch(@PathVariable(value = "id")int ID, Model m, RedirectAttributes rd)
    {

        String s = this.service.deAssignBatch(ID);
        if (s.equals("unAssigned")) {
            rd.addFlashAttribute("deAssigned", " De-Assigned");
        }else {
            rd.addFlashAttribute("errord", " De-Assign UnSuccessful");
        }

        return "redirect:/admin/users/allStudents";

    }


    @GetMapping("/deleteUserLec/{id}")
    public String deleteUserLec(@PathVariable(value = "id")int ID, Model m, RedirectAttributes rd)
    {

        String s = this.service.deleteUserByID(ID);
        if (s.equals("deleted")) {
            rd.addFlashAttribute("deleted", "Record Deleted Successfully");
        }else {
            rd.addFlashAttribute("error", "UnSuccessful, Please De-Assign Lecturers from Module");
        }

        return "redirect:/admin/users/allLectruer";

    }






    @PostMapping("/modifyUser")
    public String modifyUser(@ModelAttribute("user") UserDto userDto) {
        final User save = service.editUser(userDto);
        return "/adminHome";
    }

//    @GetMapping("/student/getUpdateForm/{id}")
//    public  String  getUpdateFormStudent(@PathVariable(value = "id") int id , Model u)
//    {
//        try {
//            UserDto userDto = new UserDto();
//            UserDto userinfo = service.getUserById(id);
//            u.addAttribute("userinfo", userinfo);
//            u.addAttribute("student", userDto);
//            return "updateStudent";
//        } catch (Exception ex) {
//            System.out.println(ex);
//            u.addAttribute("student", new UserDto());
//            return "updateStudent";
//        }
//    }
//
//    @PostMapping("/student/Updateform")
//    public String updateStudent(@ModelAttribute("student") UserDto userDto , Model m)
//    {
//        try {
//            final User update = service.updateStudent(userDto); // change service method
//            m.addAttribute("Updated", "Updated Successfully");
//            return "updateStudent";
//        }catch (Exception e){
//            m.addAttribute("error", "  UnSuccessful");
//            return "updateStudent";
//        }
//    }

//    @GetMapping("/lecturer/getUpdateForm/{id}")
//    public  String  getUpdateFormLecturer(@PathVariable(value = "id") int id , Model u)
//    {
//        try {
//            UserDto userDto = new UserDto();
//            UserDto userinfo = service.getUserById(id);
//            u.addAttribute("userinfo", userinfo);
//            u.addAttribute("lecturer", userDto);
//            return "lecturerUpdate";
//        } catch (Exception ex) {
//            System.out.println(ex);
//            u.addAttribute("lecturer", new UserDto());
//            return "lecturerUpdate";
//        }
//    }
//    @PostMapping("/lecturer/Updateform")
//    public String updateLecturer(@ModelAttribute("lecturer") UserDto userDto , Model m)
//    {
//        try {
//            final User update = service.updateStudent(userDto); // change service method
//            m.addAttribute("Updated", "Updated Successfully");
//            return "lecturerUpdate";
//        }catch (Exception e){
//            m.addAttribute("error", "  UnSuccessful");
//            return "lecturerUpdate";
//        }
//    }


    /// Batch functions ----------------------------------------------------------------
    @GetMapping("/addBatch")
    public String AddBatch(Model a) {
        a.addAttribute("batch", new BatchDto());
        a.addAttribute("success", "Batch Added Successfully");
        a.addAttribute("allmodules", moduleService.getAllModules());
        return "/addBatch";
    }

    @PostMapping("/admin/addBatch")
    public String AddAABath(@ModelAttribute("batch") BatchDto batchDto , Model a, BindingResult br) {
        batchValidator.validate(batchDto , br);

        if(br.hasErrors()){
            return "addBatch";
        }
        try {
            final Batch save = batchService.save(batchDto);
            a.addAttribute("successful", "Batch Added Successfully");
        }
        catch (Exception e){
            a.addAttribute("fail", "Error Occurred Couldn't Add the Batch ");
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
       final Batch batch = batchService.editBatchInfo(batchDto);
        return "adminHome";
    }

    // Module Functionss ------------------------------------------------------------------------
    @GetMapping("/addModule")
    public String AddmODULE(Model a) {
        a.addAttribute("module", new ModuleDto());
        return "/addModule";
    }

    @PostMapping("/admin/addModule")
    public String addAModule(@ModelAttribute("module") ModuleDto moduleDto ,BindingResult br,Model a) throws Exception {

        moduleValidator.validate(moduleDto , br);

        if(br.hasErrors())
        {
            return "/addModule";
        }
        try {
            final Module save = moduleService.save(moduleDto);
            a.addAttribute("successful", "Module Added Successfully");
        }
        catch (Exception ex)
        {
            a.addAttribute("fail", ex.getMessage());
        }

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


