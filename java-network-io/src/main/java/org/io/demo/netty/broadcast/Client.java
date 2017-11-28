package org.io.demo.netty.broadcast;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import io.netty.channel.ChannelHandlerAdapter;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;

public class Client {

    private static final String          host = "127.0.0.1";

    private static final int             port = 8080;

    private static final ExecutorService es   = Executors.newFixedThreadPool(5);

    public static void start() {
        for (int i = 0; i < 5; i++) {
            es.execute(new Task());
        }
        es.shutdown();
    }

    public static class Task implements Runnable {

        @Override
        public void run() {
            EventLoopGroup group = new NioEventLoopGroup();
            try {
                Bootstrap bootstrap = new Bootstrap();
                bootstrap.group(group).channel(NioSocketChannel.class).option(ChannelOption.TCP_NODELAY, true)
                        .handler(new ChannelInitializer<SocketChannel>() {

                            @Override
                            protected void initChannel(SocketChannel ch) throws Exception {
                                ChannelPipeline pipeline = ch.pipeline();
                                pipeline.addLast("frameDecoder", new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE, 0,
                                        4, 0, 4));
                                pipeline.addLast("frameEncoder", new LengthFieldPrepender(4));
                                pipeline.addLast("decoder", new StringDecoder(CharsetUtil.UTF_8));
                                pipeline.addLast("encoder", new StringEncoder(CharsetUtil.UTF_8));
                                pipeline.addLast(new SimpleClientChannelHandler());
                            }

                        });
                ChannelFuture channelFuture = bootstrap.connect(host, port).sync();
                if (channelFuture.isSuccess()) {
                    System.out.println(String.format("connect server(%s:%s) sucess", host, port));
                }
                channelFuture.channel().closeFuture().sync();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                group.shutdownGracefully();
            }
        }

    }

    public static void main(String[] args) {
        Client.start();
    }
}

class SimpleClientChannelHandler extends ChannelHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        Channel channel = ctx.channel();
        System.out.println(String.format("client(%s) receive message [%s]", channel.localAddress().toString()
                .substring(1), String.valueOf(msg)));
        System.out.println();
        ctx.writeAndFlush(String.valueOf("welcome"));
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        ctx.disconnect(ctx.newPromise());
        ctx.close();
        System.out.println(String.format("client(%s) close sucess", ctx.channel().localAddress().toString()
                .substring(1)));
    }
}
