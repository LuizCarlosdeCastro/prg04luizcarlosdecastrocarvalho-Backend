package br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.quarto.service;

import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.quarto.entity.CategoriaQuarto;
import java.util.List;

public interface CategoriaQuartoIService {
    CategoriaQuarto save(CategoriaQuarto categoria);
    List<CategoriaQuarto> findAll();
    CategoriaQuarto findById(Long id);
}