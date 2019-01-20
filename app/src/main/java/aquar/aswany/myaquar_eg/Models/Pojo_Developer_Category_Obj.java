package aquar.aswany.myaquar_eg.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by aswany on 1/19/19.
 */

public class Pojo_Developer_Category_Obj {

    @SerializedName("product_id")
    @Expose
    private int productId;
    @SerializedName("category_id")
    @Expose
    private int categoryId;
    @SerializedName("category_name")
    @Expose
    private String categoryName;
    @SerializedName("developer_id")
    @Expose
    private int developerId;
    @SerializedName("developer_name")
    @Expose
    private String developerName;
    @SerializedName("project_img")
    @Expose
    private String projectImg;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("project_name")
    @Expose
    private String projectName;

    /**
     * No args constructor for use in serialization
     *
     */
    public Pojo_Developer_Category_Obj() {
    }

    /**
     *
     * @param categoryName
     * @param developerId
     * @param location
     * @param description
     * @param projectImg
     * @param categoryId
     * @param developerName
     * @param projectName
     * @param productId
     */
    public Pojo_Developer_Category_Obj(int productId, int categoryId, String categoryName, int developerId, String developerName, String projectImg, String description, String location, String projectName) {
        super();
        this.productId = productId;
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.developerId = developerId;
        this.developerName = developerName;
        this.projectImg = projectImg;
        this.description = description;
        this.location = location;
        this.projectName = projectName;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
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
    }

    public int getDeveloperId() {
        return developerId;
    }

    public void setDeveloperId(int developerId) {
        this.developerId = developerId;
    }

    public String getDeveloperName() {
        return developerName;
    }

    public void setDeveloperName(String developerName) {
        this.developerName = developerName;
    }

    public String getProjectImg() {
        return projectImg;
    }

    public void setProjectImg(String projectImg) {
        this.projectImg = projectImg;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
}
