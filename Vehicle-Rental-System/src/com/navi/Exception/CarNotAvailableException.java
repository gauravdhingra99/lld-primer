package com.navi.Exception;

/**
 * @author gauravdhingra
 */
public class CarNotAvailableException extends RuntimeException {

    String message;

    public CarNotAvailableException(String message){
        super(message);
    }
}
