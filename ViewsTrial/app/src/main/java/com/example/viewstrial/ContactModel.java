package com.example.viewstrial;

public class ContactModel {
    int image;
    String name;
    String number;
    public ContactModel(int img,String nam,String num){
        this.image=img;
        this.name=nam;
        this.number=num;
    }
    public ContactModel(String nam,String num){
        this.name=nam;
        this.number=num;
    }
}
