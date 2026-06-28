package br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.service;

import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.entity.Pagamento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PagamentoIService {
    Page<Pagamento> findAll(Pageable pageable);
    Pagamento findById(Long id);
    Pagamento save(Pagamento pagamento);
    Pagamento update(Long id, Pagamento pagamento);
    void delete(Long id);
}