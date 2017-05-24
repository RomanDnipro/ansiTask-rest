package ua.init.team.myapplication.retrofit_models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by dev on 16.05.17.
 */

public class Links2 implements Serializable {

    @SerializedName("href")
    private String string;

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }
}
