package br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.cliente.service;

import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.cliente.entity.Cliente;
import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.cliente.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteService implements ClienteIService {

    private final ClienteRepository clienteRepository;

    @Override
    @Transactional
    public Cliente save(Cliente cliente) {
        if (cliente.getCpf() != null && cliente.getCpf().isEmpty()) {
            throw new RuntimeException("O CPF não pode estar vazio");
        }
        return clienteRepository.save(cliente);
    }

    @Override
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }
}