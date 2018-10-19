package com.example.bakhmedov.fortuneball.RPC.Base;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class Base {

    //Context
    protected Context c;
    //URL for request
    protected static String url;

    private JSONObject data;

    //Counter request
    private Integer id = 1;

    private JsonObjectRequest jsonObject;

    public void data(String method, JSONObject data){

        try {
            JSONObject params = new JSONObject();
            params.put("data", data);

            JSONObject p = new JSONObject();
            p.put("method", method);
            p.put("id", this.id++);
            p.put("params", params);

            this.data = p;

        }catch (Exception e){
            Log.d("deb", e.getMessage());
        }
    }

    protected Base callback(final VolleyCallback callback){
          this.jsonObject = new JsonObjectRequest
                (Request.Method.POST, Base.url, this.data, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        callback.onSuccess(response);
                        Log.d("deb", "Response: " + response.toString());
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Log.d("deb", "ERROR: " + error.getMessage());
                        // TODO: Handle error

                    }
                });
        return this;
    }

    protected void setActivity(Class $class){
        Intent intent = new Intent(this.c, $class);
        this.c.startActivity(intent);
    }

    public void send(){
        RequestQueue queue = Volley.newRequestQueue(this.c);
        queue.add(this.jsonObject);
    }

    public JSONObject getData(){
        return this.data;
    }
}
