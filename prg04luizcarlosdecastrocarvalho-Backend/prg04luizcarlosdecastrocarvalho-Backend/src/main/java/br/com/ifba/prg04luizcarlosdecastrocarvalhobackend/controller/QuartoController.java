package br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.controller;

import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.entity.Quarto;
import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.service.QuartoIService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/quartos")
@RequiredArgsConstructor
public class QuartoController implements QuartoIController {

    private final QuartoIService quartoService;

    @Override
    @PostMapping(path = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Quarto> save(@RequestBody Quarto quarto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(quartoService.save(quarto));
    }

    @Override
    @GetMapping(path = "/findall", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Quarto>> findAll() {
        return ResponseEntity.ok(quartoService.findAll());
    }
}