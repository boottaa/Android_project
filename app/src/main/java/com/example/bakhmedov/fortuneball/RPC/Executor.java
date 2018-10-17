package com.example.bakhmedov.fortuneball.RPC;

import android.content.Context;
import android.util.Log;

import com.example.bakhmedov.fortuneball.RPC.Base.Base;
import com.example.bakhmedov.fortuneball.RPC.Base.VolleyCallback;

import org.json.JSONObject;

//Исполнитель может все тоже самое что заказчик
//(например заказать работы + может оформить подписку на интересующие работы)
public class Executor extends Customer implements VolleyCallback  {

    //Url for http request
    public Executor(Context c){
        super(c);
        Base.url = "http://billig.ru/auth";
    }
    //Need for case callback
    private String method;

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
