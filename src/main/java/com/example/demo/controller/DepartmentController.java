package com.example.demo.controller;

import com.example.demo.model.annotation.AuthCheckApi;
import com.example.demo.model.pojo.Department;
import com.example.demo.model.pojo.Product;
import com.example.demo.model.pojo.Result;
import com.example.demo.model.pojo.Staff;
import com.example.demo.model.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dept")
@CrossOrigin
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;
    @GetMapping("/{id}")
    public Result dept(@PathVariable Integer id){
        System.out.println(id);
        Department dept = departmentService.findById(id);
        return Result.success(dept);
    }

    @GetMapping
    public Result dept(){
        List<Department> dept = departmentService.findAll();
        return Result.success(dept);
    }

    @GetMapping("/{id}/staff")
    public Result deptStaff(@PathVariable Integer id){
        List<Staff> staff = departmentService.findStaff(id);
        return Result.success(staff);
    }

    @GetMapping("/{id}/prod")
    public Result deptProd(@PathVariable Integer id){
        List<Product> prod = departmentService.findProd(id);
        return Result.success(prod);
    }

    @PostMapping
    public Result dept(@RequestBody Department dept){
        departmentService.insert(dept);
        return Result.success();
    }
    @PutMapping
    public Result modifyDept(@RequestBody Department dept){
        departmentService.modify(dept);
        return Result.success();
    }
    @AuthCheckApi
    @DeleteMapping("/{id}")
    public Result deleteDept(@PathVariable Integer id){
        departmentService.delete(id);
        return Result.success();
    }
}
