package aquar.aswany.myaquar_eg.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by aswany on 1/15/19.
 */

public class Pojo_Projects_Obj {
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("img")
    @Expose
    private String img;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("categories")
    @Expose
    private ArrayList<Pojo_Projects_Category_Obj> categories = null;

    /**
     * No args constructor for use in serialization
     */
    public Pojo_Projects_Obj() {
    }

    /**
     * @param id
     * @param description
     * @param name
     * @param img
     * @param categories
     */
    public Pojo_Projects_Obj(int id, String name, String img, String description, ArrayList<Pojo_Projects_Category_Obj> categories) {
        super();
        this.id = id;
        this.name = name;
        this.img = img;
        this.description = description;
        this.categories = categories;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Pojo_Projects_Category_Obj> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<Pojo_Projects_Category_Obj> categories) {
        this.categories = categories;
    }
}
