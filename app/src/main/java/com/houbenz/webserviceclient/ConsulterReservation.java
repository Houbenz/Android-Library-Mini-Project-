package com.houbenz.webserviceclient;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.houbenz.webserviceclient.Adapter.ReservationAdapter;
import com.houbenz.webserviceclient.Adapter.VerticalSpaceItemDecoration;
import com.houbenz.webserviceclient.Beans.Reservation;
import com.houbenz.webserviceclient.ViewModel.SharedViewModel;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;


/**
 * A simple {@link Fragment} subclass.
 */
public class ConsulterReservation extends Fragment {

    private RecyclerView recyclerReservation;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager manager;
    private SharedViewModel model;
    private String username ;

    public ConsulterReservation() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View frame = inflater.inflate(R.layout.fragment_consulter_reservation, container, false);

        recyclerReservation=frame.findViewById(R.id.recycleReservation);
        recyclerReservation.setHasFixedSize(true);
        manager=new LinearLayoutManager(getContext());
        recyclerReservation.setLayoutManager(manager);

        recyclerReservation.addItemDecoration(new VerticalSpaceItemDecoration(32));

        model =ViewModelProviders.of(getActivity()).get(SharedViewModel.class);

        String url ;

        model.getUsername().observe(getActivity(),user ->{
            username=user;
        });




        url = "http://192.168.43.210:7000/ConsulterReservation?username="+username;

        StringRequest request = new StringRequest(Request.Method.GET,url,response -> {

            if(response != null){
                Gson gson = new Gson();
                ArrayList<Reservation> reservations = new ArrayList<Reservation>(Arrays.asList(gson.fromJson(response,Reservation[].class)));
                adapter = new ReservationAdapter(reservations);
                recyclerReservation.setAdapter(adapter);


            }

        },error ->{

            Toast.makeText(getContext(),"Error : "+error.getMessage(),Toast.LENGTH_SHORT).show();
        });

        RequestQueue requestQueue =Volley.newRequestQueue(getContext());
        requestQueue.add(request);


        return frame;

    }

}
