package com.janith.eea.Dto;


public class BatchDto {

    private  Integer batchID;

    private String batchCode;

    private  String description;

    private String[] moduleList;

    public BatchDto(Integer batchID, String batchCode, String description, String[] moduleList) {
        this.batchID = batchID;
        this.batchCode = batchCode;
        this.description = description;
        this.moduleList = moduleList;
    }

    public BatchDto() {
    }

    public String[] getModuleList() {
        return moduleList;
    }

    public void setModuleList(String[] moduleList) {
        this.moduleList = moduleList;
    }

    public Integer getBatchID() {
        return batchID;
    }

    public void setBatchID(Integer batchID) {
        this.batchID = batchID;
    }

    public String getBatchCode() {
        return batchCode;
    }

    public void setBatchCode(String batchCode) {
        this.batchCode = batchCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
