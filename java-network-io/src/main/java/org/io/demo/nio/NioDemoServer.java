package org.io.demo.nio;

/**
 * 类NioDemoServer.java的实现描述：TODO 类实现描述
 * 
 * @author xupeng 2017年10月19日 上午10:51:57
 */
public class NioDemoServer {

    static int DEFAULT_PORT = 10000;

    public static void main(String[] args) throws Exception {
        new NioDemoServerHandler(DEFAULT_PORT).run();
    }

}
