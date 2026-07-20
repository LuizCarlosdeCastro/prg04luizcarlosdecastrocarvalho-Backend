package br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.reserva.controller;

import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.reserva.entity.ServicoAdicional;
import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.reserva.service.ServicoAdicionalIService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/servicos-adicionais")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ServicoAdicionalController implements ServicoAdicionalIController {

    private final ServicoAdicionalIService service;

    @Override
    @PostMapping(path = "/save")
    public ResponseEntity<ServicoAdicional> save(@RequestBody ServicoAdicional servico) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(servico));
    }

    @Override
    @GetMapping(path = "/findall")
    public ResponseEntity<List<ServicoAdicional>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }
}