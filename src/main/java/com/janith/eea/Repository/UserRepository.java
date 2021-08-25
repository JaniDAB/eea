package com.janith.eea.Repository;

import com.janith.eea.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository  extends JpaRepository<User,Integer> {
    @Query(value = "SELECT u FROM User u  WHERE u.username = ?1")
    public User findByUsername(String username);

    @Query(" FROM User u  WHERE u.username like %:username%")
    List<User>  StudentSearch(String username);

    public User findUsersByUsername(String username);

    List<User> findUsersByBatchBatchID(int batchID);

    List<User> findUsersByBatchBatchCode(String batch_batchCode);
}
