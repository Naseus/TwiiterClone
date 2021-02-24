package com.codepath.apps.TwitterClone.models;

import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

@Parcel
public class User {
    private String name;
    private String screenName;
    private String profileImageUrl;

    // Fort parceler
    public User(){}

    public User(JSONObject jsonObject) throws JSONException {
        name = jsonObject.getString("name");
        screenName = jsonObject.getString("screen_name");
        profileImageUrl = jsonObject.getString("profile_image_url_https");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }
}
