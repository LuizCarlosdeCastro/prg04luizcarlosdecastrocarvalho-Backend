package br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.reserva.controller;

import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.reserva.entity.ServicoAdicional;
import org.springframework.http.ResponseEntity;
import java.util.List;

public interface ServicoAdicionalIController {
    ResponseEntity<ServicoAdicional> save(ServicoAdicional servico);
    ResponseEntity<List<ServicoAdicional>> findAll();
}