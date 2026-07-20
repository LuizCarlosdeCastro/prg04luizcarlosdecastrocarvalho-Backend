package br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.quarto.repository;

import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.quarto.entity.CategoriaQuarto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaQuartoRepository extends JpaRepository<CategoriaQuarto, Long> {
}