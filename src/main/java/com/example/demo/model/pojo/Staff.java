package com.example.demo.model.pojo;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "staff")
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String password;
    private String name;
    private String identity;
    private String email;
    private Integer position;
    private Integer gender;
    private Integer departmentId;
    private LocalDate entrydate;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    @Override
    public String toString() {
        return "Staff{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", identity='" + identity + '\'' +
                ", email='" + email + '\'' +
                ", position=" + position +   //0:員工 1:部門經理
                ", gender=" + gender +       //0:男性 1:女性
                ", departmentId=" + departmentId + //1:硬體 2:軟體 3:人資 4:銷售 5:維修
                ", entrydate=" + entrydate +
                ", create_time=" + createTime +
                ", update_time=" + updateTime +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public LocalDate getEntrydate() {
        return entrydate;
    }

    public void setEntrydate(LocalDate entrydate) {
        this.entrydate = entrydate;
    }

    public LocalDateTime getCreate_time() {
        return createTime;
    }

    public void setCreate_time(LocalDateTime create_time) {
        this.createTime = create_time;
    }

    public LocalDateTime getUpdate_time() {
        return updateTime;
    }

    public void setUpdate_time(LocalDateTime update_time) {
        this.updateTime = update_time;
    }
}
