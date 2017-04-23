package com.example.thread;

/**
 * 类AddMoneyThread.java的实现描述：存钱线程
 * 
 * @author xupeng 2017年4月11日 下午2:58:36
 */
public class AddMoneyThread implements Runnable {
    private Account account; // 存入账户
    private double  money;  // 存入金额

    public AddMoneyThread(Account account, double money) {
        this.account = account;
        this.money = money;
    }

    @Override
    public void run() {
//        synchronized (account) {
            account.deposit(money);
//        }
    }
}
