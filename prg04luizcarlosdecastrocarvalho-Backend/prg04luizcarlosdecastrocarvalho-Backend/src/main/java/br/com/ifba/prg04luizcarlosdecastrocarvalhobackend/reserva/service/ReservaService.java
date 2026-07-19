package br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.reserva.service;

import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.reserva.entity.Reserva;
import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.usuario.entity.Usuario;
import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.reserva.repository.ReservaRepository;
import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.usuario.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservaService implements ReservaIService {

    private final ReservaRepository reservaRepository;
    private final UsuarioRepository usuarioRepository;

    @Override
    @Transactional
    public Reserva save(Reserva reserva) {
        // Lógica de conferência de usuário vinda do controller estabilizada aqui
        if (reserva.getCliente() != null && reserva.getCliente().getId() != null) {
            Usuario usuarioBanco = usuarioRepository.findById(reserva.getCliente().getId())
                    .orElseThrow(() -> new RuntimeException("Usuário não encontrado com o ID: " + reserva.getCliente().getId()));

            reserva.setCliente(usuarioBanco);
        }
        return reservaRepository.save(reserva);
    }

    @Override
    public List<Reserva> findAll() {
        return reservaRepository.findAll(); // Corrigido de List.of() para buscar do banco real
    }
}