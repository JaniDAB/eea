package com.janith.eea.Repository;

import com.janith.eea.Model.Batch;
import com.janith.eea.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BatchRepository extends JpaRepository<Batch,Integer> {


}
