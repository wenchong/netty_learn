package com.learn.thrift;

import com.learn.thrift.generated.PersonService;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.server.THsHaServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.transport.TNonblockingServerSocket;

public class ThriftServer {
    public static void main(String[] args) throws Exception{

        TNonblockingServerSocket socket = new TNonblockingServerSocket(8899);

        THsHaServer.Args arg = new THsHaServer.Args(socket).minWorkerThreads(2).maxWorkerThreads(4);


        PersonService.Processor<PersonServiceImpl> processor = new PersonService.Processor<>(new PersonServiceImpl());
        arg.protocolFactory(new TCompactProtocol.Factory());
        arg.protocolFactory(new TCompactProtocol.Factory());
        arg.protocolFactory(new TCompactProtocol.Factory());

        TServer server = new THsHaServer(arg);

        System.out.println("thrift server started!");

        server.serve();
    }

}
