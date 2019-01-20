package aquar.aswany.myaquar_eg.InternalStorage;

import java.lang.reflect.Array;
import java.util.ArrayList;

import aquar.aswany.myaquar_eg.Models.Pojo_Home_Obj;
import aquar.aswany.myaquar_eg.Models.Pojo_Project_Obj;
import aquar.aswany.myaquar_eg.Models.Pojo_Projects_Category_Obj;

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

    public String getDeveloperID() {
        return DeveloperID;
    }

    public void setDeveloperID(String developerID) {
        DeveloperID = developerID;
    }

    private String DeveloperID;

private int ProductID;

    public int getProductID() {
        return ProductID;
    }

    public void setProductID(int productID) {
        ProductID = productID;
    }

    public ArrayList<Pojo_Home_Obj> getHomeObjs() {
        return homeObjs;
    }

    public void setHomeObjs(ArrayList<Pojo_Home_Obj> homeObjs) {
        this.homeObjs = homeObjs;
    }

    private ArrayList<Pojo_Home_Obj> homeObjs;

    private ArrayList<Pojo_Project_Obj> Products;

    public ArrayList<Pojo_Project_Obj> getProducts() {
        return Products;
    }

    public void setProducts(ArrayList<Pojo_Project_Obj> products) {
        Products = products;
    }
}
