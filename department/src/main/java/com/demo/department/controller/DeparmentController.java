package com.demo.department.controller;

import com.demo.department.model.Department;
import com.demo.department.repository.DepartmentRepo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController()
public class DeparmentController {

    @Autowired
    private DepartmentRepo departmentRepo;
    @GetMapping("/getDepartmentName")
    public String getDepartmentName(){
        return "Department Name is yet to decide!!";
    }

    @Operation(summary = "Get All Departments", description = "Method Description")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "", content = {@Content(mediaType = "", schema = @Schema(implementation = Department.class))}),
            @ApiResponse(responseCode = "201", description = "", content = {@Content(mediaType = "", schema = @Schema(implementation = Department.class))}),
            @ApiResponse(responseCode = "400", description = "", content = {@Content()})
    })
    @GetMapping("/getAllDepartments")
    public ResponseEntity<List<Department>> getAllDepartments(){
        List<Department> departments = new ArrayList<>();
        try{
            departments = departmentRepo.findAll();
            if(departments.isEmpty()){
                return  new ResponseEntity<>(departments, HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(departments, HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getDepartmentById/{id}")
    public ResponseEntity<Department> getDepartment(@PathVariable String id){
        Optional<Department> data =  departmentRepo.findById(Long.valueOf(id));
        if(data.isPresent()){
            return  new ResponseEntity<>(data.get(), HttpStatus.OK);
        }
        return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/addDepartment")
    public ResponseEntity<Department> addDepartment(@RequestBody Department department) {
        try {
            Department response = departmentRepo.save(department);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/updateDepartment/{id}")
    public ResponseEntity<Department> updateDepartment(@PathVariable Long id, @RequestBody Department department) {
        try {
            Optional<Department> deptData = departmentRepo.findById(id);
            if (deptData.isPresent()) {
                Department updatedDeptData = deptData.get();
                updatedDeptData.setCode(department.getCode());
                updatedDeptData.setName(department.getName());

                Department response = departmentRepo.save(updatedDeptData);
                return new ResponseEntity<>(response, HttpStatus.CREATED);
            }

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteDepartmentById/{id}")
    public ResponseEntity<HttpStatus> deleteDepartment(@PathVariable Long id) {
        try {
            departmentRepo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/deleteAllDepartments")
    public ResponseEntity<HttpStatus> deleteAllDepartments() {
        try {
            departmentRepo.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
