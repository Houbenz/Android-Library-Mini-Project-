package com.houbenz.webserviceclient;


import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class EspaceUser extends AppCompatActivity {


    TextView wlcText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_espace_user);

        wlcText=findViewById(R.id.wlcText);


        String username = getIntent().getStringExtra("username");

        wlcText.setText("Bonjour "+username);

    }
}
