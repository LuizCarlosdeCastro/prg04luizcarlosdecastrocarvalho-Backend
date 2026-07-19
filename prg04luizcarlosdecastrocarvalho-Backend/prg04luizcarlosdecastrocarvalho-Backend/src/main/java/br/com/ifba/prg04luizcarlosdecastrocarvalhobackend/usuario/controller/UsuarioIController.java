package br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.usuario.controller;

import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.usuario.dto.UsuarioGetResponseDto;
import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.usuario.dto.UsuarioPostRequestDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface UsuarioIController {
    ResponseEntity<UsuarioGetResponseDto> save(UsuarioPostRequestDto usuarioPostRequestDto);
    ResponseEntity<Page<UsuarioGetResponseDto>> findAll(Pageable pageable);
    ResponseEntity<UsuarioGetResponseDto> findById(Long id);
    ResponseEntity<UsuarioGetResponseDto> update(Long id, UsuarioPostRequestDto usuarioPostRequestDto);
    ResponseEntity<Void> delete(Long id);
    ResponseEntity<?> login(@RequestBody UsuarioPostRequestDto loginDto);
}