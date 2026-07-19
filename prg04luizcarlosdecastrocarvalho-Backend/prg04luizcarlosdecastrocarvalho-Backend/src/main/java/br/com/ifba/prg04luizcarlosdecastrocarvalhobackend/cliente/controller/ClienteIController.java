package br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.cliente.controller;

import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.cliente.entity.Cliente;
import org.springframework.http.ResponseEntity;
import java.util.List;

public interface ClienteIController {
    ResponseEntity<Cliente> save(Cliente cliente);
    ResponseEntity<List<Cliente>> findAll();
}