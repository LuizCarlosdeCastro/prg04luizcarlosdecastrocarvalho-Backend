package br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PagamentoGetResponseDto {

    private Long id;
    private Double valor;
    private String formaPagamento;
}