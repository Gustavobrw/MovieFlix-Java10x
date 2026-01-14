package com.movieflix.excption;

public class UsernameOrPasswordInvalidException extends RuntimeException {

    public UsernameOrPasswordInvalidException ( String message){
        super(message);
    }
}
