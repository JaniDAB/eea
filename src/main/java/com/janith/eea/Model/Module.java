package com.janith.eea.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Module")
public class Module {

    @Id
    @Column(name = "module_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer module_id;

    @Column(name = "module_Name")
    private  String moduleName;

    @ManyToMany
    @JoinTable(name = "module_batch",
            joinColumns = @JoinColumn(name = "module_id"),
            inverseJoinColumns = @JoinColumn(name = "batch_id"))
    private List<Batch> batchList;

@ManyToOne
@JoinColumn(name = "user_id")
@Getter
@Setter
private User lecUser;


    public List<Batch> getBatchList() {
        return batchList;
    }

    public void setBatchList(List<Batch> batchList) {
        this.batchList = batchList;
    }

    public Module() {
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
