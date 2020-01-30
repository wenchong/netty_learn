package com.learn.protobuf2;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.logging.SocketHandler;

public class TestClientHandler extends SimpleChannelInboundHandler<MyDataInfo.Student> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MyDataInfo.Student msg) throws Exception {




    }


    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        MyDataInfo.Student student = MyDataInfo.Student.newBuilder().
                setAddress("wenhconghouse").setAge(2).setName("wenchong").build();

        ctx.writeAndFlush(student);

    }
}
