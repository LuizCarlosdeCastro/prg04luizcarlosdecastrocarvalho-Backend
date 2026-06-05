package br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.service;

import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.entity.Usuario;
import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.infraestructure.exception.BusinessException;
import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.repository.UsuarioRepository;
import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.service.UsuarioIService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService implements UsuarioIService {

    private final UsuarioRepository usuarioRepository;

    @Override
    @Transactional
    public Usuario save(Usuario usuario) {
        if (usuario.getNome() != null && usuario.getNome().isEmpty()) {
            throw new RuntimeException("Nome não pode estar vazio");
        }
        if (usuario.getEmail() != null && usuario.getEmail().isEmpty()) {
            throw new RuntimeException("Email não pode ser vazio");
        }
        if (usuario.getSenha() != null && usuario.getSenha().isEmpty()) {
            throw new RuntimeException("Senha não pode ser vazia");
        }
        return usuarioRepository.save(usuario);
    }

    @Override
    public Page<Usuario> findAll(Pageable pageable) {
        return usuarioRepository.findAll(pageable);
    }

    @Override
    public Usuario findById(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new BusinessException("Usuário não encontrado com o ID: " + id));
    }

    @Override
    @Transactional
    public Usuario update(Long id, Usuario usuarioAtualizado) {
        if (usuarioAtualizado.getNome() != null && usuarioAtualizado.getNome().isEmpty()) {
            throw new RuntimeException("Nome não pode estar vazio");
        }
        if (usuarioAtualizado.getEmail() != null && usuarioAtualizado.getEmail().isEmpty()) {
            throw new RuntimeException("Email não pode ser vazio");
        }
        if (usuarioAtualizado.getSenha() != null && usuarioAtualizado.getSenha().isEmpty()) {
            throw new RuntimeException("Senha não pode ser vazia");
        }

        Usuario usuarioExistente = this.findById(id);
        usuarioExistente.setNome(usuarioAtualizado.getNome());
        usuarioExistente.setEmail(usuarioAtualizado.getEmail());
        usuarioExistente.setSenha(usuarioAtualizado.getSenha());
        usuarioExistente.setTipoUsuario(usuarioAtualizado.getTipoUsuario());

        return usuarioRepository.save(usuarioExistente);
    }

    @Override
    public void delete(Long id) {
        Usuario usuario = this.findById(id);
        usuarioRepository.deleteById(id);
    }
}