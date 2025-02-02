package com.example.demo.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/hello")
public class HelloWorldController {
    @GetMapping("/{name}")
    public String Hello(@PathVariable String name) {
        return "hello "+ name+" from team 7 and team 12" ;
    }
}


