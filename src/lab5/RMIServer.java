package lab5;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class RMIServer {
    public static void main(String[] args) throws RemoteException {
        LocateRegistry.createRegistry(1099);
        while (true) ;
    }
}
