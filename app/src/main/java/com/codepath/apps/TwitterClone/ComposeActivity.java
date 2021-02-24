package com.codepath.apps.TwitterClone;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.codepath.apps.TwitterClone.models.Tweet;
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler;

import org.json.JSONException;
import org.parceler.Parcels;

import okhttp3.Headers;

public class ComposeActivity extends AppCompatActivity {

    private static final int MAX_TWEET_LENGTH = 280;
    private static final String TAG = "ComposeActivity";
    TwitterClient client;
    EditText etCompose;
    Button btnTweet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compose);

        etCompose = findViewById(R.id.etCompose);
        btnTweet =  findViewById(R.id.btnTweet);
        client = TwitterApplication.getRestClient(this);

        btnTweet.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String tweetContent = etCompose.getText().toString();
                if(tweetContent.isEmpty())
                    Toast.makeText(ComposeActivity.this, "Your tweet can not be empty", Toast.LENGTH_LONG).show();
                else if(tweetContent.length() > MAX_TWEET_LENGTH)
                    Toast.makeText(ComposeActivity.this, "Your tweet is too long", Toast.LENGTH_LONG).show();
                else
                    client.publishTweet(tweetContent, new JsonHttpResponseHandler() {
                        @Override
                        public void onSuccess(int statusCode, Headers headers, JSON json) {
                            Log.i(TAG, "published tweet");
                            try {
                                Tweet tweet = new Tweet(json.jsonObject);
                                Intent i = new Intent();
                                i.putExtra("tweet", Parcels.wrap(tweet));
                                setResult(RESULT_OK, i);
                                finish();
                            } catch (JSONException e) {
                                Log.e(TAG, "Tweet model update error", e);
                            }
                        }

                        @Override
                        public void onFailure(int statusCode, Headers headers, String response, Throwable throwable) {
                            Log.e(TAG, "Failed to send tweet" + response, throwable);
                        }
                    });
            }
        });
    }
}