package com.example.demo.repo;

import com.example.demo.model.UserTwo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserTwoRepo extends CrudRepository<UserTwo, Long> {

    List<UserTwo> findAll();
    UserTwo findByName(String name);


}
