package com.example.bakhmedov.fortuneball.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.example.bakhmedov.fortuneball.RPC.Auth.Auth;
import com.example.bakhmedov.fortuneball.Library.Files;
import com.example.bakhmedov.fortuneball.R;

public class V_Auth extends AppCompatActivity {

    private Files $file;
    private String $url;

    private void init()
    {
        this.$file = new Files();
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

    public void login(View view) {
        try{
            EditText editText = (EditText) findViewById(R.id.email);
            EditText password = (EditText) findViewById(R.id.password);
            String email = editText.getText().toString();
            String pass = password.getText().toString();

//.auth("bootta@yandex.ru","760218e9");
            (new Auth(this)).auth(email,pass);

        }catch (Exception $e){
            Log.d("deb", $e.getMessage().toString());
        }
    }
}
