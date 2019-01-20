package aquar.aswany.myaquar_eg.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by aswany on 1/19/19.
 */

public class Pojo_Project_Obj {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("category")
    @Expose
    private String category;
    @SerializedName("developer")
    @Expose
    private String developer;
    @SerializedName("project")
    @Expose
    private String project;
    @SerializedName("rooms")
    @Expose
    private int rooms;
    @SerializedName("bathsrooms")
    @Expose
    private int bathsrooms;
    @SerializedName("price")
    @Expose
    private int price;
    @SerializedName("area")
    @Expose
    private int area;
    @SerializedName("garden")
    @Expose
    private String garden;
    @SerializedName("accommodation")
    @Expose
    private String accommodation;
    @SerializedName("location")
    @Expose
    private String location;
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
    public Pojo_Project_Obj() {
    }

    /**
     *
     * @param location
     * @param viewer360
     * @param type
     * @param id
     * @param project
     * @param category
     * @param price
     * @param area
     * @param accommodation
     * @param description
     * @param developer
     * @param bathsrooms
     * @param garden
     * @param video
     * @param rooms
     */
    public Pojo_Project_Obj(int id, String type,
                            String category, String developer,
                            String project, int rooms, int bathsrooms,
                            int price, int area, String garden,
                            String accommodation, String location, String video,
                            String viewer360, String description) {
        super();
        this.id = id;
        this.type = type;
        this.category = category;
        this.developer = developer;
        this.project = project;
        this.rooms = rooms;
        this.bathsrooms = bathsrooms;
        this.price = price;
        this.area = area;
        this.garden = garden;
        this.accommodation = accommodation;
        this.location = location;
        this.video = video;
        this.viewer360 = viewer360;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public long getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public long getBathsrooms() {
        return bathsrooms;
    }

    public void setBathsrooms(int bathsrooms) {
        this.bathsrooms = bathsrooms;
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

    public String getGarden() {
        return garden;
    }

    public void setGarden(String garden) {
        this.garden = garden;
    }

    public Object getAccommodation() {
        return accommodation;
    }

    public void setAccommodation(String accommodation) {
        this.accommodation = accommodation;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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
