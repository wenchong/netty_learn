package com.learn.thrift;

import com.learn.thrift.generated.Person;
import com.learn.thrift.generated.PersonService;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

public class ThriftClient  {

    public static void main(String[] args) {
        TTransport transport = new TFramedTransport(new TSocket("localhost",8899),60);
        TProtocol protocol = new TCompactProtocol(transport);
        PersonService.Client client = new PersonService.Client(protocol);
        try {
            transport.open();
            Person person = client.getPersonByUsername("test");

            System.out.println(person.getAge());
            System.out.println(person.isMarried());
            System.out.println(person.getUsername());

            System.out.println("---------------");

            Person person2 = new Person();
            person2.setMarried(true).setUsername("test2").setAge(100);
            client.savePerson(person2);

        }catch (Exception ex){
            throw new RuntimeException(ex.getMessage());
//            ex.printStackTrace();
        }finally {
            transport.close();
        }


    }

}
