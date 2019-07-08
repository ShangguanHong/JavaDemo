package com.example.controller;

import com.example.domain.Country;
import com.example.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author sgh
 * @date 2019/7/8 23:17
 */
@RestController
public class CountryController {

    @Autowired
    CountryRepository countryRepository;

    @GetMapping(value = "/test1")
    public List<Country> test1() {
        List<Country> countries = countryRepository.findAll();
        return countries;
    }
    @GetMapping(value = "/test2")
    public List<Country> test2() {
        List<Country> countries = countryRepository.queryAllByMyself();
        return countries;
    }
}
