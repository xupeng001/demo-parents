package org.io.bio.server;

import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.Future;

public class AioServer {

    private static int DEFAULT_PORT = 100002;

    public static void main(String[] args) throws Exception {
        AsynchronousServerSocketChannel channel = AsynchronousServerSocketChannel.open();
        channel.bind(new InetSocketAddress(DEFAULT_PORT));
        //        Future<AsynchronousSocketChannel> accept = channel.accept();
        //        channel.accept(null, new CompletionHandler<AsynchronousSocketChannel, A>() {
        //        });
    }

}
