package org.io.demo.nio;

/**
 * 类NioDemoClient.java的实现描述：TODO 类实现描述
 * 
 * @author xupeng 2017年10月19日 上午10:52:06
 */
public class NioDemoClient {

    static int DEFAULT_PORT = 10000;

    public static void main(String[] args) throws Exception {
        NioDemoClientHandler client = new NioDemoClientHandler("127.0.0.1", DEFAULT_PORT);
        client.sned("hello");
        client.run();
    }

}
