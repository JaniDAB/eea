package com.janith.eea.Dto;

import javax.persistence.Column;

public class BatchDto {

    private  Integer batchID;

    private String batchCode;

    private  String description;

    public BatchDto(Integer batchID, String batchCode, String description) {
        this.batchID = batchID;
        this.batchCode = batchCode;
        this.description = description;
    }

    public BatchDto() {
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
