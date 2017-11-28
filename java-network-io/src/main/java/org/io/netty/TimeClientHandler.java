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
public class TimeClientHandler extends ChannelHandlerAdapter {
    private int    counter;

    //    private final ByteBuf firstmessage;

    //    private ByteBuf buf;

    private byte[] req;

    public TimeClientHandler() {
        req = ("QUERY TIME ORDER" + System.getProperty("line.separator")).getBytes();
        //        firstmessage = Unpooled.buffer(req.length);
        //        firstmessage.writeBytes(req);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ByteBuf message = null;
        for (int i = 0; i < 100; i++) {
            message = Unpooled.buffer(req.length);
            message.writeBytes(req);
            ctx.writeAndFlush(message);
        }
        //        ctx.writeAndFlush(firstmessage);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        
        String body=(String) msg;
        
//        ByteBuf buf = (ByteBuf) msg;
//        byte[] req = new byte[buf.readableBytes()];
//        buf.readBytes(req);
//        String body = new String(req, "UTF-8");
        System.out.println("now is " + body + " ; the counter is :" + ++counter);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
