package com.learn.protobuf3;

import com.learn.protobuf2.MyDataInfo;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Random;

public class TestClientHandler extends SimpleChannelInboundHandler<PersonDataInfo.MyMessage> {


    @Override
    protected void channelRead0(ChannelHandlerContext ctx, PersonDataInfo.MyMessage msg) throws Exception {

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {

        int randomInt = new Random(3).nextInt();
        PersonDataInfo.MyMessage.Builder myMessage = null;
        if(0 == randomInt){
             myMessage = PersonDataInfo.MyMessage.newBuilder().setDataType(PersonDataInfo.MyMessage.DataType.PersonType).
                    setPerson(PersonDataInfo.Person.newBuilder().setName("张三").setAddress("zhangsan").setAge(3));
        }else if(1 == randomInt){
            myMessage = PersonDataInfo.MyMessage.newBuilder().setDataType(PersonDataInfo.MyMessage.DataType.Person2Type).
                    setPerson2(PersonDataInfo.Person2.newBuilder().setName("张三2").setAddress("zhangsan2").setAge(3));
        }else{
            myMessage = PersonDataInfo.MyMessage.newBuilder().setDataType(PersonDataInfo.MyMessage.DataType.Person3Type).
                    setPerson3(PersonDataInfo.Person3.newBuilder().setName("张三3").setAddress("zhangsan3").setAge(3));
        }

        ctx.writeAndFlush(myMessage);

    }
}
