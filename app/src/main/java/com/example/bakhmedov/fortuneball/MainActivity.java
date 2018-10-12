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
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.bakhmedov.fortuneball.RPC.Auth;

import org.json.JSONObject;

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

        }catch (Exception $e){
            Log.d("deb", $e.getMessage().toString());
        }


    }


 //https://developer.android.com/training/volley/request-custom
    private void doJson(){

        try {

            (new Auth(this)).auth("bootta@yandex.ru","760218e9");


        } catch (Exception e) {
            Log.d("deb", "asdsd" +e.getClass() + e.getMessage());
        }

    }

}
