package br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.pagamento.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PagamentoPostRequestDto {

    @NotNull(message = "O valor é obrigatório")
    @Positive(message = "O valor deve ser maior que zero")
    private Double valor;

    @NotNull(message = "A forma de pagamento é obrigatória")
    private String formaPagamento;
}