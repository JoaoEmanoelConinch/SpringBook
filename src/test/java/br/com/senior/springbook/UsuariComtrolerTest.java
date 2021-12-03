package br.com.senior.springbook;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import br.com.senior.springbook.controller.usuario.LoginController;
import br.com.senior.springbook.controller.usuario.UsuarioController;
import br.com.senior.springbook.model.dto.usuario.UsuarioDto;

public class UsuariComtrolerTest {
    
    private UsuarioController usuarioController;

    private LoginController login;

    private UsuarioDto usuarioDto;

    @BeforeAll
    public void init(){
        usuarioController = new UsuarioController();

        usuarioDto = new UsuarioDto();
        usuarioDto.nome="joao";
        usuarioDto.senha="123";

        usuarioController.post(usuarioDto);
    }

    @Test
    public void deveRetornarUmToken(){
        UsuarioDto usuarioDto2 = new UsuarioDto();
        usuarioDto2.nome="joao";
        usuarioDto2.senha="123";
        assertNotNull(login.login(usuarioDto2));
    }

}
