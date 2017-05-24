package ua.init.team.myapplication.retrofit_models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by dev on 16.05.17.
 */

public class FootballData implements Serializable {

    @SerializedName("_links")
    private LinksObject linksObject;

    @SerializedName("count")
    private int anInt;


    public LinksObject getLinksObject() {
        return linksObject;
    }

    public void setLinksObject(LinksObject linksObject) {
        this.linksObject = linksObject;
    }

    public int getAnInt() {
        return anInt;
    }

    public void setAnInt(int anInt) {
        this.anInt = anInt;
    }
}
