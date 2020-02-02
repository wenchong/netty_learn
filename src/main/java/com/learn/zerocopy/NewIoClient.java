package com.learn.zerocopy;

import java.io.FileInputStream;
import java.net.InetSocketAddress;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

public class NewIoClient {

    public static void main(String[] args)throws Exception {

        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("localhost",8899));
        socketChannel.configureBlocking(true);

        String fileName = "/Users/wenchong/Documents/879a54f4446ea001824095d46f1420a0.xlsx";
        FileChannel fileChannel = new FileInputStream(fileName).getChannel();

        long start = System.currentTimeMillis();
        long transferCount = fileChannel.transferTo(0,fileChannel.size(),socketChannel);

        System.out.println("耗时： " + (System.currentTimeMillis()-start));
        fileChannel.close();
    }

}
