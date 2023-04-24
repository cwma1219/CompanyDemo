package com.example.demo.model.service;
import com.example.demo.model.pojo.Page;
import com.example.demo.model.pojo.Product;
import com.example.demo.model.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    public Product findById(Integer id){
        Product prod = productRepository.findById(id).get();
        return prod;
    }
    public Page showPage(Integer page, Integer pageSize, String name,Integer deptId){
        Specification<Product> spec = new Specification<Product>() {
            @Override
            public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                Predicate find = criteriaBuilder.conjunction();
                if(name != null){
                    Path n = root.get("name");
                    find.getExpressions().add(criteriaBuilder.like(n,"%"+name+"%"));
                }
                if(deptId != null){
                    Path d = root.get("departmentId");
                    find.getExpressions().add(criteriaBuilder.equal(d,deptId));
                }
                return find;
            }
        };
        Pageable pageable = PageRequest.of(page,pageSize);
        List<Product> list = productRepository.findAll(spec,pageable).toList();
        Long total = productRepository.count(spec);
        Page result = new Page(total,list);
        return result;

    }
    public List<Product> findByDeptId(Integer id){
        return productRepository.findByDepartmentId(id);
    }
    public void insert(Product prod){
        prod.setCreateTime(LocalDateTime.now());
        prod.setUpdateTime(LocalDateTime.now());
        productRepository.save(prod);
    }
    public void modify(Product prod){
        Product product = productRepository.findById(prod.getId()).get();

        if(prod.getName()!=null)
            product.setName(prod.getName());
        if(prod.getDepartmentId()!=null)
            product.setDepartmentId(prod.getDepartmentId());

        product.setUpdateTime(LocalDateTime.now());
        productRepository.save(product);
    }
    @Transactional
    public void deleteById(Integer id){
        productRepository.deleteById(id);
    }
}
