package br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.quarto.controller;

import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.quarto.entity.CategoriaQuarto;
import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.quarto.service.CategoriaQuartoIService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/categorias-quarto")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class CategoriaQuartoController implements CategoriaQuartoIController {

    private final CategoriaQuartoIService service;

    @Override
    @PostMapping(path = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CategoriaQuarto> save(@RequestBody CategoriaQuarto categoria) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(categoria));
    }

    @Override
    @GetMapping(path = "/findall", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CategoriaQuarto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }
}