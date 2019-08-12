package com.example.jpa.repository;

import com.example.jpa.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

/**
 * @author sgh
 * @date 2019/7/18 15:02
 */
public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

    @Query(value = "from User where username = ?1")
    User findByUserName(String userName);

    @Modifying
    @Query(value = "update User set username = ?1 where id = ?2")
    int modifyByIdAndUserId(String userName, Long id);

    @Transactional
    @Modifying
    @Query(value = "delete from User where id = ?1")
    void deleteByUserId(Long id);
}
