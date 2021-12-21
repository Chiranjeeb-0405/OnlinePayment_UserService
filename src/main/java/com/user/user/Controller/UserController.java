package com.user.user.Controller;


import com.user.user.Exception.UserNotFoundException;
import com.user.user.Model.User;
import com.user.user.Repository.UserRepository;
import com.user.user.Service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private static final Logger LOGGER=LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    @GetMapping("/getAllUsers")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping("/create")
    public Integer createNewUser(@RequestBody User newUser){
        LOGGER.info("Request for /create had user with name as {}",newUser.getName());
        User user=userRepository.save(newUser);
        return user.getId();
    }

    @GetMapping("/findUser/{id}")
    public Optional<User> findUserById(@PathVariable int id){

        LOGGER.info("Request for /findUserById had id as {}",id);
            return userService.findUserById(id);

    }

}
