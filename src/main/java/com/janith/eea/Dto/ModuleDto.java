package com.janith.eea.Dto;



public class ModuleDto {
    private Integer module_id;


    private  String moduleName;

    public ModuleDto(Integer module_id, String moduleName) {
        this.module_id = module_id;
        this.moduleName = moduleName;
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
}
