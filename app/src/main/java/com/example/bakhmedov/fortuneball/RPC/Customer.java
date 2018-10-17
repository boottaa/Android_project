package com.example.bakhmedov.fortuneball.RPC;

import android.content.Context;

import com.example.bakhmedov.fortuneball.RPC.Base.Base;
import com.example.bakhmedov.fortuneball.RPC.Base.VolleyCallback;

import org.json.JSONObject;
//Заказчик
public class Customer extends Base implements VolleyCallback {

    //Url for http request
    public Customer(Context c){
        super.c = c;
        Base.url = "http://billig.ru/auth";
    }

    @Override
    public void onSuccess(JSONObject result) {

    }

}
