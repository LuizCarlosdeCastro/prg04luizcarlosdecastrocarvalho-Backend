package br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.reserva.controller;

import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.reserva.entity.Reserva;
import org.springframework.http.ResponseEntity;
import java.util.List;

public interface ReservaIController {
    ResponseEntity<Reserva> save(Reserva reserva);
    ResponseEntity<List<Reserva>> findAll();
}