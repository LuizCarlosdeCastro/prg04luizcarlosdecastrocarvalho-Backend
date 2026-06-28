package br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.controller;

import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.entity.Quarto;
import org.springframework.http.ResponseEntity;
import java.util.List;

public interface QuartoIController {
    ResponseEntity<Quarto> save(Quarto quarto);
    ResponseEntity<List<Quarto>> findAll();
}
