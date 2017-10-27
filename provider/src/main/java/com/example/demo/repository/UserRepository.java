package com.example.demo.repository;

import com.example.demo.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Joker on 2017/10/10.
 */
public interface UserRepository extends JpaRepository<User,Long> {
}
