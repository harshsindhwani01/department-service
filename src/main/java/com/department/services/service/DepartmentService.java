package com.department.services.service;

import com.department.services.entity.Department;
import org.springframework.http.ResponseEntity;

public interface DepartmentService {

    ResponseEntity<Object> addDepartment(Department department);

    ResponseEntity<Object> getDepartmentById(Long id);
}
