package br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.controller;

import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.entity.Reserva;
import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.entity.Usuario;
import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.repository.UsuarioRepository;
import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.service.ReservaIService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/reservas")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ReservaController implements ReservaIController {

    private final ReservaIService reservaService;
    private final UsuarioRepository usuarioRepository;


    @Override
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping(path = "/save")
    public ResponseEntity<Reserva> save(@RequestBody Reserva reserva) {

        if (reserva.getCliente() != null && reserva.getCliente().getId() != null) {

            Usuario usuarioBanco = usuarioRepository.findById(reserva.getCliente().getId())
                    .orElseThrow(() -> new RuntimeException("Usuário não encontrado com o ID: " + reserva.getCliente().getId()));

            reserva.setCliente(usuarioBanco);
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(reservaService.save(reserva));
    }

    @Override
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping(path = "/findall")
    public ResponseEntity<List<Reserva>> findAll() {
        return ResponseEntity.ok(reservaService.findAll());
    }
}