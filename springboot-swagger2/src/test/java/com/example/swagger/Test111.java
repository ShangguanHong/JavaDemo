package com.example.swagger;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class Test111 {

    @Test
    public void contextLoads() throws IOException {
        String[][] data = {{"1", "2"}, {"3", "4"}};
        ObjectMapper mapper = new ObjectMapper();
        String s = null;
        s = mapper.writeValueAsString(data);
        log.debug(s);
//        String[][] strings = mapper.readValue(s, String[][].class);
//        for (String[] string : strings) {
//            for (String s1 : string) {
//                log.debug(s1);
//            }
//        }
    }
}
