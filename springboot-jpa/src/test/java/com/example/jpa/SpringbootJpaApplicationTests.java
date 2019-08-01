package com.example.jpa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootJpaApplicationTests {

    @Test
    public void contextLoads() {
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            stringList.add("aaaa" + i);
        }
        System.out.println("未自定义排序前");
        System.out.println(stringList);
        Collections.sort(stringList, (o1, o2) -> {
            int a = 0;
            int b = 0;
            int c = 0;
            for (int i = 0; i < o1.length(); i++) {
                a = a + (o1.charAt(i));
            }
            for (int i = 0; i < o2.length(); i++) {
                b = b + (o2.charAt(i));
            }
            for (int i = 0; i < "aaaa5".length(); i++) {
                c = c + "aaaa5".charAt(i);
            }
            a = Math.abs(a - c);
            b = Math.abs(b - c);
            return a - b;
        });
        System.out.println("自定义排序后");
        System.out.println(stringList);
    }

}
