package com.learn.thrift;

import com.learn.thrift.generated.DataException;
import com.learn.thrift.generated.Person;
import com.learn.thrift.generated.PersonService;

public class PersonServiceImpl implements PersonService.Iface {
    @Override
    public Person getPersonByUsername(String username) throws DataException, org.apache.thrift.TException {
        System.out.println("got cietn param : " + username);

        Person person = new Person();
        person.setAge(10).setUsername("test").setMarried(false);


        return person;
    }

    @Override
    public void savePerson(Person person) throws DataException, org.apache.thrift.TException {

        System.out.println("got Client param:");

        System.out.println(person.getUsername());
        System.out.println(person.getAge());
        System.out.println(person.isMarried());
    }
}
