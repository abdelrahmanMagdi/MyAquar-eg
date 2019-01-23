package aquar.aswany.myaquar_eg.InternalStorage;

import java.util.ArrayList;

import aquar.aswany.myaquar_eg.Models.Pojo_Home_Obj;
import aquar.aswany.myaquar_eg.Models.Pojo_Project_Obj;

/**
 * Created by aswany on 1/16/19.
 */

public class Session {

    private static Session instance;


    public static Session getInstance() {
        if (instance == null) {
            instance = new Session();
        }
        return instance;
    }

    private Session() {

    }
    

    private int ProductID;

    public int getProductID() {
        return ProductID;
    }

    public void setProductID(int productID) {
        ProductID = productID;
    }


    private ArrayList<Pojo_Project_Obj> Products;

    public ArrayList<Pojo_Project_Obj> getProducts() {
        return Products;
    }

    public void setProducts(ArrayList<Pojo_Project_Obj> products) {
        Products = products;
    }
}
