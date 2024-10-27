package shopClient;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

import calculatorInterface.Calculator;
import shopInterface.Product;
import shopInterface.ProductInfo;

public class ProductInfoClient {
    private static final String ALL = "all";
    private static final String BOOK = "book";
    private static final String FILM = "film";
    private static final String TITLE = "by title";
    private static final String PERSON = "by person";

    public static List<Product> findProducts(String searchString, String searchCat, String productCat) {
        List<Product> productList = null;

        try {
            ProductInfo product = (ProductInfo) Naming.lookup("Product");
            if(searchCat.equals("book") && productCat.equals("by title")){
                return product.findBooksByTitle(searchString);
            }
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            if (e.getMessage() != null) {
            }
            e.printStackTrace();
        }
        return null;
    }
}
