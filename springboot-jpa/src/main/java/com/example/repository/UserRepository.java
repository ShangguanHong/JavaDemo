package com.example.repository;

import com.example.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author sgh
 * @date 2019/7/18 15:02
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
