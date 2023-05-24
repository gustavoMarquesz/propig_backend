package com.propig_backend.propig.exceptions;



public class CotaNotFound extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public static  String message = "Id não encontrado:  ";

    public CotaNotFound() {
        super(message);
    }
}