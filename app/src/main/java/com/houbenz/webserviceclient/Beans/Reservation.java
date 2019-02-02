package com.houbenz.webserviceclient.Beans;

import java.io.Serializable;

public class Reservation implements Serializable {

    int codebar;
    String username;
    int etat_reservation;
    String date;
    String titre;

    public Reservation()
    {

    }

    public Reservation(int codebar, String username, int etat_reservation)
    {
        this.codebar = codebar;
        this.username = username;
        this.etat_reservation = etat_reservation;
    }

    public int getCodebar() {
        return codebar;
    }

    public void setCodebar(int codebar) {
        this.codebar = codebar;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getEtat_reservation() {
        return etat_reservation;
    }

    public void setEtat_reservation(int etat_reservation) {
        this.etat_reservation = etat_reservation;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }
}
