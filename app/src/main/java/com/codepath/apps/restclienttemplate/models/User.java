package com.codepath.apps.restclienttemplate.models;

import org.json.JSONException;
import org.json.JSONObject;

public class User {
    private String name;
    private String screenName;
    private String profileImageUrl;

    public User(JSONObject jsonObject) throws JSONException {
        name = jsonObject.getString("name");
        screenName = jsonObject.getString("screen_name");
        profileImageUrl = jsonObject.getString("profile_image_url_https");
    }
}
