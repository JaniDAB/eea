package com.janith.eea.WebController;

import com.janith.eea.Dto.BatchDto;
import com.janith.eea.Dto.ModuleDto;
import com.janith.eea.Dto.UserDto;
import com.janith.eea.Model.Batch;
import com.janith.eea.Model.User;
import com.janith.eea.Service.BatchService;
import com.janith.eea.Service.ModuleServiceImpl;
import com.janith.eea.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
/**
 * All the  controllers need in  Batch operations
 * @author janith dabare
 */
@Controller
public class BatchController {

    @Autowired
   private final  UserService service;

    @Autowired
    private final BatchService batchService;
    @Autowired
    private final ModuleServiceImpl moduleService;

    public BatchController(UserService service, BatchService batchService, ModuleServiceImpl moduleService) {
        this.service = service;
        this.batchService = batchService;
        this.moduleService = moduleService;
    }


    @GetMapping("/assignBatch/{userID}")
    public String assignBatchform(@PathVariable(value = "userID") int id, Model m) {
        try {
            int userID = id;
            UserDto userDto = new UserDto();
            UserDto userinfo = service.getUserById(userID);
            List<BatchDto> batchDtoList;
            batchDtoList = batchService.getAllBatches();
            m.addAttribute("userinfos", userinfo);
            m.addAttribute("user", userDto);
            m.addAttribute("batchlist", batchDtoList);

            m.addAttribute("successful","");
            m.addAttribute("fail","");

            return "assignBatchToUser";
        } catch (Exception ex) {

            System.out.println(ex);
            m.addAttribute("user", new UserDto());
            return "assignBatchToUser";
        }
    }

    @PostMapping("/assignStudentBatch")
    public String modifyUser(@ModelAttribute("user") UserDto userDto, Model a) {
        try {
            final User save = service.assignBatch(userDto);
            List<UserDto> userList;
            userList = service.getAllStudets();

            a.addAttribute("users", userList);
            a.addAttribute("successful", "Student: "+save.getFirstname()+" "+ save.getLastname()+ " Assigned Successfully to Batch  "+save.getBatch().getBatchCode());

        }catch (Exception ex){

            List<UserDto> userList;
            userList = service.getAllStudets();

            a.addAttribute("users", userList);
            a.addAttribute("fail", "Error Occured");

        }
        return "/viewAllStudents";
    }

    @GetMapping("/assignModule/{batchId}")
    public  String getAssignModuleToBatch(@PathVariable(value = "batchId") int id,Model b)
    {
        try{
            int batchId = id;
            BatchDto batchDto = new BatchDto();
            BatchDto batchInfo =batchService.getBatchById(batchId);
            List<ModuleDto> moduleDtoList;
            moduleDtoList = moduleService.getAllModules();
            List<ModuleDto>  moduleDtoListv = batchService.getModuleList(id);
            b.addAttribute("moduleList",moduleDtoList);
            b.addAttribute("moduleListInfo",moduleDtoListv);
            b.addAttribute("assignModule", batchDto);
            b.addAttribute("batchinfo", batchInfo);

            b.addAttribute("successful","");
            b.addAttribute("fail","");


            return "assignModulesToBatch";


        }catch (Exception e){
            System.out.println(e);
            return "assignModulesToBatch";
        }
    }

    @PostMapping("/assignModulesToBatch")
    public String assignModulesToBatch(@ModelAttribute("assignModule")BatchDto batchDto , Model a){
     try {
       Batch d= (Batch) batchService.
                 editBatch(batchDto);
         List<BatchDto> batchDtoList;
         batchDtoList = batchService.getAllBatches();
         a.addAttribute("batches", batchDtoList);
         if(d.getModuleList().size()==0){
             a.addAttribute("successful", "All the Modules Removed from Batch : "+d.getBatchCode());

         }else
         a.addAttribute("successful", "Modules Assigned Successfully to "+d.getBatchCode());
     }catch (Exception e){
         List<BatchDto> batchDtoList;
         batchDtoList = batchService.getAllBatches();
         a.addAttribute("batches", batchDtoList);
         a.addAttribute("fail", e.getMessage());

     }
        return "viewBatches";

    }

    @GetMapping("/modulelist/{id}")
    public  String showModuleList(@PathVariable(value = "id")int id, Model ba)
    {
        try{
            BatchDto batchInfo =batchService.getBatchById(id);
            List<ModuleDto>  moduleDtoList = batchService.getModuleList(id);

            ba.addAttribute("moduleList" , moduleDtoList);
            ba.addAttribute("batchinfo", batchInfo);
            return "ViewBatchModules";
        }catch (Exception e){
            System.out.println(e);
            return "ViewBatchModules";
        }


    }

    @GetMapping("/deleteBatch/{id}")
    public String deleteBatch(@PathVariable(value = "id")int batchID, Model mod, RedirectAttributes rd)
    {
        try {
            String s = batchService.deleteBatch(batchID);
            if (s.equals("deleted")) {
                rd.addFlashAttribute("deleted", "Batch  Deleted Successfully");

            } else {
                mod.addAttribute("error", "batch  delete error ");

            }
        }catch(Exception ex){
            rd.addFlashAttribute("error", ex.getMessage());

        }
        return "redirect:/admin/listBatches";
    }



}

