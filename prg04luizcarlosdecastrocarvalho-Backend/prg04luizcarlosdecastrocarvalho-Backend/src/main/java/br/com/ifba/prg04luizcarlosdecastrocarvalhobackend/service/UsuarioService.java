package br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.service;

import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.entity.Usuario;
import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.repository.UsuarioRepository;
import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.service.UsuarioIService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService implements UsuarioIService {

    private final UsuarioRepository usuarioRepository;

    @Override
    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario findById(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado com o ID: " + id));
    }

    @Override
    public Usuario update(Long id, Usuario usuarioAtualizado) {
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