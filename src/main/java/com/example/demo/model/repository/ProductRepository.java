package com.example.demo.model.repository;

import com.example.demo.model.pojo.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer>, JpaSpecificationExecutor<Product> {
    public List<Product> findByDepartmentId(Integer id);
    public void deleteByDepartmentId(Integer deptId);
}
