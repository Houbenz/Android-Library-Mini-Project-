package com.houbenz.webserviceclient;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.houbenz.webserviceclient.Beans.Ouvrage;

public class ReserverOuvrage extends AppCompatActivity {

    TextView auteurTv,themeTv,titreTv,mot_cleTv,etatOuvrage,result_reserve;
    Button reserver,annuler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserver_ouvrage);

        Ouvrage ouvrage = (Ouvrage) getIntent().getSerializableExtra("ouvrage");
        String username = getIntent().getStringExtra("username");


        Toast.makeText(getApplicationContext(),ouvrage.getTitre(),Toast.LENGTH_LONG).show();

        auteurTv=findViewById(R.id.auteurTv);
        themeTv=findViewById(R.id.themeTv);
        titreTv=findViewById(R.id.TitreTv);
        mot_cleTv=findViewById(R.id.mot_cleTv);
        etatOuvrage=findViewById(R.id.etatOuvrage);
        result_reserve=findViewById(R.id.result_reserve);

        reserver=findViewById(R.id.reserverBtn);
        annuler=findViewById(R.id.annulerBtn);

        if(ouvrage != null){
            auteurTv.setText("Auteur : "+ouvrage.getAuteur());
            themeTv.setText("Theme : "+ouvrage.getTheme());
            titreTv.setText("Titre : "+ouvrage.getTitre());

            String url ="http://192.168.43.210:7000/IsOuvrageLibre?codebar="+ouvrage.getCodebar();
            StringRequest request = new StringRequest(Request.Method.GET,url,response -> {

                if(response != null){

                    if(response.equals("true")){

                        etatOuvrage.setText("Etat : Libre");
                        etatOuvrage.setTextColor(getResources().getColor(R.color.green));
                    }else  if(response.equals("false")){

                        etatOuvrage.setText("Etat : Occupé");
                        etatOuvrage.setTextColor(getResources().getColor(R.color.red));
                    }
                }
            },error -> {
                Toast.makeText(getApplicationContext(),"An error Occured : "+error,Toast.LENGTH_SHORT).show();

            });

            RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
            requestQueue.add(request);


        }

        reserver.setOnClickListener(view -> {

            String url ="http://192.168.43.210:7000/ReserveOuvrage?codebar="+ouvrage.getCodebar()+"&username="+username;
            StringRequest request = new StringRequest(Request.Method.GET,url,response -> {

                if(response != null) {
                    int responseInt = Integer.parseInt(response);

                    //TODO implement the response to it



                    switch (responseInt)
                    {
                        case 0:
                            result_reserve.setText("Reservation accomplie");
                            result_reserve.setTextColor(getResources().getColor(R.color.green));
                            break;

                        case 3:
                            result_reserve.setText("Vous etes mis dans la file d'attente");
                            result_reserve.setTextColor(getResources().getColor(R.color.blue));
                            break;

                        case -3:
                            result_reserve.setText("Votre compte est suspendu");
                            result_reserve.setTextColor(getResources().getColor(R.color.red));
                            break;

                        default:
                            result_reserve.setText("Reservation echoué");
                            result_reserve.setTextColor(getResources().getColor(R.color.red));
                            break;

                    }
                }

            },error -> {
                Toast.makeText(getApplicationContext(),"An error Occured : "+error,Toast.LENGTH_SHORT).show();
            });

            RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
            requestQueue.add(request);
        });


        annuler.setOnClickListener(view ->{
            finish();
        });

    }



}
