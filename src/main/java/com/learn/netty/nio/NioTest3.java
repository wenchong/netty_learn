package com.learn.netty.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioTest3 {

    public static void main(String[] args)  throws  Exception{

        FileOutputStream fileInputStream = new FileOutputStream(("NioTest3.txt"));

        FileChannel fileChannel = fileInputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(512);

        byte[] messages = "hello world welcome ,nihao".getBytes();

        for (int i = 0;i < messages.length;++i){
            byteBuffer.put(messages[i]);

        }
        byteBuffer.flip();
        fileChannel.write(byteBuffer);


    }

}
