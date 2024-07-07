package com.analuizawho.pet_hotel.exception;

public class NumeroEmStringException extends RuntimeException{

    private final String campo;

    public NumeroEmStringException(String campo, String exception) {
        super(exception);
        this.campo = campo;
    }

    public String getCampo() {
        return campo;
    }
}
