package br.com.senior.springbook.controller.usuario;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import br.com.senior.springbook.exceptions.LoginException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senior.springbook.model.Tokens;
import br.com.senior.springbook.model.dto.usuario.UsuarioDto;
import br.com.senior.springbook.model.entities.usuario.UsuarioEntity;
import br.com.senior.springbook.model.repository.usuario.UsuarioRepository;

@RestController
@RequestMapping(value = "/login")
public class LoginController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    public ResponseEntity<String> login(@RequestBody UsuarioDto usuarioDto) {
        List<UsuarioEntity> usuarios = usuarioRepository.findAll();
        List<UsuarioEntity> usuariosPedidos = usuarios
                .stream()
                .filter(e -> (e.getNome().equals(usuarioDto.nome)) && (e.getSenha().equals(usuarioDto.senha)))
                .collect(Collectors.toList());
        if (!usuariosPedidos.isEmpty()) {
            String token = UUID.randomUUID().toString();
            Tokens.tokens.add(token);
            return ResponseEntity.ok().body(token);
        }
        throw new LoginException("Nome ou senha inválidos!");
    }

}
