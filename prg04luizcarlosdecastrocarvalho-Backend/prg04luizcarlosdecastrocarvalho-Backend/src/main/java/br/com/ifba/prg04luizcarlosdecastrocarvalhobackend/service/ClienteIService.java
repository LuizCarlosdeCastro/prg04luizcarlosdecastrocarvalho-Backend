package br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.service;

import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.entity.Cliente;
import java.util.List;

public interface ClienteIService {
    Cliente save(Cliente cliente);
    List<Cliente> findAll();
}