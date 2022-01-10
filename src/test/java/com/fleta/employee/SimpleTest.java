package com.fleta.employee;

import com.fleta.employee.entity.User;
import org.junit.jupiter.api.Test;

public class SimpleTest {
    @Test
    void test() {
        User user1 = User.builder()
                .loginId("test")
                .build();
        System.out.println(user1);
    }
 }
