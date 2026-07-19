package br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.usuario.service;

import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.usuario.dto.UsuarioGetResponseDto;
import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.usuario.dto.UsuarioPostRequestDto;
import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.usuario.entity.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UsuarioIService {

    Usuario save(Usuario usuario);
    Page<Usuario> findAll(Pageable pageable);
    Usuario findById(Long id);
    Usuario update(Long id, Usuario usuarioAtualizado);
    void delete(Long id);

    UsuarioGetResponseDto saveDto(UsuarioPostRequestDto dto);
    Page<UsuarioGetResponseDto> findAllWithDto(Pageable pageable);
    UsuarioGetResponseDto findByIdWithDto(Long id);
    UsuarioGetResponseDto updateDto(Long id, UsuarioPostRequestDto dto);
    UsuarioGetResponseDto login(UsuarioPostRequestDto loginDto);
}