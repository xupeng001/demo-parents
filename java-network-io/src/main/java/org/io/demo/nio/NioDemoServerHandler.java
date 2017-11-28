package org.io.demo.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * 类NioDemoServerHandler.java的实现描述：TODO 类实现描述
 * 
 * @author xupeng 2017年10月19日 上午10:52:11
 */
public class NioDemoServerHandler implements Runnable {

    ServerSocketChannel serverSocketChannel;

    Selector            selector;

    int                 port;

    volatile boolean    started;

    public NioDemoServerHandler(int port) {
        try {
            init(port);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    public void init(int port) throws Exception {
        /**
         * 
         */
        serverSocketChannel = ServerSocketChannel.open();

        selector = Selector.open();

        serverSocketChannel.configureBlocking(false);

        serverSocketChannel.bind(new InetSocketAddress(port), 1024);

        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        started = true;

    }

    public void destroy() {
        started = false;
    }

    @Override
    public void run() {

        try {
            while (started) {

                int select = selector.select(1000);
                Set<SelectionKey> selectedKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectedKeys.iterator();
                while (iterator.hasNext()) {
                    SelectionKey key = iterator.next();
                    iterator.remove();

                    if (!key.isValid()) {
                        continue;
                    }
                    if (key.isAcceptable()) {
                        ServerSocketChannel sChannel = (ServerSocketChannel) key.channel();
                        SocketChannel channel = sChannel.accept();
                        channel.configureBlocking(false);
                        channel.register(selector, SelectionKey.OP_READ);
                    }
                    if (key.isReadable()) {
                        SocketChannel channel = (SocketChannel) key.channel();
                        ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
                        int read = channel.read(buffer);
                        String result = "...";
                        if (read > 0) {
                            buffer.flip();
                            byte[] bytes = new byte[buffer.remaining()];
                            buffer.get(bytes);
                            System.out.println(result = new String(bytes, "UTF-8"));
                        }
                        channel.register(selector, SelectionKey.OP_READ);
                        byte[] bytes = result.getBytes();
//                        channel.register(selector, SelectionKey.OP_WRITE);
                        //根据数组容量创建ByteBuffer
                        ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);
                        //将字节数组复制到缓冲区
                        writeBuffer.put(bytes);
                        //flip操作
                        writeBuffer.flip();
                        //发送缓冲区的字节数组
                        channel.write(writeBuffer);
                    }

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
