package com.janith.eea.Dto;


import com.janith.eea.Model.Batch;
import com.janith.eea.Model.User;

import java.util.List;

public class ModuleDto {
    private Integer module_id;


    private  String moduleName;
    private  String moduleCode;

    private String firstName;

// to web

    private User lecUser;
// to API
    private UserDto lecUserDTO;

// to web
    private List<Batch> batchList;
// to API
    private List<BatchDto> batchListDto;

    public ModuleDto(Integer module_id, String moduleName, User lecUser, List<Batch> batchList) {
        this.module_id = module_id;
        this.moduleName = moduleName;
        this.lecUser = lecUser;
        this.batchList = batchList;
    }

    public ModuleDto() {
    }

    public UserDto getLecUserDTO() {
        return lecUserDTO;
    }

    public void setLecUserDTO(UserDto lecUserDTO) {
        this.lecUserDTO = lecUserDTO;
    }

    public List<BatchDto> getBatchListDto() {
        return batchListDto;
    }

    public void setBatchListDto(List<BatchDto> batchListDto) {
        this.batchListDto = batchListDto;
    }

    public ModuleDto(String moduleName) {
        this.moduleName = moduleName;
    }

    public Integer getModule_id() {
        return module_id;
    }

    public void setModule_id(Integer module_id) {
        this.module_id = module_id;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public User getLecUser() {
        return lecUser;
    }

    public void setLecUser(User lecUser) {
        this.lecUser = lecUser;
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    public List<Batch> getBatchList() {
        return batchList;
    }

    public void setBatchList(List<Batch> batchList) {
        this.batchList = batchList;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
