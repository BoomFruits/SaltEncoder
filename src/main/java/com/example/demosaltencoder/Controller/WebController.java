package com.example.demosaltencoder.Controller;

import com.example.demosaltencoder.Model.MyUser;
import com.example.demosaltencoder.Model.ResponseAPI;
import com.example.demosaltencoder.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class WebController {
    @Autowired
    private UserService userService;
    @GetMapping("/login")
    public String loginRequest(){
        return "login";
    }
    @PostMapping("/register")
    public ResponseEntity<ResponseAPI> registerRequest(@RequestBody MyUser user){
        return ResponseEntity.ok(userService.registerUser(user));
    }
    @GetMapping("/home")
    public String homePage(){
        return "home";
    }
}
