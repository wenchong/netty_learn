package com.learn.netty.nio;

import io.netty.buffer.ByteBuf;

import java.nio.ByteBuffer;

/***
 * 只读buffer 调用readonly只能得到一个只读buffer
 */
public class NioTest7 {

    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(10);

        for (int i = 0; i < buffer.capacity();i++){
            buffer.put((byte) i);
        }
        ByteBuffer readonlyBuffer = buffer.asReadOnlyBuffer();
        System.out.println(readonlyBuffer.getClass());
        readonlyBuffer.position(0);

//        readonlyBuffer.put((byte)2);
    }

}
