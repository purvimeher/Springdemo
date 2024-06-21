package com.example.springdemo.controller;

import com.example.springdemo.model.User;
import com.example.springdemo.repository.UsersRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/")
public class UserController {
//
//    private final Logger LOG = LoggerFactory.getLogger(getClass());

    private final UsersRepository usersRepository;

    public UserController(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<User> getAllUsers() {
//        LOG.info("Getting all users.");
        return usersRepository.findAll();
    }

 /*   @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public User getUser(@PathVariable String userId) {
//        LOG.info("Getting user with ID: {}.", userId);
        return usersRepository.findOne(userId);
    }*/

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public User addNewUsers(@RequestBody User user) {
//        LOG.info("Saving user.");
        return usersRepository.save(user);
    }

  /*  @RequestMapping(value = "/settings/{userId}/{key}", method = RequestMethod.GET)
    public String getUserSetting(@PathVariable String userId, @PathVariable String key) {
        User user = usersRepository.findOne(userId).orElse(null);
        if (user != null) {
            return user.getUserSettings().get(key);
        } else {
            return "User not found.";
        }
    }*/


/*    @RequestMapping(value = "/settings/{userId}/{key}/{value}", method = RequestMethod.GET)
    public String addUserSetting(@PathVariable String userId, @PathVariable String key, @PathVariable String value) {
        User user = usersRepository.findOne(userId);
        if (user != null) {
            user.getUserSettings().put(key, value);
            usersRepository.save(user);
            return "Key added";
        } else {
            return "User not found.";
        }
    }*/
}
