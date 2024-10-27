package com.department.services.controller;

import com.department.services.entity.Department;
import com.department.services.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @PostMapping("/addDepartment")
    public ResponseEntity<Object> addDepartment(@RequestBody Department department){
        return departmentService.addDepartment(department);
    }

    @GetMapping("/getDepartmentById/{id}")
    public ResponseEntity<Object> getDepartmentById(@PathVariable("id") Long id){
        return departmentService.getDepartmentById(id);
    }
}
