package br.com.senior.springbook.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE, reason = "Um dos campos do livro é inválido!")
public class BookException extends RuntimeException {
    public BookException(String s) {
        super(s);
    }
}
