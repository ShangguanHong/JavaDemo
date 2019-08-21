package com.example.shirosinglereaml.repository;

import com.example.shirosinglereaml.domain.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author sgh
 * @date 2019/8/20 下午10:29
 */
public interface SysUserRepository extends JpaRepository<SysUser, Integer> {
    SysUser findByUsername(String username);
}
