package com.NoPlan.Phama.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/test")
public class TestController  {

    @GetMapping("/access") // http://localhost:8000/api/v1/test/access
    public String access(){
        return "This is your test Class";
    }
}
