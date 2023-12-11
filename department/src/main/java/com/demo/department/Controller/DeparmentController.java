package com.demo.department.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class DeparmentController {
    @GetMapping("/getDepartmentName")
    public String getDepartmentName(){
        return "Department Name is yet to decide!!";
    }
}
