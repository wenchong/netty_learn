package com.learn.zerocopy;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.Socket;

public class OIdIoClient {

    public static void main(String[] args) throws Exception{

        Socket socket = new Socket("localhost",8899);

        long start = System.currentTimeMillis();
        String fileName = "/Users/wenchong/Documents/879a54f4446ea001824095d46f1420a0.xlsx";
        InputStream inputStream = new FileInputStream(fileName);

        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

        byte[] buffer = new byte[4096];
        long readCount = 0;
        long total = 0;

        while((readCount = inputStream.read(buffer)) >= 0){
            total += readCount;
            dataOutputStream.write(buffer);
        }

        long end = System.currentTimeMillis();
        System.out.println("耗时 " + (end - start));

        dataOutputStream.close();
        inputStream.close();
        socket.close();


    }
}
