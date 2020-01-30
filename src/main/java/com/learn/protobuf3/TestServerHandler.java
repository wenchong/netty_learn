package com.learn.protobuf3;

import com.learn.protobuf2.MyDataInfo;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class TestServerHandler extends SimpleChannelInboundHandler<PersonDataInfo.MyMessage> {


    @Override
    protected void channelRead0(ChannelHandlerContext ctx, PersonDataInfo.MyMessage msg) throws Exception {

        PersonDataInfo.MyMessage.DataType dataType = msg.getDataType();

        if(dataType == PersonDataInfo.MyMessage.DataType.PersonType){
            PersonDataInfo.Person person = msg.getPerson();
            System.out.println(person.getAddress());
            System.out.println(person.getAge());
            System.out.println(person.getName());


        }else if(dataType == PersonDataInfo.MyMessage.DataType.Person2Type){
            PersonDataInfo.Person2 person = msg.getPerson2();
            System.out.println(person.getAddress());
            System.out.println(person.getAge());
            System.out.println(person.getName());

        }else if(dataType == PersonDataInfo.MyMessage.DataType.Person3Type){
            PersonDataInfo.Person3 person = msg.getPerson3();
            System.out.println(person.getAddress());
            System.out.println(person.getAge());
            System.out.println(person.getName());

        }


    }
}
