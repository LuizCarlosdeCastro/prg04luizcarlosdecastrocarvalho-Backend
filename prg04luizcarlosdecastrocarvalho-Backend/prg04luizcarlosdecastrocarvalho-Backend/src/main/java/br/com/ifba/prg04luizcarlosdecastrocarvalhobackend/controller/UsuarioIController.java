package br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.controller;

import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.entity.Usuario;
import org.springframework.http.ResponseEntity;
import java.util.List;

public interface UsuarioIController {
    ResponseEntity<Usuario> save(Usuario usuario);
    ResponseEntity<List<Usuario>> findAll();
    ResponseEntity<Usuario> findById(Long id);
    ResponseEntity<Usuario> update(Long id, Usuario usuario);
    ResponseEntity<Void> delete(Long id);
}