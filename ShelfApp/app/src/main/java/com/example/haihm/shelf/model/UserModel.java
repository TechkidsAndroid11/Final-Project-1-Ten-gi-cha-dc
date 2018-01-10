package com.example.haihm.shelf.model;

/**
 * Created by Trần_Tân on 10/01/2018.
 */

public class UserModel {
    public String id;
    public String anhAvatar;
    public String anhCover;
    public String hoten;
    public String sdt;
    public String diaC;
    public Rate rate;

    public UserModel() {
        id = "";
        anhAvatar ="";
        anhCover ="";
        hoten = "";
        sdt = "";
        diaC = "";
        rate = new Rate();
    }

    private class Rate {
        public int tongD;
        public int tongVote;
    }
}
