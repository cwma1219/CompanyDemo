package com.example.demo.controller;

import com.example.demo.model.annotation.AuthCheckApi;
import com.example.demo.model.pojo.Page;
import com.example.demo.model.pojo.Result;
import com.example.demo.model.pojo.Staff;
import com.example.demo.model.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.websocket.server.PathParam;
import java.util.List;
@RestController
@CrossOrigin
@RequestMapping("/staff")

public class StaffController {
    @Autowired
    StaffService staffService;
    @GetMapping("/{id}")
    public Result staff(@PathVariable Integer id){
        Staff staff = staffService.getById(id);
        return Result.success(staff);
    }
    @GetMapping
    public Result staff(@RequestParam(defaultValue = "1") Integer page,
                        @RequestParam(defaultValue = "5") Integer pageSize,
                        String name,Short gender,Integer deptId
                        ){
        Page result = staffService.showPage(page-1,pageSize,name,gender,deptId);
        return Result.success(result);
    }
    @PostMapping
    public Result staff (@RequestBody Staff staff){
        System.out.println(staff);
        staffService.insert(staff);
        return Result.success();
    }
    @PutMapping
    public Result modifyStaff (@RequestBody Staff staff){
        System.out.println(staff);
        staffService.modify(staff);
        return Result.success();
    }
    @AuthCheckApi
    @DeleteMapping("/{id}")
    public Result deleteStaff(@PathVariable Integer id){
        System.out.println(id);
        staffService.deleteById(id);
        return Result.success();
    }
}
