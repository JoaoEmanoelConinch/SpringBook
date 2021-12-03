package br.com.senior.springbook.controller.usuario;

import br.com.senior.springbook.exceptions.LoginException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senior.springbook.model.dto.usuario.UsuarioDto;
import br.com.senior.springbook.model.entities.usuario.UsuarioEntity;
import br.com.senior.springbook.model.mapper.usuario.UsuarioMapper;
import br.com.senior.springbook.model.repository.usuario.UsuarioRepository;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioMapper usuarioMapper;
    private String string;

    @PostMapping
    public ResponseEntity<UsuarioDto> post(@RequestBody UsuarioDto usuarioDto) {
        if (usuarioDto.nome == null || usuarioDto.senha == null) {
            throw new LoginException("Nome ou senha inválidos!");
        }

        UsuarioEntity usuarioEntity = usuarioMapper.toEntity(usuarioDto);
        UsuarioDto usuarioDtoResponse = usuarioMapper.toDto(usuarioRepository.save(usuarioEntity));

        return ResponseEntity.ok().body(usuarioDtoResponse);
    }

}
