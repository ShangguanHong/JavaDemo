package com.example.mybatisplus.service.component;

import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;
import java.util.stream.IntStream;

/**
 * @author sgh
 * @date 2019/8/29 10:25
 */
@Component
public class Test {

    @Async
    public void sleep() {
        while (true) {
            IntStream.range(0, 5).forEach(i -> {
                System.out.println("I'm Sleep " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
