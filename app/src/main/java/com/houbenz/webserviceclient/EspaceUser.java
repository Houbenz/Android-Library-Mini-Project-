package com.houbenz.webserviceclient;


import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.TextView;

import com.houbenz.webserviceclient.ViewModel.SharedViewModel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

public class EspaceUser extends AppCompatActivity {


    TextView wlcText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_espace_user);

        wlcText=findViewById(R.id.wlcText);


        String username = getIntent().getStringExtra("username");

        wlcText.setText("Bonjour "+username);

        SharedViewModel sharedViewModel = ViewModelProviders.of(this).get(SharedViewModel.class);

        sharedViewModel.setUsername(username);


        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction=manager.beginTransaction();
        transaction.replace(R.id.displayFrag,new DisplayFragment());
        transaction.commit();
    }
}
