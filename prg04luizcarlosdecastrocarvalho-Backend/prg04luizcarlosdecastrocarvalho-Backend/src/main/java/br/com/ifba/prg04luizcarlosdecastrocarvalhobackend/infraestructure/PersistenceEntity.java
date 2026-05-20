package br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.infraestructure;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@MappedSuperclass
@Data
public abstract class PersistenceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

}