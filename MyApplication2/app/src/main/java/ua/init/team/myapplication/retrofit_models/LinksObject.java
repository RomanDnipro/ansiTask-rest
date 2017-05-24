package ua.init.team.myapplication.retrofit_models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by dev on 16.05.17.
 */

public class LinksObject implements Serializable{

    @SerializedName("self")
    private Links2 links1;


    @SerializedName("soccerseason")
    private Links2 links2;


    public Links2 getLinks1() {
        return links1;
    }

    public void setLinks1(Links2 links1) {
        this.links1 = links1;
    }

    public Links2 getLinks2() {
        return links2;
    }

    public void setLinks2(Links2 links2) {
        this.links2 = links2;
    }
}
