package com.demo.intf.impl;

import java.util.Iterator;
import java.util.ServiceLoader;

import org.junit.Test;

import com.demo.intf.SpiService;

/**
 * 类SpiServiceImplTest.java的实现描述：TODO 类实现描述 
 * @author xupeng 2017年3月23日 下午4:28:17
 */
public class SpiServiceImplTest {
    
    @Test
    public void test() {
        ServiceLoader<SpiService> loader = ServiceLoader.load(SpiService.class);

        Iterator<SpiService> searchs = loader.iterator();
        SpiService curSearch = null;
        if (searchs.hasNext()) {
            curSearch = searchs.next();

        }
        curSearch.say();

    }
}
