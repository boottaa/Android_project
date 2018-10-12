package com.example.bakhmedov.fortuneball;

import android.util.Log;

import org.json.JSONObject;

public class Auth implements VolleyCallback {
    @Override
    public void onSuccessResponse(JSONObject result) {
        Log.d("deb", "IM WORKING: " + result.toString());
    }
}
