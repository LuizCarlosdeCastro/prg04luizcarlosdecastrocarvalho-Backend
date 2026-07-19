package br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.reserva.repository;

import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.reserva.entity.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {
}