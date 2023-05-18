package org.jinha.board.restcontrollers;

import org.jinha.board.commons.CommonException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FileUploadController {//ajax 사용할 때 씀
    @GetMapping("/file/upload")
    public void upload(){
        boolean result = true;
        if(result){
            throw new CommonException("예외발생", HttpStatus.BAD_REQUEST);
        }
    }
}
