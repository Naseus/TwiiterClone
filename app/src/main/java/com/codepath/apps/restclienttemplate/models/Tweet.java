package com.codepath.apps.restclienttemplate.models;

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
        user = new User(jsonObject);
    }

    public static  List<Tweet> fromJsonArray(JSONArray jsonArray) throws JSONException {
        List<Tweet> tweets = new ArrayList<Tweet>();
        for(int i = 0; i < jsonArray.length(); i++)
            tweets.add(new Tweet(jsonArray.getJSONObject(i)));
        return tweets;
    }
}
