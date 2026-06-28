package br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.service;

import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.entity.Pagamento;
import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.repository.PagamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PagamentoService implements PagamentoIService {

    private final PagamentoRepository pagamentoRepository;

    @Override
    @Transactional(readOnly = true)
    public Page<Pagamento> findAll(Pageable pageable) {
        return pagamentoRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Pagamento findById(Long id) {
        return pagamentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pagamento não encontrado com o ID: " + id));
    }

    @Override
    @Transactional
    public Pagamento save(Pagamento pagamento) {
        return pagamentoRepository.save(pagamento);
    }

    @Override
    @Transactional
    public Pagamento update(Long id, Pagamento pagamento) {
        Pagamento pagamentoExistente = this.findById(id);
        pagamentoExistente.setValor(pagamento.getValor());
        pagamentoExistente.setFormaPagamento(pagamento.getFormaPagamento());
        return pagamentoRepository.save(pagamentoExistente);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Pagamento pagamento = this.findById(id);
        pagamentoRepository.delete(pagamento);
    }
}