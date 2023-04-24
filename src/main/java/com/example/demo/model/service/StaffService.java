package com.example.demo.model.service;

import com.example.demo.model.pojo.Page;
import com.example.demo.model.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import com.example.demo.model.pojo.Staff;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.*;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class StaffService {
    @Autowired
    StaffRepository staffRepository;

    public Staff login(Staff staff){
        return staffRepository.findByUsernameAndPassword(staff.getUsername(),staff.getPassword());
    }
    public Staff getById(Integer id){
        Staff staff = staffRepository.findById(id).get();
        return staff;
    }

    public Page showPage(Integer page, Integer pageSize, String name, Short gender,Integer deptId) {
        Specification<Staff> spec = new Specification<Staff>() {
            @Override
            public Predicate toPredicate(Root<Staff> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                Predicate find = criteriaBuilder.conjunction();
                if(name != null){
                    Path n = root.get("name");
                    find.getExpressions().add(criteriaBuilder.like(n,"%"+name+"%"));
                }
                if(gender != null){
                    Path g = root.get("gender");
                    find.getExpressions().add(criteriaBuilder.equal(g,gender));
                }
                if(deptId != null){
                    Path d = root.get("departmentId");
                    find.getExpressions().add(criteriaBuilder.equal(d,deptId));
                }
                return find;
            }
        };
        Pageable pageable = PageRequest.of(page,pageSize);
        List<Staff> list = staffRepository.findAll(spec,pageable).toList();
        Long total = staffRepository.count(spec);
        Page result = new Page(total,list);
        return result;
    }
    public void insert(Staff staff){
        staff.setCreate_time(LocalDateTime.now());
        staff.setUpdate_time(LocalDateTime.now());
        staffRepository.save(staff);
    }
    public void modify(Staff staff){
        Staff emp = staffRepository.findById(staff.getId()).get();
        if(staff.getName()!=null)
            emp.setName(staff.getName());
        if(staff.getUsername()!=null)
            emp.setUsername(staff.getUsername());
        if(staff.getPassword()!=null)
            emp.setPassword(staff.getPassword());
        if(staff.getIdentity()!=null)
            emp.setIdentity(staff.getIdentity());
        if(staff.getEmail()!=null)
            emp.setEmail(staff.getEmail());
        if(staff.getPosition()!=null)
            emp.setPosition(staff.getPosition());
        if(staff.getGender()!=null)
            emp.setGender(staff.getGender());
        if(staff.getDepartmentId()!=null)
            emp.setDepartmentId(staff.getDepartmentId());
        if(staff.getEntrydate()!=null)
            emp.setEntrydate(staff.getEntrydate());
        System.out.println(staff.getName());
        emp.setUpdate_time(LocalDateTime.now());
        staffRepository.save(emp);
    }
    @Transactional
    public void deleteById(Integer id){
        staffRepository.deleteById(id);
    }
}
