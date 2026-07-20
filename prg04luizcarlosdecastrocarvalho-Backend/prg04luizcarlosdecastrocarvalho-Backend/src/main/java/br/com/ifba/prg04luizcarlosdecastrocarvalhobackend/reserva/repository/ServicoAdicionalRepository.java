package br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.reserva.repository;

import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.reserva.entity.ServicoAdicional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicoAdicionalRepository extends JpaRepository<ServicoAdicional, Long> {
}