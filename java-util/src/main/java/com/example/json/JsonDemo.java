package com.example.json;

import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * 类JsonDemo.java的实现描述：TODO 类实现描述
 * 
 * @author xupeng 2017年6月23日 上午10:55:59
 */
public class JsonDemo {

    public static void main(String[] args) {
        String str = JSON.toJSONString(new DemoBean("徐朋", null), SerializerFeature.WriteMapNullValue);
        System.out.println(str);
        Map jsonObject = JSON.parseObject(str,Map.class);
        System.out.println(jsonObject.get("name"));
        System.out.println(jsonObject.get("nickName"));

        DemoBean bean = JSON.parseObject(str, DemoBean.class);
        System.out.println(bean.getName());
        System.out.println(bean.getNickName());
    }
}
