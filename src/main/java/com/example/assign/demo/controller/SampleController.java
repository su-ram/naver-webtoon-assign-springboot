package com.example.assign.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("api/sample")
public class SampleController {


    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public String index(@PathVariable("id") String id){
        return "hello";
    }
}
