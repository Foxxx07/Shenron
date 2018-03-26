package com.ksf.data;

import java.util.ArrayList;

public class User {
    private String userMail;
    //private ArrayList<Mail> mails;
    private int nbMailSent;
    public User(String userMail) {
        this.userMail = userMail;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }


   /* public ArrayList<Mail> getMails() {
        return mails;
    }

    public void setMails(ArrayList<Mail> mails) {
        this.mails = mails;
    }*/
}
