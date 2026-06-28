package br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.controller;

import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.entity.Reserva;
import org.springframework.http.ResponseEntity;
import java.util.List;

public interface ReservaIController {
    ResponseEntity<Reserva> save(Reserva reserva);
    ResponseEntity<List<Reserva>> findAll();
}