package com.learn.protobuf2;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.logging.SocketHandler;

public class TestServerHandler extends SimpleChannelInboundHandler<MyDataInfo.Student> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MyDataInfo.Student msg) throws Exception {

        System.out.println(msg.getAddress());
        System.out.println(msg.getAge());
        System.out.println(msg.getName());
    }
}
