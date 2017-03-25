package org.sample.service.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.sample.serivce.Application;
import org.sample.shard.intf.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@ImportResource({ "classpath:application-context.xml" })
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void testCreate() {
        System.out.println(userService);
    }
}
