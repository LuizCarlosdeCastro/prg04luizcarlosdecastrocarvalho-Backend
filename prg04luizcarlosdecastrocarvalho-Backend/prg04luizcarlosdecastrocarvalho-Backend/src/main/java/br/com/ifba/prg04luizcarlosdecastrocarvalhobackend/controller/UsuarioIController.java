package br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.controller;

import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.dto.UsuarioGetResponseDto;
import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.dto.UsuarioPostRequestDto;
import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.entity.Usuario;
import org.springframework.http.ResponseEntity;
import java.util.List;

public interface UsuarioIController {
    ResponseEntity<UsuarioGetResponseDto> save(UsuarioPostRequestDto usuarioPostRequestDto);
    ResponseEntity<List<UsuarioGetResponseDto>> findAll();
    ResponseEntity<UsuarioGetResponseDto> findById(Long id);
    ResponseEntity<Usuario> update(Long id, Usuario usuario);
    ResponseEntity<Void> delete(Long id);
}