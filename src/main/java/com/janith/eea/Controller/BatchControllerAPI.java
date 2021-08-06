package com.janith.eea.Controller;

import com.janith.eea.Dto.BatchDto;
import com.janith.eea.Dto.ClassRoomDto;
import com.janith.eea.Service.BatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/api/mobile/")
public class BatchControllerAPI {

    @Autowired
    private BatchService batchService;

    @PostMapping("/add_batch/")
    public HashMap<String, String> addABatch(@RequestBody BatchDto batchDto) throws Exception {
        HashMap<String, String> message = new HashMap<>();

        try {
            batchService.save(batchDto);

            message.put("result", "Added");
        } catch (Exception ex) {
            message.put("result", ex.getMessage());
            return message;
        }
        return message;
    }
}
