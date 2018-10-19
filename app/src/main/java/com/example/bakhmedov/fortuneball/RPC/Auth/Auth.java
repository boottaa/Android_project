package com.example.bakhmedov.fortuneball.RPC.Auth;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.example.bakhmedov.fortuneball.RPC.Base.Base;
import com.example.bakhmedov.fortuneball.RPC.Base.VolleyCallback;
import com.example.bakhmedov.fortuneball.View.V_Auth;
import com.example.bakhmedov.fortuneball.View.V_Customer;

import org.json.JSONObject;

import java.time.Instant;

public class Auth extends Base implements VolleyCallback  {

    //Need for case callback
    private String method;

    private Session session;

    //Url for http request
    public Auth(Context c){
        super.c = c;
        this.session = new Session(c);
        Base.url = "http://billig.ru/auth";
    }

    public void auth(String email, String pass){
        try {
//          ТАК можно проверить авторизован ли пользователь
//            if(this.session.run().has("hash")){
//                Log.d("deb", "GOOOOOODDDDD");
//
//                return;
//            }

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
            data.put("fname", fname);
            data.put("lname", lname);
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

        switch (this.method){
            case "auth":
                try {
                    if (result.has("result")) {

                        JSONObject r = result.getJSONObject("result");
                        this.session.save(r);
                        this.setActivity(V_Customer.class);

                        Log.d("deb", "GOOD JOB");
                    } else if(result.has("error")) {
                        throw new Exception("Incorrect login or password");
                    }
                } catch (Exception e) {
                    Log.d("deb", "onSuccess err: " + result.toString());
                }
                break;

            case "registration":
                Log.d("deb", "IM REGISTRATION: " + result.toString());
                break;
        }
    }
}
