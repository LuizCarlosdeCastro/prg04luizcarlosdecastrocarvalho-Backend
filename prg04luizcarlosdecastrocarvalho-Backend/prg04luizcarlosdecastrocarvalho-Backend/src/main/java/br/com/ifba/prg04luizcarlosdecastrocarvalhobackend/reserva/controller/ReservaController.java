package br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.reserva.controller;

import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.reserva.entity.Reserva;
import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.reserva.service.ReservaIService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/reservas")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ReservaController implements ReservaIController {

    private final ReservaIService reservaService;

    @Override
    @PostMapping(path = "/save")
    public ResponseEntity<Reserva> save(@RequestBody Reserva reserva) {
        return ResponseEntity.status(HttpStatus.CREATED).body(reservaService.save(reserva));
    }

    @Override
    @GetMapping(path = "/findall")
    public ResponseEntity<List<Reserva>> findAll() {
        return ResponseEntity.ok(reservaService.findAll());
    }
}