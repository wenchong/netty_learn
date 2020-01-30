package com.learn.protobuf;

public class ProtoBufTest {

    public static void main(String[] args) throws Exception{

        DataInfo.Student student = DataInfo.Student.newBuilder().setAddress("中国铁建").
                setAge(20).setName("wenchong").build();
        byte[] student2ByteArray = student.toByteArray();


        DataInfo.Student student2 = DataInfo.Student.parseFrom(student2ByteArray);

        System.out.println(student2.getName());
        System.out.println(student2.getAddress());
        System.out.println(student2.getAge());
    }

}
