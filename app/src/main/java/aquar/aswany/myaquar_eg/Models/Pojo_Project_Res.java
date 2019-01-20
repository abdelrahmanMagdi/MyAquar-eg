package aquar.aswany.myaquar_eg.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by aswany on 1/19/19.
 */

public class Pojo_Project_Res {
    @SerializedName("project")
    @Expose
    private ArrayList<Pojo_Project_Obj> project = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public Pojo_Project_Res() {
    }

    /**
     *
     * @param project
     */
    public Pojo_Project_Res(ArrayList<Pojo_Project_Obj> project) {
        super();
        this.project = project;
    }

    public ArrayList<Pojo_Project_Obj> getProject() {
        return project;
    }

    public void setProject(ArrayList<Pojo_Project_Obj> project) {
        this.project = project;
    }
}
