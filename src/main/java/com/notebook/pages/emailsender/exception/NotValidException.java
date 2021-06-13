package com.notebook.pages.emailsender.exception;

public class NotValidException extends RuntimeException{

    private String message;

    public NotValidException(String message){
        super("Invalid  : "+message);
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }
}
