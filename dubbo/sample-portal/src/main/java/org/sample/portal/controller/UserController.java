package org.sample.portal.controller;

import org.sample.shard.intf.UserService;
import org.sample.shard.params.UserParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/create.json", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Long create() {
        UserParam userParam = new UserParam();
        userParam.setEmplyId("123");
        userParam.setName("徐朋");
        return userService.create(userParam);
    }
}
