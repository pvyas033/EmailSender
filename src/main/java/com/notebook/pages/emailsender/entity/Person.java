package com.notebook.pages.emailsender.entity;

public class Person implements java.io.Serializable{

    private String email;
    private String password;
    private String firstName;
    private String lastName;

    public Person(){

    }

    public Person(String firstName, String lastName, String email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = "";
    }

    @Override
    public String toString(){
        return "Person{"+
                "email='"+email+'\''+
                ", password='"+password+'\''+
                ", firstName='"+firstName+'\''+
                ", lastName='"+lastName+'\''+
                '}';
    }

    public Person(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = "";
        this.password = "";
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getLastName(){
        return this.lastName;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getEmail(){
        return this.email;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getPassword(){
        return this.password;
    }
}
