package com.janith.eea.Model;


import org.springframework.ui.Model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Batch")
public class Batch {
    @Id
    @Column(name = "batch_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer batchID;

    @Column(name = "batch_Code")
    private String batchCode;

    @Column(name = "description")
    private  String description;

    @ManyToMany
    @JoinTable(name = "module_batch",
    joinColumns = @JoinColumn(name = "batch_id"),
    inverseJoinColumns = @JoinColumn(name = "module_id"))
    private List<Module> moduleList;

    public Batch() {
    }

    public Batch( String batchCode, String description) {

        this.batchCode = batchCode;
        this.description = description;
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

    public List<Module> getModuleList() {
        return moduleList;
    }

    public void setModuleList(List<Module> moduleList) {
        this.moduleList = moduleList;
    }
}
