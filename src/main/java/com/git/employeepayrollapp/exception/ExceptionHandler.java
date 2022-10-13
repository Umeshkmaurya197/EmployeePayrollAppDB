package com.git.employeepayrollapp.exception;

import com.git.employeepayrollapp.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(CustomException.class)
    public ResponseEntity<ResponseDTO> handleIdNotFoundException(CustomException customException) {
        ResponseDTO responseDTO = new ResponseDTO("Exception while searching for employee ", customException.getMessage());
        return new ResponseEntity<>(responseDTO, HttpStatus.NOT_FOUND);

    }
}
