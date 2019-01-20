package aquar.aswany.myaquar_eg.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by aswany on 1/16/19.
 */

public class Pojo_Projects_Category_Obj {
    @SerializedName("category_Id")
    @Expose
    private int categoryId;
    @SerializedName("category_Name")
    @Expose
    private String categoryName;

    /**
     * No args constructor for use in serialization
     *
     */
    public Pojo_Projects_Category_Obj() {
    }

    /**
     *
     * @param categoryName
     * @param categoryId
     */
    public Pojo_Projects_Category_Obj(int categoryId, String categoryName) {
        super();
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }}
