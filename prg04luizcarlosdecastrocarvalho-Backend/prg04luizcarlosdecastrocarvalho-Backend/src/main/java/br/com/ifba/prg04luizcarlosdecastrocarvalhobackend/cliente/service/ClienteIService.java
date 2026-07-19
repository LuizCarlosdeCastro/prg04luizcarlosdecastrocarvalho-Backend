package br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.cliente.service;

import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.cliente.entity.Cliente;
import java.util.List;

public interface ClienteIService {
    Cliente save(Cliente cliente);
    List<Cliente> findAll();
}