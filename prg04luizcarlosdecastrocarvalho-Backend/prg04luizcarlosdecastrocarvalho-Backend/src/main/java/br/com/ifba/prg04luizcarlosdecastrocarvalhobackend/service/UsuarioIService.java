package br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.service;

import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.entity.Usuario;
import java.util.List;

public interface UsuarioIService {
    Usuario save(Usuario usuario);
    List<Usuario> findAll();
    Usuario findById(Long id);
    Usuario update(Long id, Usuario usuario);
    void delete(Long id);
}