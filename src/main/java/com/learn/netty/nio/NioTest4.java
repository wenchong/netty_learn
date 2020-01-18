package com.learn.netty.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioTest4 {

    public static void main(String[] args) throws Exception{
        FileInputStream inputStream = new FileInputStream("input.txt");
        FileOutputStream outputStream = new FileOutputStream("output.txt");

        FileChannel inputChannel = inputStream.getChannel();
        FileChannel outputChannel = outputStream.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(4);

        while(true){
            //如果注释掉这行代码 会出现什么情况
//            buffer.clear();

            int read = inputChannel.read(buffer);
            System.out.println("read  >>>   " + read);

            if(-1 == read){
                break;
            }

            buffer.flip();
            outputChannel.write(buffer);

        }

        inputChannel.close();;
        outputChannel.close();


    }
}
