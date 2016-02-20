package com.example.rahul.myapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.String;

public class Login extends AppCompatActivity implements View.OnClickListener {
    EditText username,password;
    Button login;
    String busername,bpassword,url,response1;
    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.login);
        login.setOnClickListener(this);

      /* username.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {


            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                int a=s.length();
                int i=0;

             while(a>0)
             {   char c = s.charAt(i);
                 if (c.isDigit(c))
                 {}
             }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });*/


        busername = username.getText().toString();
        if (busername == "username") {
            Toast.makeText(Login.this, busername, Toast.LENGTH_LONG).show();
        }

    }

    void user_login() {
        busername = username.getText().toString();
        bpassword = password.getText().toString();


        url = "http://10.243.145.177:8000/default/login.json?userid=" + busername + "&password=" + bpassword;


        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest jsObjRequest = new StringRequest

                (Request.Method.GET, "http://10.243.145.177:8000/default/login.json?userid=cs1110200&password=john", new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        response1 = response.toString();
                        try {
                            JSONObject user = new JSONObject(response1);
                            String user_info = user.getString("user");
                            JSONObject user1 = new JSONObject(user_info);
                            String user_lastname = user1.getString("last_name");

                            Toast.makeText(Login.this, user_lastname, Toast.LENGTH_LONG).show();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Login.this, "error", Toast.LENGTH_LONG).show();
                        String response2 = ("Response: " + error.toString());
                        Toast.makeText(Login.this, response2, Toast.LENGTH_LONG).show();

                    }
                });

        queue.add(jsObjRequest);

    }

    @Override
    public void onClick(View v) {

        if(v==login)
        {
            user_login();
        }
    }
}
