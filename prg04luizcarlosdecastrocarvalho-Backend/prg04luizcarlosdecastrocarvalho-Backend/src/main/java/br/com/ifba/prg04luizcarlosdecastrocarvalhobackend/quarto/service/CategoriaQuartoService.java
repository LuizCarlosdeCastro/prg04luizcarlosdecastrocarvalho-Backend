package br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.quarto.service;

import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.quarto.entity.CategoriaQuarto;
import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.quarto.repository.CategoriaQuartoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CategoriaQuartoService implements CategoriaQuartoIService {

    private final CategoriaQuartoRepository repository;

    @Override
    @Transactional
    public CategoriaQuarto save(CategoriaQuarto categoria) {
        return repository.save(categoria);
    }

    @Override
    public List<CategoriaQuarto> findAll() {
        return repository.findAll();
    }

    @Override
    public CategoriaQuarto findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada com o ID: " + id));
    }
}