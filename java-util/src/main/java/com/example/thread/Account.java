package com.example.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 类Account.java的实现描述：银行账户
 * 
 * @author xupeng 2017年4月11日 下午2:58:47
 */
public class Account {
    private double balance;                          // 账户余额
    private Lock   accountLock = new ReentrantLock();

    /**
     * 存款
     * 
     * @param money 存入金额 synchronized
     */
    public void deposit(double money) {
//        accountLock.lock();
//        try {
            double newBalance = balance + money;
            try {
                Thread.sleep(100); // 模拟此业务需要一段处理时间
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            balance = newBalance;
//        } finally {
//            accountLock.unlock();
//        }

    }

    /**
     * 获得账户余额
     */
    public double getBalance() {
        return balance;
    }
}
