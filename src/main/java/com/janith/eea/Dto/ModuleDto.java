package com.janith.eea.Dto;


import com.janith.eea.Model.User;

public class ModuleDto {
    private Integer module_id;


    private  String moduleName;

    private User lecUser;

    public ModuleDto(Integer module_id, String moduleName, User lecUser) {
        this.module_id = module_id;
        this.moduleName = moduleName;
        this.lecUser = lecUser;
    }

    public ModuleDto() {
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
}
