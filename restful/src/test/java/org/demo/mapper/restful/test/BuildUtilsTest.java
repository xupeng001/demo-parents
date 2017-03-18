package org.demo.mapper.restful.test;

import java.util.ArrayList;
import java.util.List;

import org.demo.mapper.restful.BuildUtils;
import org.demo.mapper.restful.ICallback;
import org.demo.mapper.restful.test.model.AccountInfo;
import org.demo.mapper.restful.test.model.BizCategory;
import org.demo.mapper.restful.test.model.CustomerInfo;
import org.demo.mapper.restful.test.model.CustomerInfoProtocolVo;
import org.demo.mapper.restful.test.model.RelationPersonInfo;
import org.demo.mapper.restful.test.model.RelationPersonProtocolVo;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;

public class BuildUtilsTest {

    private Logger log = LoggerFactory.getLogger(BuildUtilsTest.class);

    @Test
    public void testOneToOneObj() {
        log.info("----------------测试多个对象组装成一个对象--start------------------");
        CustomerInfo customerInfo = new CustomerInfo();
        customerInfo.setName("name");
        customerInfo.setCid(1L);
        BizCategory bizCategory = new BizCategory();
        bizCategory.setBizCategory("bizCategory");
        bizCategory.setBizCategorySub("bizCategorySub");
        CustomerInfoProtocolVo vo = null;
        vo = BuildUtils.handleObject(new CustomerInfoProtocolVo(), bizCategory, customerInfo);
        log.info(" cid:{}  customerName:{}  bizCategory :{}  bizCategorySub:{}", vo.getCid(), vo.getCustomerName(),
                vo.getBizCategory(), vo.getBizCategorySub());
        log.info("----------------测试多个对象组装成一个对象--end------------------");
    }

    @Test
    public void testNoData() {
        log.info("----------------测试callback--start------------------");
        CustomerInfoProtocolVo vo = null;
        vo = BuildUtils.handleObject(new CustomerInfoProtocolVo(), new ICallback<CustomerInfoProtocolVo>() {
            public void callback(CustomerInfoProtocolVo bizCategory) {
                bizCategory.setCid("cid");
                bizCategory.setBizCategory("bizCategory");
                bizCategory.setBizCategory("bizCategory");
                bizCategory.setBizCategorySub("bizCategorySub");
            }
        });
        log.info(" cid:{}  customerName:{}  bizCategory :{}  bizCategorySub:{}", vo.getCid(), vo.getCustomerName(),
                vo.getBizCategory(), vo.getBizCategorySub());
        log.info("----------------测试多个对象组装成一个对象并且支持自定义赋值--end------------------");
    }

    @Test
    public void testListToObj() {
        log.info("----------------测试多个对象组装成一个对象并且支持自定义赋值--start------------------");
        CustomerInfoProtocolVo vo = null;
        CustomerInfo customerInfo = new CustomerInfo();
        customerInfo.setName("name");
        customerInfo.setCid(1L);
        BizCategory bizCategory = new BizCategory();
        bizCategory.setBizCategory("bizCategory");
        bizCategory.setBizCategorySub("bizCategorySub");
        vo = BuildUtils.handleObject(new CustomerInfoProtocolVo(), new ICallback<CustomerInfoProtocolVo>() {
            public void callback(CustomerInfoProtocolVo t) {
                t.setCid("测试callback");
                t.setBizCategory("bizCategory callback 覆盖测试");
            }
        });
        log.info(" cid:{}  customerName:{}  bizCategory :{}  bizCategorySub:{}", vo.getCid(), vo.getCustomerName(),
                vo.getBizCategory(), vo.getBizCategorySub());
        log.info("----------------测试多个对象组装成一个对象并且支持自定义赋值--end------------------");
        log.info("----------------测试给对象中的list赋值--start------------------");
        List<AccountInfo> accountInfos = Lists.newArrayList();
        AccountInfo accountInfo = new AccountInfo();
        accountInfo.setAliyunID("aliyunID");
        accountInfos.add(accountInfo);
        accountInfo = new AccountInfo();
        accountInfo.setAliyunID("aliyunID");
        accountInfos.add(accountInfo);
        List<RelationPersonInfo> personInfos = Lists.newArrayList();
        RelationPersonInfo personInfo = new RelationPersonInfo();
        personInfo.setEmpId("empId");
        personInfos.add(personInfo);
        personInfo = new RelationPersonInfo();
        personInfo.setEmpId("empId");
        personInfos.add(personInfo);
        vo = BuildUtils.handleObject(vo, accountInfos, personInfos);
        log.info(" uids:{} info:{}", vo.getUids().size(), JSON.toJSONString(vo.getUids()));
        log.info(" businessManager:{} info:{}", vo.getBusinessManager().size(),
                JSON.toJSONString(vo.getBusinessManager()));
        log.info(" vo : {}", JSON.toJSONString(vo));
        log.info("----------------测试给对象中的list赋值--end------------------");

    }

    //    @Test
    public void testListToList() {
        log.info("----------------测试list组装--start------------------");
        List<RelationPersonInfo> personInfos = Lists.newArrayList();
        RelationPersonInfo personInfo = new RelationPersonInfo();
        personInfo.setEmpId("empId");
        personInfos.add(personInfo);
        personInfo = new RelationPersonInfo();
        personInfo.setEmpId("empId");
        personInfos.add(personInfo);
        List<RelationPersonInfo> personInfos2 = Lists.newArrayList();
        personInfo = new RelationPersonInfo();
        personInfo.setCid(1L);
        personInfos2.add(personInfo);
        personInfo = new RelationPersonInfo();
        personInfo.setCid(2L);
        personInfos2.add(personInfo);
        List<RelationPersonProtocolVo> vo = BuildUtils.handleList(new ArrayList<RelationPersonProtocolVo>(),
                RelationPersonProtocolVo.class, personInfos, personInfos2);
        log.info("  vo : {} ", JSON.toJSONString(vo));
        log.info("----------------测试list组装--end------------------");

    }

    //    @Test
    public void testBeanCopy() {
        log.info("----------------测试beanCopy--start------------------");
        RelationPersonInfo personInfo = new RelationPersonInfo();
        personInfo.setEmpId("empId");
        personInfo.setCid(1L);
        personInfo.setType(1);
        personInfo.setName("name");
        RelationPersonInfo vo = new RelationPersonInfo();
        vo.setCid(100L);
        BuildUtils.copyProperties(vo, personInfo);
        log.info("  vo : {} ", JSON.toJSONString(personInfo));
        log.info("----------------测试beanCopy--end------------------");
    }

}
