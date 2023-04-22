package com.example.demo.controller;

import com.example.demo.model.pojo.Page;
import com.example.demo.model.pojo.Product;
import com.example.demo.model.pojo.Result;
import com.example.demo.model.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prod")
public class ProductController {
    @Autowired
    ProductService productService;
    @GetMapping("/{id}")
    public Result prod(@PathVariable Integer id){
        Product prod = productService.findById(id);
        return Result.success(prod);
    }
    @GetMapping
    public Result prod(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       String name,Integer deptId
                       ){
       Page result = productService.showPage(page-1,pageSize,name,deptId);
        return Result.success(result);
    }
    @GetMapping("/dept/{deptId}")
    public Result deptProd(@PathVariable Integer deptId){
        List<Product> list = productService.findByDeptId(deptId);
        return Result.success(list);
    }
    @PostMapping
    public Result prod(@RequestBody Product prod){
        productService.insert(prod);
        return Result.success();
    }
    @PutMapping
    public Result modifyProd(@RequestBody Product prod){
        productService.modify(prod);
        return Result.success();
    }
}
