package com.janith.eea.Repository;

import com.janith.eea.Model.Batch;
import com.janith.eea.Model.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModuleRepository extends JpaRepository<Module,Integer> {


    public List<Module>  findModuleByLecUser_UserId(int UserID);
}
