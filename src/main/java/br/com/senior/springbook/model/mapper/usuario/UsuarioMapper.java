package br.com.senior.springbook.model.mapper.usuario;

import org.springframework.stereotype.Service;

import br.com.senior.springbook.model.dto.usuario.UsuarioDto;
import br.com.senior.springbook.model.entities.usuario.UsuarioEntity;

@Service
public class UsuarioMapper {
    
    public UsuarioDto toDto(UsuarioEntity usuarioEntity){
        var usuarioDto = new UsuarioDto();
        usuarioDto.nome = usuarioEntity.getNome();
        usuarioDto.senha = usuarioEntity.getSenha();
        return usuarioDto;
    }

    public UsuarioEntity toEntity(UsuarioDto usuarioDto){
        var usuarioEntity = new UsuarioEntity();
        usuarioEntity.setNome(usuarioDto.nome);
        usuarioEntity.setSenha(usuarioDto.senha);
        return usuarioEntity;
    }

}
