package com.department.services.service;

import com.department.services.dto.ResponseDTO;
import com.department.services.entity.Department;
import com.department.services.repository.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    DepartmentRepo departmentRepo;

    @Override
    public ResponseEntity<Object> addDepartment(Department department) {
        ResponseDTO response = new ResponseDTO();
        try{
            departmentRepo.save(department);
            response.setMessage("Department saved successfully!");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception ex){
            response.setMessage("Error in saving department!");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Object> getDepartmentById(Long id) {
        Optional<Department> department = departmentRepo.findById(id);
        ResponseDTO response = new ResponseDTO();
        if(department.isPresent()){
            return new ResponseEntity<>(department.get(), HttpStatus.OK);
        }else{
            response.setMessage("Department not found");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }
}
