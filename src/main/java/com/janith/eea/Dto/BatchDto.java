package com.janith.eea.Dto;


import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class BatchDto {

    private  Integer batchID;

    @NotBlank(message = "This field may not be empty")
    @Pattern(regexp = "^[a-zA-z]{1,4}[0-9]{1,5}[a-zA-z]{2,5}$",message = " Invalid Batch Code.  Enter as Requested Format")
    private String batchCode;

    @NotBlank(message = "This field may not be empty")
    @Length(min = 3, max = 50, message = "Batch Should Have minimum 3 & Maximum 50 Characters")
    private  String description;

    private String[] moduleList;

    public  int moduleListSize;

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

    public int getModuleListSize() {
        return moduleListSize;
    }

    public void setModuleListSize(int moduleListSize) {
        this.moduleListSize = moduleListSize;
    }
}
