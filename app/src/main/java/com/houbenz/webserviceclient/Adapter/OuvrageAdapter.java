package com.houbenz.webserviceclient.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.houbenz.webserviceclient.Beans.Ouvrage;
import com.houbenz.webserviceclient.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class OuvrageAdapter extends RecyclerView.Adapter<OuvrageAdapter.MyViewHolder> {

    private ArrayList<Ouvrage> dataList;

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        public View view;
        public MyViewHolder(View v) {
            super(v);
            view=v;
        }
    }

    public OuvrageAdapter(ArrayList<Ouvrage> dataList){
        this.dataList=dataList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v =LayoutInflater.from(parent.getContext()).inflate(R.layout.ouvrage_view,parent,false);
        MyViewHolder mv = new MyViewHolder(v);
        return  mv;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Ouvrage ouvrage =dataList.get(position);
        TextView titre =holder.view.findViewById(R.id.TitreTv);

        titre.setText(ouvrage.getTitre());

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
