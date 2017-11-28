package org.io.demo.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * 类NioDemoClientHandler.java的实现描述：TODO 类实现描述
 * 
 * @author xupeng 2017年10月19日 上午10:52:03
 */
public class NioDemoClientHandler implements Runnable {

    SocketChannel socketChannel;

    Selector      selector;

    boolean       started;

    public void init(String host, int port) throws Exception {

        socketChannel = SocketChannel.open();

        selector = Selector.open();

        socketChannel.configureBlocking(false);

        socketChannel.connect(new InetSocketAddress(host, port));

        socketChannel.finishConnect();

        started = true;

        System.out.println(socketChannel.isConnected());
    }

    public NioDemoClientHandler(String host, int port) {
        try {
            init(host, port);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }

    }

    public void sned(String message) throws Exception {
        //        socketChannel.register(selector, SelectionKey.OP_WRITE);
        socketChannel.register(selector, SelectionKey.OP_READ);
        byte[] bytes = message.getBytes();
        ByteBuffer buffer = ByteBuffer.allocateDirect(bytes.length);
        buffer.put(bytes);
        buffer.flip();
        socketChannel.write(buffer);
    }

    public void destroy() {
        started = false;
    }

    @Override
    public void run() {
        while (started) {
            try {
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
                        ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
                        SocketChannel sc = ssc.accept();
                        sc.configureBlocking(false);
                        sc.register(selector, SelectionKey.OP_READ);
                    }

                    if (key.isReadable()) {
                        SocketChannel channel = (SocketChannel) key.channel();
                        ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
                        int read = channel.read(buffer);
                        if (read > 0) {
                            buffer.flip();
                            byte[] bytes = new byte[buffer.remaining()];
                            buffer.get(bytes);
                            System.out.println(new String(bytes, "UTF-8"));
                        }

                        sned("hello");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

}
