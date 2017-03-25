package org.sample.serivce.service.impl;

import org.junit.Assert;
import org.sample.shard.dto.UserDto;
import org.sample.shard.intf.UserService;
import org.sample.shard.params.UserParam;
import org.springframework.stereotype.Service;

/**
 * 类UserServiceImpl.java的实现描述：TODO 类实现描述
 * 
 * @author xupeng 2017年3月25日 下午12:03:15
 */
@Service
public class UserServiceImpl implements UserService {

    public Long create(UserParam userParam) {
        return 1L;
    }

    public UserDto findUserById(Long id) {
        long expected = 1L;
        long actual = id.longValue();
        Assert.assertEquals(expected, actual);
        return new UserDto("徐朋", "123");
    }

}
