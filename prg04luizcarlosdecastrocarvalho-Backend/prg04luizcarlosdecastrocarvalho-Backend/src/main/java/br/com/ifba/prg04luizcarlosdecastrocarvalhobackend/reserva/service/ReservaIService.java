package br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.reserva.service;

import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.reserva.entity.Reserva;
import java.util.List;

public interface ReservaIService {
    Reserva save(Reserva reserva);
    List<Reserva> findAll();
}