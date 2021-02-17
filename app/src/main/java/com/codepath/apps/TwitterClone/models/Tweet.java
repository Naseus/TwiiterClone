package com.codepath.apps.TwitterClone.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Tweet {

    private String body;
    private String createdAt;
    private User user;

    public Tweet(JSONObject jsonObject) throws JSONException {
        body = jsonObject.getString("text");
        createdAt = jsonObject.getString("created_at");
        user = new User(jsonObject.getJSONObject("user"));
    }

    public static  List<Tweet> fromJsonArray(JSONArray jsonArray) throws JSONException {
        List<Tweet> tweets = new ArrayList<Tweet>();
        for(int i = 0; i < jsonArray.length(); i++)
            tweets.add(new Tweet(jsonArray.getJSONObject(i)));
        return tweets;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
