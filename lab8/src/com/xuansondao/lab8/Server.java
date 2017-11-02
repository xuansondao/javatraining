package com.xuansondao.lab8;

import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server implements Hello {
    @Override
    public String say(String name) throws RemoteException {
        return "Hello " + name;
    }

    public static void main(String[] args) {
        System.setProperty("java.rmi.server.hostname", "127.0.0.1");
        Object object = new Server();
        try {
            Hello stub = (Hello) UnicastRemoteObject.exportObject((Remote) object, 0);
            Registry registry = LocateRegistry.getRegistry("127.0.0.1",8000);
            registry.bind("Hello", stub);
            System.out.println("Server ready");
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        }

    }
}
