package br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.usuario.repository;

import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.usuario.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    java.util.Optional<Usuario> findByLoginAndSenha(String login, String senha);
}