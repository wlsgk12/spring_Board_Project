package org.jinha.board.model.board.config;

import org.jinha.board.commons.CommonException;
import org.springframework.http.HttpStatus;

public class BoardConfigNotExistException extends CommonException {
    public BoardConfigNotExistException() {
        super(bundleValidation.getString("Validation.board.notExists"), HttpStatus.BAD_REQUEST);
    }
}