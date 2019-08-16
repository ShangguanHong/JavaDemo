package com.example.swagger;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;

public class SwaggerTest {

    @Test
    public void contextLoads() {
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy MM dd");
        String s = "2019 08 15";
        LocalDate localDate = LocalDate.parse(s, pattern);
        System.out.println(localDate);
    }
}
