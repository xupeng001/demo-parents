package org.sample.shard.intf;

import org.sample.shard.dto.UserDto;
import org.sample.shard.params.UserParam;

/**
 * 类UserService.java的实现描述：TODO 类实现描述
 * 
 * @author xupeng 2017年3月25日 上午11:54:22
 */
public interface UserService {

    /**
     * 用戶创建
     * 
     * @param userParam
     * @return
     */
    Long create(UserParam userParam);

    /**
     * 查询用户
     * @param id
     * @return
     */
    UserDto findUserById(Long id);
}
