package com.example.springdemo.repository;

//import com.example.springdemo.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

/*
public interface UserRepository extends MongoRepository<User,String> {

    @Query("{name:'?0'}")
    User findItemByName(String name);

    @Query(value="{location:'?London'}", fields="{'name' : Meher, 'location' : Reading}")
    List<User> findAll(String category);

    public long count();
}
*/
