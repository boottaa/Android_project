package com.example.bakhmedov.fortuneball;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private MyFiles $file;
    private String $url;

    private void init()
    {
        this.$file = new MyFiles();


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Init dependencies
        init();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }





    public void bcli(View view) {


        /**
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText("HELLO WORLD");

        **/

    }

    public void bali(View view) {

        EditText editText = (EditText) findViewById(R.id.editText);
        EditText password = (EditText) findViewById(R.id.password);
        String email = editText.getText().toString();
        String pass = password.getText().toString();

        try{

            doJson();
//            doInBackground();
//            this.$url =
//            Log.d("deb", "REQUEST" + $url);
        }catch (Exception $e){
            Log.d("deb", $e.getMessage().toString());
        }

//        $file.writeFile("lalalasdsdsasdsdasdasdas", this.getBaseContext(), "conf.txt");
//        String s = $file.readFile(this.getBaseContext(), "conf.txt");

//        Log.d("deb ddd", s);


    }


    protected void doInBackground() {

        String url = "http://billig.ru";

// Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);

// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("deb", "Response is: "+ response.substring(0,500));
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("deb", "That didn't work!" + error.getMessage());
            }
        });

// Add the request to the RequestQueue.
        queue.add(stringRequest);
    }
 //https://developer.android.com/training/volley/request-custom
    private void doJson(){
        String url = "http://billig.ru/auth";


        try {


            RequestQueue queue = Volley.newRequestQueue(this);


            JSONObject data = new JSONObject();
            data.put("email", "bootta@yandex.ru");
            data.put("password", "760218e9");

            JSONObject p = (new RPCJson()).data("auth", data).getData();

            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                    (Request.Method.POST, url, p, new Response.Listener<JSONObject>() {

                        @Override
                        public void onResponse(JSONObject response) {
                            Log.d("deb", "Response: " + response.toString());
                        }
                    }, new Response.ErrorListener() {

                        @Override
                        public void onErrorResponse(VolleyError error) {

                            Log.d("deb", "ERROR: " + error.getMessage());
                            // TODO: Handle error

                        }
                    });
            Log.d("deb", "BODY: " + new String(jsonObjectRequest.getBody(), "UTF-8"));
            queue.add(jsonObjectRequest);
        } catch (Exception e) {
            Log.d("deb", e.getMessage());
        }

    }

}
