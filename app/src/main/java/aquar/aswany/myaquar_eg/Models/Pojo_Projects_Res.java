package aquar.aswany.myaquar_eg.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by aswany on 1/15/19.
 */

public class Pojo_Projects_Res {

    @SerializedName("projects")
    @Expose
    private ArrayList<Pojo_Projects_Obj> projects = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public Pojo_Projects_Res() {
    }

    /**
     *
     * @param projects
     */
    public Pojo_Projects_Res(ArrayList<Pojo_Projects_Obj> projects) {
        super();
        this.projects = projects;
    }

    public ArrayList<Pojo_Projects_Obj> getProjects() {
        return projects;
    }

    public void setProjects(ArrayList<Pojo_Projects_Obj> projects) {
        this.projects = projects;
    }
}
