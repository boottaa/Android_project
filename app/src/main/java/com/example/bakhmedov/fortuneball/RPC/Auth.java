package com.example.bakhmedov.fortuneball.RPC;

import android.content.Context;
import android.util.Log;

import com.example.bakhmedov.fortuneball.RPCJson;
import com.example.bakhmedov.fortuneball.VolleyCallback;

import org.json.JSONObject;

public class Auth extends RPCJson implements VolleyCallback  {

    //Url for http request
//    @Override
    public String url = "http://billig.ru/auth";

    //Need for case callback
    private String method;


    public void auth(String email, String pass, Context c){
        try {
            JSONObject data = new JSONObject();
            data.put("email", email);
            data.put("password", pass);

            this.method = "auth";
            this.setUrl(this.url);
            this.setContext(c);
            this.data(this.method, data);
            this.callback(this).send();


        }catch (Exception e){
            Log.d("deb", e.getMessage());
        }
    }


    @Override
    public void onSuccess(JSONObject result) {
        if(this.method.equals("auth")) {
            Log.d("deb", "IM WORKING: " + result.toString());
        }
    }
}
