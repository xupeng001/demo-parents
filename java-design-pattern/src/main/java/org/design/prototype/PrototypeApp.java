package org.design.prototype;

import org.design.prototype.bean.Account;
import org.design.prototype.bean.Customer;

/**
 * 类PrototypeApp.java的实现描述：原型
 * 复制一个已经存在的对象
 * 
 * 常用场景
 * 对象类型不是开始就能确定的
 * 对象状态已经改变，不能通过new获取当前对象的clone
 * 
 * 常与建造工厂一起使用，快速生成对象实例，优于new（在某些情况下）
 * 
 * @author xupeng 2017年10月11日 下午3:59:11
 */
public class PrototypeApp {

    public static void main(String[] args) {

        Customer customerPrototype = new Customer("客户名", 100L, "描述信息");
        Account account = new Account("12345", "12345@hotmail.com");
        customerPrototype.setAccount(account);

        Customer customer = customerPrototype.deepClone();

        Customer c1 = customer.clone();
        c1.setCid(1L);
        c1.getAccount().setEmpId("e1");

        Customer c2 = customer.clone();
        c2.setCid(2L);

        System.out.println(customer.getCid());
        System.out.println(c1.getCid());
        System.out.println(c2.getCid());
        System.out.println(customer.getAccount().getEmpId());
        System.out.println(c1.getAccount().getEmpId());
        System.out.println(c2.getAccount().getEmpId());
        System.out.println(c1.getAccount() == c2.getAccount());

        customer = customerPrototype.deepClone();
        c1 = customer.deepClone();
        c1.setCid(1L);
        c1.getAccount().setEmpId("e1");

        c2 = customer.deepClone();
        c2.setCid(2L);
        c2.getAccount().setEmpId("e2");

        System.out.println(customer.getCid());
        System.out.println(c1.getCid());
        System.out.println(c2.getCid());
        System.out.println(customer.getAccount().getEmpId());
        System.out.println(c1.getAccount().getEmpId());
        System.out.println(c2.getAccount().getEmpId());

        System.out.println(c1.getAccount() == c2.getAccount());
    }
}
