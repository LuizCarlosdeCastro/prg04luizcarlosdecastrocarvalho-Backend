package br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.service;

import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.entity.Quarto;
import java.util.List;

public interface QuartoIService {
    Quarto save(Quarto quarto);
    List<Quarto> findAll();
}