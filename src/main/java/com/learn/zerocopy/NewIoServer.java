package com.learn.zerocopy;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class NewIoServer {

    public static void main(String[] args) throws Exception {
        InetSocketAddress address = new InetSocketAddress("localhost",8899);

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        ServerSocket socket = serverSocketChannel.socket();
        socket.bind(address);
        socket.setReuseAddress(true);

        ByteBuffer byteBuffer = ByteBuffer.allocate(4096);

        while (true){
            SocketChannel socketChannel = serverSocketChannel.accept();

            socketChannel.configureBlocking(true);
            int readConunt = 0;

            while (-1 != readConunt){
                try{
                    readConunt = socketChannel.read(byteBuffer);

                }catch (Exception ex){
                    ex.printStackTrace();
                }

                byteBuffer.rewind();

            }


        }

    }
}
