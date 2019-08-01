package com.example;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author sgh
 * @date 2019/8/1 13:18
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class Slf4jTest {

    @Test
    public void test() {
        log.trace("This is a trace log");
        log.debug("This is a debug log");
        log.info("This is a info log");
        log.warn("This is a warn log");
        log.error("This is a error log");
    }
}
