package com.example.shiromultiplerealm.repository;

import com.example.shiromultiplerealm.domain.SysUser;
import org.springframework.data.repository.CrudRepository;

/**
 * @author sgh
 * @date 2019/8/18 下午1:32
 */
public interface UserInfoRepository extends CrudRepository<SysUser, Integer> {

    /**
     * 通过username查找用户信息
     *
     * @param username username
     * @return SysUser
     */
    public SysUser findByUsername(String username);
}
