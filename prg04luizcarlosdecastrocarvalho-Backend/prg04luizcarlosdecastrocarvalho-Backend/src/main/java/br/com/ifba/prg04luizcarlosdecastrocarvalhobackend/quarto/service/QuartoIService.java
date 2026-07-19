package br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.quarto.service;

import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.quarto.entity.Quarto;
import java.util.List;

public interface QuartoIService {
    Quarto save(Quarto quarto);
    List<Quarto> findAll();
}