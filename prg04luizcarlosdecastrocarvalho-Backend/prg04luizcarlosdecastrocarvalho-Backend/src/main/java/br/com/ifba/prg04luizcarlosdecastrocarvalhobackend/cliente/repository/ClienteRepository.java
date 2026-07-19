package br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.cliente.repository;

import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.cliente.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}