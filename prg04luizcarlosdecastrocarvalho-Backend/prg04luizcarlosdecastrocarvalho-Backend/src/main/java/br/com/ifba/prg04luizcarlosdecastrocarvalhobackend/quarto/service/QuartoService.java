package br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.quarto.service;

import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.quarto.entity.Quarto;
import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.quarto.repository.QuartoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class QuartoService implements QuartoIService {

    private final QuartoRepository quartoRepository;

    @Override
    public Quarto save(Quarto quarto) {
        return quartoRepository.save(quarto);
    }

    @Override
    public List<Quarto> findAll() {
        return quartoRepository.findAll();
    }
}