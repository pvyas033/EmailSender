package com.notebook.pages.emailsender.entity;

public class Receiver extends Person{

    public Receiver(String firstName, String lastName){
        super(firstName, lastName);
    }

    public Receiver(String firstName, String lastName, String email){
        super(firstName, lastName, email);
    }

    public Receiver(){

    }
}
