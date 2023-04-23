package com.example.demo.controller;

import com.example.demo.model.pojo.Result;
import com.example.demo.model.pojo.Staff;
import com.example.demo.model.service.StaffService;
import com.example.demo.model.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
@RestController
@CrossOrigin
public class LoginController {
    @Autowired
    StaffService staffService;
    @PostMapping ("/login")
    public Result login(@RequestBody Staff staff){
        Staff s = staffService.login(staff);
        if(s != null){
            Map<String,Object> claim = new HashMap<>();
            claim.put("username",s.getUsername());
            claim.put("position",s.getPosition());
            claim.put("deptId",s.getDepartmentId());
            String jwt = JwtUtils.getJwt(claim);
            return Result.success(jwt);
        }
        return Result.error("Error");
    }
}
