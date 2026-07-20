package br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.reserva.service;

import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.reserva.entity.ServicoAdicional;
import java.util.List;

public interface ServicoAdicionalIService {
    ServicoAdicional save(ServicoAdicional servico);
    List<ServicoAdicional> findAll();
    ServicoAdicional findById(Long id);
}