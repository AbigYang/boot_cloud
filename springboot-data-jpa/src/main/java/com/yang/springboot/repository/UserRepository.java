package com.yang.springboot.repository;

import com.yang.springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//继承JpaRepository完成对数据库的操作 Integer是User主键的类型
public interface UserRepository extends JpaRepository<User, Integer> {
}
