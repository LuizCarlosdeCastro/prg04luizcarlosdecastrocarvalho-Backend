package com.ifba.prg04luizcarlosdecastrocarvalhobackend.repository;

import com.ifba.prg04luizcarlosdecastrocarvalhobackend.entity.usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}