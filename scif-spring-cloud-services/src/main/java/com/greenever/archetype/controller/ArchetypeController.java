package com.greenever.archetype.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArchetypeController {


    @GetMapping("test")
    public String test(){
        return "Service ";
    }

}
