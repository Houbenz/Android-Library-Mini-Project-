package com.houbenz.webserviceclient;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import androidx.appcompat.app.AppCompatActivity;


public class LoginActivity extends AppCompatActivity {

    Button authentification;
    EditText username;
    EditText password;

    ImageView imageview2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username=findViewById(R.id.usernameText);
        password=findViewById(R.id.passwordText);
        authentification = findViewById(R.id.authentification);



        authentification.setOnClickListener(view -> {

            final String usernameString =username.getText().toString();
            String passwordString = password.getText().toString();

             String url ="http://192.168.43.210:7000/AuthentificationUser?username="+usernameString+"&password="+passwordString;

            StringRequest stringRequest= new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String s) {

                    if(s.equals("\"etudiant\"") || s.equals("\"enseignant\"")){

                        Toast.makeText(getApplicationContext(),"Hello "+s+" "+usernameString,Toast.LENGTH_SHORT).show();

                        //to go to EspaceUser when Authentification is succesfull
                        Intent intent = new Intent(getApplicationContext(),EspaceUser.class);
                        intent.putExtra("username",usernameString);
                        startActivity(intent);
                        finish();

                    }
                    else{
                        Toast.makeText(getApplicationContext(),"Nom utilisateur ou mot de passe incorrecte ! "+s,Toast.LENGTH_SHORT).show();

                    }

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError volleyError) {
                    Toast.makeText(getApplicationContext(),"Une erreur est survenue, verifier votre connexion",Toast.LENGTH_SHORT).show();
                    Log.i("EEA",volleyError.getStackTrace().toString());
                }
            });

            RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
            requestQueue.add(stringRequest);

        });



    }

}
