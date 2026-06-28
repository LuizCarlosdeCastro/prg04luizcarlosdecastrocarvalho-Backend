package br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.service;

import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.entity.Reserva;
import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.entity.Usuario;
import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.repository.ReservaRepository;
import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.repository.UsuarioRepository; // 👈 Certifique-se de importar seu repositório de usuários
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

        if (reserva.getCliente() != null && reserva.getCliente().getId() != null) {
            Usuario usuarioBanco = usuarioRepository.findById(reserva.getCliente().getId())
                    .orElseThrow(() -> new RuntimeException("Usuário não encontrado no banco"));

            reserva.setCliente(usuarioBanco);
        }



        return reservaRepository.save(reserva);
    }

    @Override
    public List<Reserva> findAll() {
        return List.of();
    }
}