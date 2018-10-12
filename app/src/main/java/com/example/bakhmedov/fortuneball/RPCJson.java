package com.example.bakhmedov.fortuneball;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class RPCJson {

    private JSONObject data;
    //Counter request
    private Integer id = 1;
    //Context
    private Context c;
    //URL for request
    private String url;

    private JsonObjectRequest jsonObject;

    public void setContext(Context c) {
        this.c = c;
    }

    public void setUrl(String url){
        this.url = url;
    }

    public void data(String method, JSONObject data){

        try {
            JSONObject p = new JSONObject();
            p.put("method", method);
            p.put("id", this.id++);
            p.put("params", data);

            this.data = p;

        }catch (Exception e){
            Log.d("deb", e.getMessage());
        }
    }

    public RPCJson callback(final VolleyCallback callback){
          this.jsonObject = new JsonObjectRequest
                (Request.Method.POST, this.url, this.data, new Response.Listener<JSONObject>() {

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

    public RPCJson send(){
        RequestQueue queue = Volley.newRequestQueue(this.c);
        queue.add(this.jsonObject);
        return  this;
    }

    public JSONObject getData(){
        return this.data;
    }
}
