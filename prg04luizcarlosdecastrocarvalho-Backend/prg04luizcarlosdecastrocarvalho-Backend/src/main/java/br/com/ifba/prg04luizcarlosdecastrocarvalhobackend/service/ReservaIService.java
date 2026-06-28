package br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.service;

import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.entity.Reserva;
import java.util.List;

public interface ReservaIService {
    Reserva save(Reserva reserva);
    List<Reserva> findAll();
}