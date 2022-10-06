package com.dbd.realstate;

public class RealStateExcepction extends Exception{

    private String message;

    public RealStateExcepction(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
