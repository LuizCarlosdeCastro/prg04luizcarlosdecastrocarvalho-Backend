package br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.repository;

import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    java.util.Optional<Usuario> findByLoginAndSenha(String login, String senha);
}