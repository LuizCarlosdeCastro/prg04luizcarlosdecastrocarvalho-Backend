package br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.pagamento.service;

import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.pagamento.dto.PagamentoGetResponseDto;
import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.pagamento.dto.PagamentoPostRequestDto;
import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.pagamento.entity.Pagamento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PagamentoIService {

    Page<Pagamento> findAll(Pageable pageable);
    Pagamento findById(Long id);
    Pagamento save(Pagamento pagamento);
    Pagamento update(Long id, Pagamento pagamento);
    void delete(Long id);


    Page<PagamentoGetResponseDto> findAllWithDto(Pageable pageable);
    PagamentoGetResponseDto findByIdWithDto(Long id);
    PagamentoGetResponseDto saveDto(PagamentoPostRequestDto dto);
    PagamentoGetResponseDto updateDto(Long id, PagamentoPostRequestDto dto);
}