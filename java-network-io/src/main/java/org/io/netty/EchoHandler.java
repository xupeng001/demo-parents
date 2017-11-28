package org.io.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelHandlerAdapter;

/**
 * 类TimeClientHandler.java的实现描述：TODO 类实现描述
 * 
 * @author xupeng 2017年10月16日 下午5:25:59
 */
public class EchoHandler extends ChannelHandlerAdapter {

    public EchoHandler() {
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("receive client msg : [" + msg + "]");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
