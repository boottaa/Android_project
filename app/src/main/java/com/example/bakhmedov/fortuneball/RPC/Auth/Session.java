package com.example.bakhmedov.fortuneball.RPC.Auth;

import android.content.Context;

import com.example.bakhmedov.fortuneball.Library.Files;

import org.json.JSONException;
import org.json.JSONObject;

public class Session {

    private Files file = new Files();

    private String fileName = "session.json";

    private Context c;

    Session(Context c){
        this.c = c;
    }

    void save(JSONObject data){
        this.file.writeFile(data.toString(), this.c, this.fileName);
    }

    public JSONObject get() throws JSONException {
        return new JSONObject(this.file.readFile(this.c, this.fileName));
    };

}
