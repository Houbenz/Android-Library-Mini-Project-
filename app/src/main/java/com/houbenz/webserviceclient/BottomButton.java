package com.houbenz.webserviceclient;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.houbenz.webserviceclient.ViewModel.SharedViewModel;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;


public class BottomButton extends Fragment {

    SharedViewModel model;

    Button rechButton;
    Button resvButton;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View frame= inflater.inflate(R.layout.fragment_bottom_button, container, false);

        model=ViewModelProviders.of(getActivity()).get(SharedViewModel.class);

        rechButton=frame.findViewById(R.id.rechButton);
        resvButton=frame.findViewById(R.id.resvButton);

        rechButton.setOnClickListener(view ->{
            FragmentManager manager = getActivity().getSupportFragmentManager();
            FragmentTransaction transaction=manager.beginTransaction();
            transaction.replace(R.id.displayFrag,new DisplayFragment());
            transaction.commit();

        });


        return frame;
    }


}
