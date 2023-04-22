package com.example.demo.model.service;

import com.example.demo.model.pojo.Department;
import com.example.demo.model.pojo.Product;
import com.example.demo.model.pojo.Staff;
import com.example.demo.model.repository.DepartmentRepository;
import com.example.demo.model.repository.ProductRepository;
import com.example.demo.model.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class DepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    StaffRepository staffRepository;
    @Autowired
    ProductRepository productRepository;
    public Department findById(Integer id){
        Department dept = departmentRepository.findById(id).get();
        return dept;
    }
    public List<Department> findAll(){
        return departmentRepository.findAll();
    }
    public void insert(Department dept){
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        departmentRepository.save(dept);

    }
    public void modify(Department dept){
        dept.setUpdateTime(LocalDateTime.now());
        departmentRepository.save(dept);

    }
    public List<Staff> findStaff(Integer id){
        List<Staff> list = staffRepository.findByDepartmentId(id);
        return list;
    }
    public List<Product> findProd(Integer id){
        List<Product> list = productRepository.findByDepartmentId(id);
        return list;
    }
    @Transactional
    public void delete(Integer id){
        departmentRepository.deleteById(id);
        staffRepository.deleteByDepartmentId(id);
        productRepository.deleteByDepartmentId(id);
    }
}
