package aquar.aswany.myaquar_eg.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by aswany on 1/19/19.
 */

public class Pojo_Developer_Category_Res {
    @SerializedName("developers")
    @Expose
    private ArrayList<Pojo_Developer_Category_Obj> developers = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public Pojo_Developer_Category_Res() {
    }

    /**
     *
     * @param developers
     */
    public Pojo_Developer_Category_Res(ArrayList<Pojo_Developer_Category_Obj> developers) {
        super();
        this.developers = developers;
    }

    public ArrayList<Pojo_Developer_Category_Obj> getDevelopers() {
        return developers;
    }

    public void setDevelopers(ArrayList<Pojo_Developer_Category_Obj> developers) {
        this.developers = developers;
    }
}
