package com.learn.netty.nio;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;
import java.security.SecureRandom;

public class NioTest2 {

    public static void main(String[] args)  throws  Exception{

        FileInputStream fileInputStream = new FileInputStream(("NioTest2.txt"));

        FileChannel fileChannel = fileInputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(512);
        fileChannel.read(byteBuffer);
        byteBuffer.flip();

        while (byteBuffer.remaining() > 0){
            byte b = byteBuffer.get();
            System.out.println("character: " + (char)b);
        }
        fileInputStream.close();

    }

}
