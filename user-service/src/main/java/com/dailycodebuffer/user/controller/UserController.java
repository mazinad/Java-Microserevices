package com.dailycodebuffer.user.controller;

import com.dailycodebuffer.user.VO.ResponseTemplateVo;
import com.dailycodebuffer.user.model.User;
import com.dailycodebuffer.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(summary = "This is to add a new User to Db")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "User Added to Db",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "NOt Available",
                    content = @Content)
    })
    @PostMapping("/saveUser")
    public User createAndSaveUser( @RequestBody User user){
        logger.info("UserController.createAndSaveUser()");

        return userService.saveUser(user);
    }
    @Operation(summary = "This is to get a user in a department")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "User with a specific department Added to Db",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "NOt Available",
                    content = @Content)
    })
    @GetMapping("/getUser/{id}")
    public ResponseTemplateVo getUserWithDepartments(@PathVariable(value = "id") Long userId){
        logger.info("UserController.getUserWithDepartments()");
        return userService.getUserWithDepartments(userId);
    }
    @Operation(summary = "This is to get a User to Db")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "User Retrieved",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "NOt Available",
                    content = @Content)
    })
    @GetMapping("/getOneUser/{id}")
        public User getOneUser(@PathVariable("id")Long userId){
        return userService.getOneUser(userId);
    }
    @Operation(summary = "This is to get all Users")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Department Retrieved to Db",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "NOt Available",
                    content = @Content)
    })
    @GetMapping("/allUsers")
    public List<User>getAllUsers(){
        return userService.getAllUsers();
    }
    @Operation(summary = "This is to Deleted a User to Db")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "User Deleted to Db",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "NOt Available",
                    content = @Content)
    })
    @PostMapping("/deleteUser/{id}")
    public void deleteUser(@PathVariable("id") Long userId){
        userService.deleteUser(userId);
    }
}
