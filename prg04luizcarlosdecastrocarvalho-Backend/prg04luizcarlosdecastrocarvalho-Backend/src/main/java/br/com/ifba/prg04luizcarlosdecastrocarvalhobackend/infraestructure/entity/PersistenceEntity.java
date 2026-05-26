package br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.infraestructure.entity;

import jakarta.persistence.*;
import lombok.Data;

@MappedSuperclass
@Data
public abstract class PersistenceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

}