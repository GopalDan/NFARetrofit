package com.example.gopal.nfaretrofit.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Gopal on 7/7/2019.
 */

public class Fields {

    @SerializedName("byline")
    @Expose
    private String byline;
    @SerializedName("thumbnail")
    @Expose
    private String thumbnail;

    public String getByline() {
        return byline;
    }

    public void setByline(String byline) {
        this.byline = byline;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

}
