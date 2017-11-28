package org.io.demo.netty;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;

import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.bootstrap.Bootstrap;

public class NettyClientProcessor {

    public static void main(String[] args) throws Exception {
        new NettyClientProcessor().init();
    }

    public void init() throws Exception {
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(1);
        EventLoopGroup bossGroup = new NioEventLoopGroup(2, newFixedThreadPool);
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(bossGroup).channel(NioSocketChannel.class).option(ChannelOption.TCP_NODELAY, true)
                .handler(new ChildChannelHandler());

        ChannelFuture f = bootstrap.connect("127.0.0.1", 10000).sync();

        f.channel().closeFuture().sync();

    }

    private class ChildChannelHandler extends ChannelInitializer<SocketChannel> {

        @Override
        protected void initChannel(SocketChannel ch) throws Exception {
            ObjectDecoder decoder = new ObjectDecoder(ClassResolvers.cacheDisabled(null));
            ObjectEncoder encoder = new ObjectEncoder();
            ch.pipeline().addLast(new LineBasedFrameDecoder(1024));
      ch.pipeline().addLast(new StringDecoder());
            ch.pipeline().addLast(decoder, new ChildHandler(), encoder);
        }

    }

    private class ChildHandler extends ChannelHandlerAdapter {
        @Override
        public void channelActive(ChannelHandlerContext ctx) throws Exception {
            System.out.println("----------channelActive------------");
            Message message = new Message("NettyClientProcessor");
            ctx.channel().writeAndFlush(message);
        }

        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            System.out.println("----------channelRead------------");
            if ("hello".equals(msg)) {
                System.out.println(msg);
            }
        }

        @Override
        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
            System.out.println("----------exceptionCaught------------");
            ctx.close();
        }

    }
}
