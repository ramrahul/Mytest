package com.example.rahul.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.lang.String;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    String response1,res;
    Button login,signup,teaching;
    ImageButton imageButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login = (Button) findViewById(R.id.blogin);
        login.setOnClickListener(this);
        signup = (Button) findViewById(R.id.bsignup);
        signup.setOnClickListener(this);
        imageButton = (ImageButton) findViewById(R.id.icon);
        imageButton.setOnClickListener(this);


    }


    public void onClick(View v) {

            switch(v.getId())
            {
                case R.id.blogin:
                    Intent intent_login = new Intent(this, Login.class);
                    startActivity(intent_login);
                    break;

               case R.id.icon:

                    Intent intent_teaching = new Intent(this, teaching_assistants.class);
                    startActivity(intent_teaching);
                    break;

            }

    }
}
