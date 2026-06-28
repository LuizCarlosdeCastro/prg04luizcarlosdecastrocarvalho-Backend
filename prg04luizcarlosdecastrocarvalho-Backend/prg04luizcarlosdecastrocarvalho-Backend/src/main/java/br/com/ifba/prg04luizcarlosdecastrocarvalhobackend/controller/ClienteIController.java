package br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.controller;

import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.entity.Cliente;
import org.springframework.http.ResponseEntity;
import java.util.List;

public interface ClienteIController {
    ResponseEntity<Cliente> save(Cliente cliente);
    ResponseEntity<List<Cliente>> findAll();
}