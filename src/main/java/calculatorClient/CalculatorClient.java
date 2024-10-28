package calculatorClient;

import calculatorInterface.Calculator;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class CalculatorClient {
    public static String compute(int firstNumber, int secondNumber, String operation){
        try {
            Calculator calculator = (Calculator) Naming.lookup("Calculation");
            if (operation.equals("+")){
                return Integer.toString(calculator.plus(firstNumber, secondNumber));
            } else if (operation.equals("/")){
                return Integer.toString(calculator.divide(firstNumber, secondNumber));
            } else if (operation.equals("-")){
                return Integer.toString(calculator.minus(firstNumber, secondNumber));
            } else if (operation.equals("*")){
                return Integer.toString(calculator.multiply(firstNumber, secondNumber));
            }
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return "Error: Unknown error occured";
        } catch (RemoteException e) {
            if (e.getMessage() != null) {
                return e.getCause().getMessage();
            }
            e.printStackTrace();
            return "Error: Unknown error occured";
        }
        return null;
    }
}
