package br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.usuario.service;

import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.usuario.dto.UsuarioPostRequestDto;
import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.usuario.dto.UsuarioGetResponseDto;
import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.usuario.entity.Usuario;
import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.infraestructure.exception.BusinessException;
import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.usuario.repository.UsuarioRepository;
import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.mapper.ObjectMapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public UsuarioGetResponseDto saveDto(UsuarioPostRequestDto dto) {
        Usuario usuarioEntity = ObjectMapperUtil.map(dto, Usuario.class);
        Usuario usuarioSalvo = this.save(usuarioEntity);
        return ObjectMapperUtil.map(usuarioSalvo, UsuarioGetResponseDto.class);
    }

    @Override
    public Page<Usuario> findAll(Pageable pageable) {
        return usuarioRepository.findAll(pageable);
    }

    @Override
    public Page<UsuarioGetResponseDto> findAllWithDto(Pageable pageable) {
        return this.findAll(pageable).map(usuario -> ObjectMapperUtil.map(usuario, UsuarioGetResponseDto.class));
    }

    @Override
    public Usuario findById(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new BusinessException("Usuário não encontrado com o ID: " + id));
    }

    @Override
    public UsuarioGetResponseDto findByIdWithDto(Long id) {
        return ObjectMapperUtil.map(this.findById(id), UsuarioGetResponseDto.class);
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
    public UsuarioGetResponseDto updateDto(Long id, UsuarioPostRequestDto dto) {
        Usuario usuarioEntity = ObjectMapperUtil.map(dto, Usuario.class);
        Usuario usuarioAtualizado = this.update(id, usuarioEntity);
        return ObjectMapperUtil.map(usuarioAtualizado, UsuarioGetResponseDto.class);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Usuario usuario = this.findById(id);
        usuarioRepository.deleteById(id);
    }


    @Override
    public UsuarioGetResponseDto login(UsuarioPostRequestDto loginDto) {
        return this.findAll(Pageable.unpaged()).stream()
                .filter(u -> u.getLogin().equals(loginDto.getLogin()) && u.getSenha().equals(loginDto.getSenha()))
                .findFirst()
                .map(usuario -> ObjectMapperUtil.map(usuario, UsuarioGetResponseDto.class))
                .orElse(null);
    }
}