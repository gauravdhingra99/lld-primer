package com.navi.Exception;

/**
 * @author gauravdhingra
 */
public class WrongBranchSelectedException extends RuntimeException{
    String message;

    public WrongBranchSelectedException(String message){
        super(message);
    }
}
