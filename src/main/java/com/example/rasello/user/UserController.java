package com.example.rasello.user;

import com.example.rasello.response.BaseResponse;
import com.example.rasello.response.Response;
import com.example.rasello.user.request.UserWorkspace;
import com.example.rasello.workspace.Workspace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private  UserService userService;

    @PostMapping("/add")
    public BaseResponse<UserProfile> addNewUser(@RequestBody UserProfile userProfile){
        return  userService.addUser(userProfile);
    }

    @PutMapping("/{userId}")
    public  BaseResponse<UserProfile> update(@PathVariable UUID userId, @RequestBody UserProfile userProfile){
        return  userService.update(userId, userProfile);
    }

    @DeleteMapping("/{userId}")
    public Response delete(@PathVariable UUID userId){
        return  userService.deleteById(userId);
    }

    @PostMapping("/{userId}")
    public BaseResponse addUserWorkspace(@PathVariable UUID userId, @RequestBody UserWorkspace request){
        return userService.addUserWorkspace(userId,request);
    }

}

