package br.com.senior.springbook.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "O livro não existe no sistema!")
public class BookExistenceException extends RuntimeException {
    public BookExistenceException(String s) {
        super(s);
    }
}
