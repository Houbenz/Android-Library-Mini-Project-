package com.houbenz.webserviceclient.Beans;

public class Ouvrage {



    private String titre,auteur,theme,mot_cle;
    private int codebar;


    public Ouvrage(){

    }
    public Ouvrage(int codebar,String titre, String auteur, String theme, String mot_cle) {
        this.titre = titre;
        this.auteur = auteur;
        this.theme = theme;
        this.mot_cle = mot_cle;
        this.codebar = codebar;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getMot_cle() {
        return mot_cle;
    }

    public void setMot_cle(String mot_cle) {
        this.mot_cle = mot_cle;
    }

    public int getCodebar() {
        return codebar;
    }

    public void setCodebar(int codebar) {
        this.codebar = codebar;
    }
}
