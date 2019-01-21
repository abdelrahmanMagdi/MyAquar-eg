package aquar.aswany.myaquar_eg.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by aswany on 1/21/19.
 */

public class Pojo_S_Budget_Obj {
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("img")
    @Expose
    private String img;
    @SerializedName("rooms")
    @Expose
    private int rooms;
    @SerializedName("bathsrooms")
    @Expose
    private int bathroom;
    @SerializedName("price")
    @Expose
    private int price;
    @SerializedName("area")
    @Expose
    private int area;
    @SerializedName("accommodation")
    @Expose
    private String accommodation;
    @SerializedName("video")
    @Expose
    private String video;
    @SerializedName("viewer_360")
    @Expose
    private String viewer360;
    @SerializedName("description")
    @Expose
    private String description;

    /**
     * No args constructor for use in serialization
     *
     */
    public Pojo_S_Budget_Obj() {
    }

    /**
     *
     * @param id
     * @param area
     * @param price
     * @param accommodation
     * @param description
     * @param viewer360
     * @param name
     * @param img
     * @param bathsrooms
     * @param type
     * @param video
     * @param rooms
     */
    public Pojo_S_Budget_Obj(int id, String name, String type, String img, int rooms,
                             int bathsrooms, int price, int area, String accommodation,
                             String video, String viewer360, String description) {
        super();
        this.id = id;
        this.name = name;
        this.type = type;
        this.img = img;
        this.rooms = rooms;
        this.bathroom = bathsrooms;
        this.price = price;
        this.area = area;
        this.accommodation = accommodation;
        this.video = video;
        this.viewer360 = viewer360;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public long getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public int getBathsrooms() {
        return bathroom;
    }

    public void setBathsrooms(int bathsrooms) {
        this.bathroom = bathsrooms;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public long getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public Object getAccommodation() {
        return accommodation;
    }

    public void setAccommodation(String accommodation) {
        this.accommodation = accommodation;
    }

    public Object getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getViewer360() {
        return viewer360;
    }

    public void setViewer360(String viewer360) {
        this.viewer360 = viewer360;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
