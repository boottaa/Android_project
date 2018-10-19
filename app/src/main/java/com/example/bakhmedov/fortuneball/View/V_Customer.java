package com.example.bakhmedov.fortuneball.View;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.bakhmedov.fortuneball.R;
import com.example.bakhmedov.fortuneball.RPC.Auth.Session;

import org.json.JSONException;
import org.json.JSONObject;


public class V_Customer extends AppCompatActivity {

    private Session session = new Session(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user);

        TextView email = (TextView) findViewById(R.id.email);
        TextView phone = (TextView) findViewById(R.id.phone);
        TextView name = (TextView) findViewById(R.id.name);
        try {
            JSONObject session = this.session.run();
            String getEmail = session.get("email").toString();
            String getPhone = session.get("phone").toString();

            String fname = session.get("fname").toString();
            String lname = session.get("lname").toString();

            email.setText(getEmail);
            phone.setText(getPhone);
            name.setText(String.format("%s %s", fname, lname));

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}
