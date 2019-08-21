package com.example.shiro.repository;

import com.example.shiro.domain.SysAdmin;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author sgh
 * @date 2019/8/19 下午9:48
 */
public interface SysAdminRepository extends JpaRepository<SysAdmin, Integer> {
    SysAdmin findByUsername(String username);
}
