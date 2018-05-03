package com.ksf.data;

public class Mail {
    private String mail;
    private User destinataire;
    private User envoyeur;

    public Mail(String mail){
        this.mail = mail;
    }

    public Mail(String mail, User destinataire, User envoyeur) {
        this.mail = mail;
        this.destinataire = destinataire;
        this.envoyeur = envoyeur;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

   /* public void setDestinataire(User destinataire) {
        this.destinataire = destinataire;
    }

    public void setEnvoyeur(User envoyeur) {
        this.envoyeur = envoyeur;
    }

    public User getDestinataire() {
        return destinataire;
    }

    public User getEnvoyeur() {
        return envoyeur;
    }*/
}
