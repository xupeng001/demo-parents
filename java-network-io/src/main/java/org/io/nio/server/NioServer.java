package org.io.nio.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

import com.anxpp.io.utils.Calculator;

/**
 * 类Server.java的实现描述：TODO 类实现描述
 * 
 * @author xupeng 2017年10月13日 上午10:53:13
 */
public class NioServer {

    private static int DEFAULT_PORT = 12345;

    public static void start() {
        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.socket().bind(new InetSocketAddress(DEFAULT_PORT), 1024);
            serverSocketChannel.configureBlocking(false);//开启非阻塞模式
            Selector selector = Selector.open();
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("server start");
            while (true) {
                try {

                    selector.select(1000);
                    Set<SelectionKey> selectedKeys = selector.selectedKeys();
                    Iterator<SelectionKey> iterator = selectedKeys.iterator();
                    while (iterator.hasNext()) {
                        SelectionKey key = iterator.next();
                        iterator.remove();
                        if (key.isValid()) {

                            if (key.isAcceptable()) {
                                ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
                                SocketChannel sc = ssc.accept();
                                sc.configureBlocking(false);
                                sc.register(selector, SelectionKey.OP_READ);
                            }

                            if (key.isReadable()) {
                                SocketChannel sc = (SocketChannel) key.channel();
                                //创建ByteBuffer，并开辟一个1M的缓冲区
                                ByteBuffer buffer = ByteBuffer.allocate(1024);
                                //读取请求码流，返回读取到的字节数
                                int readBytes = sc.read(buffer);
                                //读取到字节，对字节进行编解码
                                if (readBytes > 0) {
                                    //将缓冲区当前的limit设置为position=0，用于后续对缓冲区的读取操作
                                    buffer.flip();
                                    //根据缓冲区可读字节数创建字节数组
                                    byte[] bytes = new byte[buffer.remaining()];
                                    //将缓冲区可读字节数组复制到新建的数组中
                                    buffer.get(bytes);
                                    String expression = new String(bytes, "UTF-8");
                                    System.out.println("服务器收到消息：" + expression);
                                    //处理数据
                                    String result = null;
                                    try {
                                        result = Calculator.cal(expression).toString();
                                    } catch (Exception e) {
                                        result = "计算错误：" + e.getMessage();
                                    }
                                    //发送应答消息
                                    System.out.println("结果：" + result);
                                    
                                    sc.register(selector, SelectionKey.OP_READ);
                                    doWrite(sc, result);
                                    
                                }
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    throw e;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //异步发送消息
    private static void doWrite(SocketChannel channel, String request) throws IOException {
        //将消息编码为字节数组
        byte[] bytes = request.getBytes();
        //根据数组容量创建ByteBuffer
        ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);
        //将字节数组复制到缓冲区
        writeBuffer.put(bytes);
        //flip操作
        writeBuffer.flip();
        //发送缓冲区的字节数组
        channel.write(writeBuffer);
        //****此处不含处理“写半包”的代码
    }

    public static void main(String[] args) {
        start();
    }
}
