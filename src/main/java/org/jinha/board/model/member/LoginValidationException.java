package org.jinha.board.model.member;

import org.jinha.board.commons.CommonException;
import org.springframework.http.HttpStatus;

//로그인 유효성 검사시 예외 처리
public class LoginValidationException extends CommonException {

    private String field;
    public LoginValidationException(String code) {
        super(bundleValidation.getString(code), HttpStatus.BAD_REQUEST);
    }
    public LoginValidationException(String field, String code){
        this(code);
        this.field = field;
    }
    public String getField(){
        return field;
    }
}
