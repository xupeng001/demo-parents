package org.io.demo.netty;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;
import io.netty.handler.codec.string.StringDecoder;

public class NettyServer {

    static final List<Channel> channels = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        new NettyServer().init();
    }

    public void init() throws Exception {
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(1);
        EventLoopGroup bossGroup = new NioEventLoopGroup(1, newFixedThreadPool);
        ServerBootstrap bootstrap = new ServerBootstrap();
        bootstrap.group(bossGroup).channel(NioServerSocketChannel.class).option(ChannelOption.SO_BACKLOG, 1024)
                .childHandler(new ChildChannelHandler());

        new Thread(new SendTask()).start();
        /**
         * 绑定端口，同步等待成功
         */
        ChannelFuture f = bootstrap.bind(10000).sync();

        /**
         * 等待服务器端监听端口关闭
         */
        f.channel().closeFuture().sync();

    }

    public class SendTask implements Runnable {

        @Override
        public void run() {
            try {
                while (true) {
                    System.out.println(channels.size());
                    Thread.sleep(10000);
                    for (Channel channel : channels) {

                        send(channel);

                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void send(Channel channel) throws Exception {
        String string = "hello" + System.getProperty("line.separator");
        byte[] req = string.getBytes();
        ByteBuf message = null;
        message = Unpooled.buffer(req.length);
        message.writeBytes(req);
        channel.writeAndFlush(message);
        string = "end" + System.getProperty("line.separator");
        req = string.getBytes();
        message = null;
        message = Unpooled.buffer(req.length);
        message.writeBytes(req);
        channel.writeAndFlush(message);
        System.out.println("sneding . . .");
    }

    private class ChildChannelHandler extends ChannelInitializer<SocketChannel> {

        @Override
        protected void initChannel(SocketChannel ch) throws Exception {
            ObjectDecoder decoder = new ObjectDecoder(ClassResolvers.cacheDisabled(null));
            ObjectEncoder encoder = new ObjectEncoder();
            ch.pipeline().addLast(new LineBasedFrameDecoder(1024));
            ch.pipeline().addLast(new StringDecoder());
            ch.pipeline().addLast(decoder, new dataHandler(), encoder);
        }
    }

    private class dataHandler extends ChannelHandlerAdapter {

        @Override
        public void channelActive(ChannelHandlerContext ctx) throws Exception {
            System.out.println("-------channelActive-------");
            channels.add(ctx.channel());
        }

        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            System.out.println("-------channelRead-------");

        }

        @Override
        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
            System.out.println("-------exceptionCaught-------");
            ctx.close();
        }

        @Override
        public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
            System.out.println("-------channelReadComplete-------");
            ctx.flush();
        }
    }
}
