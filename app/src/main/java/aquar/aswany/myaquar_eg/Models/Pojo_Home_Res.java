package aquar.aswany.myaquar_eg.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by aswany on 1/15/19.
 */

public class Pojo_Home_Res {


    @SerializedName("developers")
    @Expose
    private ArrayList<Pojo_Home_Obj> developers = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public Pojo_Home_Res() {
    }

    /**
     *
     * @param developers
     */
    public Pojo_Home_Res(ArrayList<Pojo_Home_Obj> developers) {
        super();
        this.developers = developers;
    }

    public ArrayList<Pojo_Home_Obj> getDevelopers() {
        return developers;
    }

    public void setDevelopers(ArrayList<Pojo_Home_Obj> developers) {
        this.developers = developers;
    }



}
