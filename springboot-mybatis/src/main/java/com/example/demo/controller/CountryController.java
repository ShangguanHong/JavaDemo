package com.example.demo.controller;

import com.example.demo.mapper.CountryMapper;
import com.example.demo.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * CountryController class
 *
 * @author  sgh
 * @date 2019/5/30 20:30
 */

@RestController

public class CountryController {

    @Autowired
    private CountryMapper countryMapper;

    @RequestMapping(value = "/country", method = RequestMethod.GET)
    public Country findCountryByCode(@RequestParam String code) {
        Country country = countryMapper.selectByCode(code);
        return country;
    }
}
