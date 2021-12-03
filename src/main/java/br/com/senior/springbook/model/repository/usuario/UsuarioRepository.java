package br.com.senior.springbook.model.repository.usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senior.springbook.model.entities.usuario.UsuarioEntity;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity,Long>{}
