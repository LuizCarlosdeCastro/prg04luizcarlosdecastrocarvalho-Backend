package br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.pagamento.service;

import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.pagamento.dto.PagamentoGetResponseDto;
import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.pagamento.dto.PagamentoPostRequestDto;
import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.pagamento.entity.Pagamento;
import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.pagamento.repository.PagamentoRepository;
import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.mapper.ObjectMapperUtil;
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
    public Page<PagamentoGetResponseDto> findAllWithDto(Pageable pageable) {
        return this.findAll(pageable).map(pagamento -> ObjectMapperUtil.map(pagamento, PagamentoGetResponseDto.class));
    }

    @Override
    @Transactional(readOnly = true)
    public Pagamento findById(Long id) {
        return pagamentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pagamento não encontrado com o ID: " + id));
    }

    @Override
    public PagamentoGetResponseDto findByIdWithDto(Long id) {
        return ObjectMapperUtil.map(this.findById(id), PagamentoGetResponseDto.class);
    }

    @Override
    @Transactional
    public Pagamento save(Pagamento pagamento) {
        return pagamentoRepository.save(pagamento);
    }

    @Override
    public PagamentoGetResponseDto saveDto(PagamentoPostRequestDto dto) {
        Pagamento pagamentoEntity = ObjectMapperUtil.map(dto, Pagamento.class);
        Pagamento pagamentoSalvo = this.save(pagamentoEntity);
        return ObjectMapperUtil.map(pagamentoSalvo, PagamentoGetResponseDto.class);
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
    public PagamentoGetResponseDto updateDto(Long id, PagamentoPostRequestDto dto) {
        Pagamento pagamentoEntity = ObjectMapperUtil.map(dto, Pagamento.class);
        Pagamento pagamentoAtualizado = this.update(id, pagamentoEntity);
        return ObjectMapperUtil.map(pagamentoAtualizado, PagamentoGetResponseDto.class);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Pagamento pagamento = this.findById(id);
        pagamentoRepository.delete(pagamento);
    }
}