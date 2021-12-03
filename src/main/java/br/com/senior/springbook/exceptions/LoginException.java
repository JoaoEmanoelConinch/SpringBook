package br.com.senior.springbook.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED, reason = "Nome ou senha inválidos!")
public class LoginException extends RuntimeException {
    public LoginException(String s) {
        super(s);
    }
}
