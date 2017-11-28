package org.io.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelHandlerAdapter;

/**
 * 类TimeClientHandler.java的实现描述：TODO 类实现描述
 * 
 * @author xupeng 2017年10月16日 下午5:25:59
 */
public class SubReqServerHandler extends ChannelHandlerAdapter {

    public SubReqServerHandler() {
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        SubscribeReq req = (SubscribeReq) msg;
        System.out.println("server  receive msg : " + msg);
        SubscribeResp resp = new SubscribeResp();
        resp.setDesp("缺货");
        resp.setReqId(req.getReqId());
        resp.setName(req.getName());
        ctx.writeAndFlush(resp);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
