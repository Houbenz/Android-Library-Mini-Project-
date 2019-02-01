package com.houbenz.webserviceclient.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.houbenz.webserviceclient.Beans.Ouvrage;
import com.houbenz.webserviceclient.R;
import com.houbenz.webserviceclient.ReserverOuvrage;

import org.w3c.dom.Text;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class OuvrageAdapter extends RecyclerView.Adapter<OuvrageAdapter.MyViewHolder> {

    private ArrayList<Ouvrage> dataList;

    private  String username ;



    public static class MyViewHolder extends RecyclerView.ViewHolder{

        public View view;

        public MyViewHolder(View v) {
            super(v);
            view=v;
        }
    }

    public OuvrageAdapter(ArrayList<Ouvrage> dataList,String username){
        this.dataList=dataList;this.username=username;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v =LayoutInflater.from(parent.getContext()).inflate(R.layout.ouvrage_view,parent,false);



        return   new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Ouvrage ouvrage =dataList.get(position);
        TextView titre =holder.view.findViewById(R.id.TitreTv);
        TextView auteur = holder.view.findViewById(R.id.auteurTv);
        TextView theme = holder.view.findViewById(R.id.themeTv);
        //TextView mot_cle=holder.view.findViewById(R.id.mot_cleTv);
        titre.setText("Titre : "+ouvrage.getTitre());
        auteur.setText("Auteur : "+ouvrage.getAuteur());
        theme.setText("Theme : "+ouvrage.getTheme());
        //mot_cle.setText(ouvrage.getMot_cle());

        holder.view.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.view.getContext(),ReserverOuvrage.class);
                intent.putExtra("ouvrage",ouvrage);
                intent.putExtra("username",username);
                holder.view.getContext().startActivity(intent);

            }
        });


    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
