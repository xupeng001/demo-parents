package org.io.demo.netty.broadcast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

import com.alibaba.fastjson.JSON;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.group.ChannelMatcher;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;

public class BroadCastServer {

    public static void main(String[] args) throws Exception {
        new BroadCastServer().init(8080);
    }

    public void init(int port) throws Exception {
        EventLoopGroup boss = new NioEventLoopGroup();
        EventLoopGroup worker = new NioEventLoopGroup();
        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(boss, worker).channel(NioServerSocketChannel.class) // 设置Channel Type
                    .option(ChannelOption.SO_BACKLOG, 1024) // 设置Channel属性
                    .childHandler(new ChannelInitializer<SocketChannel>() {

                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline pipeline = ch.pipeline();
                            pipeline.addLast("frameDecoder", new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE, 0, 4,
                                    0, 4));
                            pipeline.addLast("frameEncoder", new LengthFieldPrepender(4));
                            pipeline.addLast("decoder", new StringDecoder(CharsetUtil.UTF_8));
                            pipeline.addLast("encoder", new StringEncoder(CharsetUtil.UTF_8));
                            pipeline.addLast(new ChildChannelHandler());
                        }
                    });
            ChannelFuture channelFuture = bootstrap.bind(port).sync();
            if (channelFuture.isDone()) {
                System.out.println(String.format("server bind port %s sucess", port));
            }
            Channel channel = channelFuture.channel();
            /** CloseFuture异步方式关闭 */
            channel.closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            boss.shutdownGracefully();
            worker.shutdownGracefully();
        }

    }

    private class ChildChannelHandler extends ChannelInitializer<SocketChannel> {

        @Override
        protected void initChannel(SocketChannel ch) throws Exception {
            ch.pipeline().addLast(new LineBasedFrameDecoder(1024));
            ch.pipeline().addLast(new StringDecoder());
            ch.pipeline().addLast(new dataHandler());
        }
    }

    private class dataHandler extends ChannelHandlerAdapter {

        private SimpleDateFormat SDF      = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        private AtomicInteger    response = new AtomicInteger();

        @Override
        public void channelActive(ChannelHandlerContext ctx) throws Exception {
            Channel ch = ctx.channel();
            if (ChannelGroups.size() > 0) {
                ChannelGroups.broadcast(
                        JSON.toJSON(ch.remoteAddress().toString().substring(1) + SDF.format(new Date())),
                        new ChannelMatchers());
            }
            ChannelGroups.add(ch);
        }

        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            Channel ch = ctx.channel();
            if (ChannelGroups.contains(ch) && String.valueOf(msg).equals("welcome")) {
                System.out.println(String.format("receive [%s] from [%s] at [%s]", String.valueOf(msg), ch
                        .remoteAddress().toString().substring(1), SDF.format(new Date())));
                response.incrementAndGet();
            }
            synchronized (response) {
                System.out.println(response.get() + "\t" + ChannelGroups.size());
                if (response.get() == ChannelGroups.size() - 1) {
                    System.out.println("server close all connected channel");
                    ChannelGroups.disconnect();
                    response.set(0);
                }
            }
        }

        @Override
        public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
            ctx.flush();
        }

        @Override
        public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
            ctx.close();
        }

        @Override
        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
            cause.printStackTrace();
            ChannelGroups.discard(ctx.channel());
            response.decrementAndGet();
        }

    }

    public class ChannelMatchers implements ChannelMatcher {

        @Override
        public boolean matches(Channel channel) {
            return true;
        }

    }
}
