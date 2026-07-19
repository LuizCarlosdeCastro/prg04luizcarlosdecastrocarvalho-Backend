package br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.quarto.repository;

import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.quarto.entity.Quarto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuartoRepository extends JpaRepository<Quarto, Long> {
}