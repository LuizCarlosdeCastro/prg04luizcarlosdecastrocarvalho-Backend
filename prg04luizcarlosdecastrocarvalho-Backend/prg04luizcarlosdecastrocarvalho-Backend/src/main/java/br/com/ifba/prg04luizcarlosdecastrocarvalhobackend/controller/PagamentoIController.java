package br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.controller;

import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.dto.PagamentoGetResponseDto;
import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.dto.PagamentoPostRequestDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface PagamentoIController {
    ResponseEntity<Page<PagamentoGetResponseDto>> findAll(Pageable pageable);
    ResponseEntity<PagamentoGetResponseDto> findById(Long id);
    ResponseEntity<PagamentoGetResponseDto> save(PagamentoPostRequestDto dto);
    ResponseEntity<PagamentoGetResponseDto> update(Long id, PagamentoPostRequestDto dto);
    ResponseEntity<Void> delete(Long id);
}