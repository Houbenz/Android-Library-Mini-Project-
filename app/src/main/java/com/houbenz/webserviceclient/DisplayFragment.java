package com.houbenz.webserviceclient;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.houbenz.webserviceclient.Adapter.OuvrageAdapter;
import com.houbenz.webserviceclient.Adapter.VerticalSpaceItemDecoration;
import com.houbenz.webserviceclient.Beans.Ouvrage;
import com.houbenz.webserviceclient.R;
import com.houbenz.webserviceclient.ViewModel.SharedViewModel;

import org.json.JSONArray;
import org.json.JSONException;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * A simple {@link Fragment} subclass.
 */
public class DisplayFragment extends Fragment {

    private SharedViewModel model;
    private EditText titreEdit;

    private RecyclerView recycleOuvrage;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;


    public DisplayFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View frame = inflater.inflate(R.layout.fragment_display, container, false);

        model=ViewModelProviders.of(getActivity()).get(SharedViewModel.class);

        titreEdit=frame.findViewById(R.id.titreEdit);

        recycleOuvrage=(RecyclerView) frame.findViewById(R.id.recyclerOuvrage);
        recycleOuvrage.setHasFixedSize(true);

        recycleOuvrage.addItemDecoration(new VerticalSpaceItemDecoration(32));
        //create and set the layoutmanager for recycler
        layoutManager = new LinearLayoutManager(getContext());
        recycleOuvrage.setLayoutManager(layoutManager);

        //Event for when the enter button is pressed
        titreEdit.setOnKeyListener((view, keyCode, keyEvent) -> {

            if((keyEvent.getAction()==KeyEvent.ACTION_DOWN) && keyCode==KeyEvent.KEYCODE_ENTER){

                String titre =titreEdit.getText().toString();
                String url ="http://192.168.43.210:7000/RechercherOuvrage?codebar&titre="+titre+"&auteur&theme&mot_cle";

                //this volley request using GET method for RechercherOuvrage
                StringRequest request = new StringRequest(Request.Method.GET, url, response -> {

                    if(!response.equals("")){

                            Gson gson =new Gson();
                            Ouvrage[] ouvs =gson.fromJson(response,Ouvrage[].class);

                        ArrayList<Ouvrage> ouvrages = new ArrayList<Ouvrage>(Arrays.asList(ouvs));


                            model.getUsername().observe(getActivity(),username ->{

                                adapter = new OuvrageAdapter(ouvrages,username);
                                recycleOuvrage.setAdapter(adapter);
                            });

                    }

                }, error -> {

                    Toast.makeText(getContext(),"Error = "+error.getMessage(),Toast.LENGTH_SHORT).show();
                });

                RequestQueue requestQueue = Volley.newRequestQueue(getContext());
                requestQueue.add(request);

                return true;
            }
            return false;
        });


        return  frame;
    }

}
