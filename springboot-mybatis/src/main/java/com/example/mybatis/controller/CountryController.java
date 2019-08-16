package com.example.mybatis.controller;

import com.example.mybatis.mapper.CountryMapper;
import com.example.mybatis.model.Country;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author sgh
 * @date 2019/8/16 下午11:02
 */
@RestController

public class CountryController {

    @Resource
    private CountryMapper countryMapper;

    @RequestMapping(value = "/country", method = RequestMethod.GET)
    public Country findCountryByCode(@RequestParam String code) {
        return countryMapper.selectByPrimaryKey(code);
    }
}
