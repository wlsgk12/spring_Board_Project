package org.jinha.board.commons;

import org.springframework.http.HttpStatus;

import java.util.ResourceBundle;

//공통 예외
public class CommonException extends RuntimeException{
    protected static ResourceBundle bundleValidation;
    protected static ResourceBundle bundleError;
    protected HttpStatus httpStatus; //상태코드

    static{
        bundleValidation = ResourceBundle.getBundle("messages.validations");
        bundleError = ResourceBundle.getBundle("message.errors");
    }
    public CommonException(String message){
        super(message);
        httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
    }
    public CommonException(String message, HttpStatus httpStatus){
        super(message);
        this.httpStatus = httpStatus;
    }
    public HttpStatus getHttpStatus(){
        return httpStatus;
    }
}
