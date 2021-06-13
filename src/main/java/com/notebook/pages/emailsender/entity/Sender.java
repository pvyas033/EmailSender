package com.notebook.pages.emailsender.entity;

public class Sender extends Person{

    public Sender(String firstName, String lastName){
        super(firstName, lastName);
    }

    public Sender(String firstName, String lastName, String email){
        super(firstName, lastName, email);
    }

    @Override
    public String toString(){
        return super.toString();
    }

    public Sender(){

    }
}
