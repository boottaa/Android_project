package com.example.bakhmedov.fortuneball.Controller;

import android.content.Context;
import android.util.Log;

import com.example.bakhmedov.fortuneball.Controller.RPC.Base;
import com.example.bakhmedov.fortuneball.Controller.RPC.VolleyCallback;

import org.json.JSONObject;

public class Auth extends Base implements VolleyCallback  {

    //Url for http request
    public Auth(Context c){
        super.c = c;
        super.url = "http://billig.ru/auth";
    }

    //Need for case callback
    private String method;


    public void auth(String email, String pass){
        try {
            JSONObject data = new JSONObject();
            data.put("email", email);
            data.put("password", pass);

            this.method = "auth";

            this.data(this.method, data);
            this.callback(this).send();


        }catch (Exception e){
            Log.d("deb", e.getMessage());
        }
    }

    public void registration(String fname, String lname, String email, String pass){
        try {

            JSONObject data = new JSONObject();
            data.put("fname", email);
            data.put("lname", pass);
            data.put("email", email);
            data.put("password", pass);

            JSONObject objectData = new JSONObject();
            objectData.put("data", data);

            this.method = "registration";

            this.data(this.method, objectData);
            this.callback(this).send();

        }catch (Exception e){
            Log.d("deb", e.getMessage());
        }
    }


    @Override
    public void onSuccess(JSONObject result) {
        if (this.method.equals("auth")) {
            Log.d("deb", "IM WORKING: " + result.toString());
        } else if (this.method.equals("registration")) {
            Log.d("deb", "IM REGISTRATION: " + result.toString());
        }
        //и тд
    }
}
