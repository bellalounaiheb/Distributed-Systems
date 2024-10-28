package calculatorServer;

import calculatorInterface.Calculator;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CalculatorImpl extends UnicastRemoteObject implements Calculator {

    protected CalculatorImpl() throws RemoteException {
    }

    @Override
    public int plus(int firstNumber, int secondNumber) throws RemoteException {
        return firstNumber + secondNumber;
    }

    @Override
    public int minus(int firstNumber, int secondNumber) throws RemoteException {
        return firstNumber - secondNumber;
    }

    @Override
    public int multiply(int firstNumber, int secondNumber) throws RemoteException {
        return firstNumber * secondNumber;
    }

    @Override
    public int divide(int firstNumber, int secondNumber) throws RemoteException {
        if(secondNumber != 0)
            return firstNumber/secondNumber;
        else throw new RemoteException("Error: Diving by zero is not allowed") ;
    }
}
