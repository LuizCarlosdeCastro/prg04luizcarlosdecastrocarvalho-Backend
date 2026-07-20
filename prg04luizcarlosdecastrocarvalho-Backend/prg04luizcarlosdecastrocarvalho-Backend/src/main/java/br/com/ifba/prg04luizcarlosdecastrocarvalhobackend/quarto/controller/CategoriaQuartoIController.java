package br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.quarto.controller;

import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.quarto.entity.CategoriaQuarto;
import org.springframework.http.ResponseEntity;
import java.util.List;

public interface CategoriaQuartoIController {
    ResponseEntity<CategoriaQuarto> save(CategoriaQuarto categoria);
    ResponseEntity<List<CategoriaQuarto>> findAll();
}