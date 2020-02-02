package com.learn.zerocopy;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class oldServer {

    public static void main(String[] args) throws Exception {
        ServerSocket socket = new ServerSocket(8899);
        while(true){

            Socket socket1 = socket.accept();
            DataInputStream dataInputStream = new DataInputStream(socket1.getInputStream());

            byte[] bytes = new byte[4096];
            while (true){
                int count = dataInputStream.read(bytes,0,bytes.length);
            }



        }


    }
}
