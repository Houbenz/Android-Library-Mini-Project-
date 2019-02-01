package com.houbenz.webserviceclient.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SharedViewModel extends ViewModel {

    MutableLiveData<String> username = new MutableLiveData<String>();



    public void setUsername(String user){
        username.setValue(user);
    }

    public LiveData<String> getUsername(){
        return username;
    }

}
