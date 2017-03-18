package org.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类PropertiesCheckController.java的实现描述：验证自定义配置文件
 * 
 * @author xupeng 2017年3月16日 下午4:04:24
 */
@RestController
public class PropertiesCheckController {

    @Value("${name}")
    private String name;

    @RequestMapping("/showName")
    public String showName() {
        return name;
    }
}
