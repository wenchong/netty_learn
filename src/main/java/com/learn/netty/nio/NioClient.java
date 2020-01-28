package com.learn.netty.nio;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NioClient {

    public static void main(String[] args) throws Exception{

        try{
            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(false);

            Selector selector = Selector.open();
            socketChannel.register(selector, SelectionKey.OP_CONNECT);
            socketChannel.connect(new InetSocketAddress("127.0.0.1",8899));

            while(true){
                selector.select();
                Set<SelectionKey> keySet = selector.selectedKeys();
                for (SelectionKey selectionKey : keySet){
                    if(selectionKey.isConnectable()){
                        SocketChannel client = (SocketChannel)selectionKey.channel();

                        if(client.isConnectionPending()){
                            client.finishConnect();
                            ByteBuffer writeBuffer = ByteBuffer.allocate(1024);
                            writeBuffer.put((LocalDateTime.now() + "链接成功！").getBytes());

                            writeBuffer.flip();
                            client.write(writeBuffer);

                            ExecutorService executorServicev= Executors.newSingleThreadExecutor(Executors.defaultThreadFactory());
                            executorServicev.submit(() -> {

                                while (true){
                                    try {
                                        writeBuffer.clear();
                                        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
                                        BufferedReader br = new BufferedReader(inputStreamReader);
                                        String sendMessage = br.readLine();
                                        writeBuffer.put(sendMessage.getBytes());
                                        writeBuffer.flip();
                                        client.write(writeBuffer);//写给服务端

                                    }catch (Exception ex){
                                        ex.printStackTrace();
                                    }

                                }

                            });

                        }

                        client.register(selector,SelectionKey.OP_READ);

                    }else if (selectionKey.isReadable()){
                        SocketChannel client = (SocketChannel)selectionKey.channel();
                        ByteBuffer readbuffer = ByteBuffer.allocate(1024);
                        int count = client.read(readbuffer);//从服务端读下来

                        if(count > 0){
                            String msg = new String(readbuffer.array(),0,count);

                            System.out.println(msg);


                        }

                    }


                }
                keySet.clear();

            }





        }catch (Exception ex){
            ex.printStackTrace();
        }



    }

}
