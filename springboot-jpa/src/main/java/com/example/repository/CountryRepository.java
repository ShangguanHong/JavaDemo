package com.example.repository;

import com.example.domain.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.io.Serializable;
import java.util.List;

/**
 * @author sgh
 * @date 2019/7/8 22:44
 */
public interface CountryRepository extends JpaRepository<Country, String>, JpaSpecificationExecutor<Country>, Serializable {

    public List<Country> findAll();

    @Query("from Country")
    public List<Country> queryAllByMyself();

}
