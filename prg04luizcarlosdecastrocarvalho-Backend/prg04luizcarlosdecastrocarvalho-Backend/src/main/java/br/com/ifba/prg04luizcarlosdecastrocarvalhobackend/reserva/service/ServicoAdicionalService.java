package br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.reserva.service;

import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.reserva.entity.ServicoAdicional;
import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.reserva.repository.ServicoAdicionalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ServicoAdicionalService implements ServicoAdicionalIService {

    private final ServicoAdicionalRepository repository;

    @Override
    @Transactional
    public ServicoAdicional save(ServicoAdicional servico) {
        return repository.save(servico);
    }

    @Override
    public List<ServicoAdicional> findAll() {
        return repository.findAll();
    }

    @Override
    public ServicoAdicional findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Serviço adicional não encontrado com o ID: " + id));
    }
}