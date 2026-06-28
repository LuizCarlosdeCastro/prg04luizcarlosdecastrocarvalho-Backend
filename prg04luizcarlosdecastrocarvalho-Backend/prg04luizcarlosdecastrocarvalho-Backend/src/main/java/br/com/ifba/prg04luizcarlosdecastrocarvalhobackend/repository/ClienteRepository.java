package br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.repository;

import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}