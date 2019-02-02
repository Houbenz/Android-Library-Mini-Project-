package com.houbenz.webserviceclient.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.houbenz.webserviceclient.Beans.Reservation;
import com.houbenz.webserviceclient.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ReservationAdapter extends RecyclerView.Adapter<ReservationAdapter.MyviewHolder> {

    ArrayList<Reservation> reservations= new ArrayList<Reservation>();

    public class MyviewHolder extends RecyclerView.ViewHolder{

        public View view ;
        public MyviewHolder(@NonNull View v) {
            super(v);
            view=v;

        }
    }


    public ReservationAdapter(ArrayList<Reservation> reservations){
        this.reservations=reservations;
    }

    @NonNull
    @Override
    public MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

       View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.reservation_view,parent,false);

        return new MyviewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyviewHolder holder, int position) {

        Reservation reservation =reservations.get(position);
        TextView etat = holder.view.findViewById(R.id.etat);
        TextView titre = holder.view.findViewById(R.id.titre);
        TextView date = holder.view.findViewById(R.id.date);

        titre.setText("Titre : "+reservation.getTitre());
        date.setText("Date : "+reservation.getDate());

        switch (reservation.getEtat_reservation()){

            case 0 : {
                etat.setText("En cours");
                break;
                     }

            case 1 : {
                etat.setText("Dans la liste d'attente");
                break;
                     }

            case 3 : {
                etat.setText("Vous possedez le livre");
                break;
                     }
        }

    }

    @Override
    public int getItemCount() {
        return reservations.size();
    }
}
