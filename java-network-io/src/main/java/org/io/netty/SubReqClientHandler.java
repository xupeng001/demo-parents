package org.io.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.buffer.Unpooled;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerAdapter;

/**
 * 类TimeClientHandler.java的实现描述：TODO 类实现描述
 * 
 * @author xupeng 2017年10月16日 下午5:25:59
 */
public class SubReqClientHandler extends ChannelHandlerAdapter {
    private int    counter;

    private byte[] req;

    public SubReqClientHandler() {
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        //        ByteBuf message = null;
        //        for (int i = 0; i < 100; i++) {
        //            message = Unpooled.buffer(req.length);
        //            message.writeBytes(req);
        //            ctx.writeAndFlush(message);
        //        }
        SubscribeReq req = new SubscribeReq();
        req.setName("测试玩玩");
        req.setDesp("简单说明");
        ctx.write(req);
        ctx.flush();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("  client receive msg : " + msg);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
