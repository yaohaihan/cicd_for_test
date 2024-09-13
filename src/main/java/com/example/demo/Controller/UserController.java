package com.example.demo.Controller;


import com.example.demo.Entity.User;
import com.example.demo.Service.UserService;
import com.example.demo.Utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;


    @PostMapping("addUser")
    public Result addUser(@RequestBody User user){
        userService.addUser(user);
        return Result.success();
    }

}
