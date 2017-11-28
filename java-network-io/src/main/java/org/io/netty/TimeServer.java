package org.io.netty;

import io.netty.handler.codec.string.StringDecoder;

import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.EventLoopGroup;

/**
 * 类TimeServer.java的实现描述：TODO 类实现描述
 * 
 * @author xupeng 2017年10月16日 下午4:52:39
 */
public class TimeServer {

    public void bind(int port) throws Exception {
        /**
         * 配置服务器端NIO线程组
         */
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workGroup = new NioEventLoopGroup();

        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workGroup).channel(NioServerSocketChannel.class).option(ChannelOption.SO_BACKLOG, 1024)
                    .childHandler(new childChannelHandler());
            /**
             * 绑定端口，同步等待成功
             */
            ChannelFuture f = b.bind(port).sync();

            /**
             * 等待服务器端监听端口关闭
             */
            f.channel().closeFuture().sync();

        } catch (Exception e) {

        } finally {
            //优雅的退出，释放资源
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }

    }

    private class childChannelHandler extends ChannelInitializer<SocketChannel> {

        @Override
        protected void initChannel(SocketChannel arg0) throws Exception {

            arg0.pipeline().addLast(new LineBasedFrameDecoder(1024));
            arg0.pipeline().addLast(new StringDecoder());
            arg0.pipeline().addLast(new TimeServerHandler());
        }
    }

    public static void main(String[] args) throws Exception {

        int port = 10002;
        if (args != null && args.length > 0) {
            try {
                port = Integer.valueOf(args[0]);
            } catch (NumberFormatException e) {
                //使用默认值
            }
        }
        new TimeServer().bind(port);
    }
}
