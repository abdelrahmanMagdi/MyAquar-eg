package aquar.aswany.myaquar_eg.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by aswany on 1/21/19.
 */

public class Pojo_S_Budget_Res {

    @SerializedName("badget")
    @Expose
    private ArrayList<Pojo_S_Budget_Obj> badget = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public Pojo_S_Budget_Res() {
    }

    /**
     *
     * @param badget
     */
    public Pojo_S_Budget_Res(ArrayList<Pojo_S_Budget_Obj> badget) {
        super();
        this.badget = badget;
    }

    public ArrayList<Pojo_S_Budget_Obj> getBadget() {
        return badget;
    }

    public void setBadget(ArrayList<Pojo_S_Budget_Obj> badget) {
        this.badget = badget;
    }
}
