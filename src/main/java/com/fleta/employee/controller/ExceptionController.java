package com.fleta.employee.controller;

import com.fleta.employee.dto.ErrorDto;
import com.fleta.employee.exception.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class ExceptionController {
    //400
    @ExceptionHandler({
            NotExistRequestValueException.class,
            DuplicateMemberException.class,
            DuplicateEmailException.class,
            InvalidBlankPasswordException.class,
            InvalidRegexPasswordException.class,
            NotExistLoginIdException.class,
            InvalidPasswordException.class
    })
    public ResponseEntity BadRequestException(final RuntimeException ex) {
        log.warn(ex.getMessage(), ex);
        return ResponseEntity.status(400).body(
                ErrorDto.builder()
                        .status(400)
                        .message(ex.getMessage())
                        .build()
        );
    }

    //500
    @ExceptionHandler({
            Exception.class
    })
    public ResponseEntity HandleAllException(final Exception ex) {
        log.error(ex.getMessage(), ex);
        return ResponseEntity.status(500).body(
                ErrorDto.builder()
                        .status(500)
                        .message(ex.getMessage())
                        .build()
        );
    }
}
