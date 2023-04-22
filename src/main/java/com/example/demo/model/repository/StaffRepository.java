package com.example.demo.model.repository;

import com.example.demo.model.pojo.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StaffRepository extends JpaRepository<Staff,Integer>, JpaSpecificationExecutor<Staff> {
    public List<Staff> findByDepartmentId(Integer id);
    public Staff findByUsernameAndPassword(String username,String password);
    public void deleteByDepartmentId(Integer deptId);
}
