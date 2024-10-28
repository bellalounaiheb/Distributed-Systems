package calculatorServer;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CalculatorServer {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("Calculation", new CalculatorImpl());
            System.out.println("Server ready for operation");
        } catch (RemoteException e) {
            System.out.println("Server not ready" + e);
        }
    }    
}
