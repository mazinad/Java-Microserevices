package com.dailycodebuffer.user.controller;

import com.dailycodebuffer.user.VO.ResponseTemplateVo;
import com.dailycodebuffer.user.model.User;
import com.dailycodebuffer.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    Logger logger = LoggerFactory.getLogger(UserController.class);
    @PostMapping("/saveUser")
    public User createAndSaveUser( @RequestBody User user){
        logger.info("UserController.createAndSaveUser()");

        return userService.saveUser(user);
    }
    @GetMapping("/getUser/{id}")
    public ResponseTemplateVo getUserWithDepartments(@PathVariable(value = "id") Long userId){
        logger.info("UserController.getUserWithDepartments()");
        return userService.getUserWithDepartments(userId);
    }
    @GetMapping("/getOneUser/{id}")
        public User getOneUser(@PathVariable("id")Long userId){
        return userService.getOneUser(userId);
    }
    @GetMapping("/allUsers")
    public List<User>getAllUsers(){
        return userService.getAllUsers();
    }
    @PostMapping("/deleteUser/{id}")
    public void deleteUser(@PathVariable("id") Long userId){
        userService.deleteUser(userId);
    }
}
