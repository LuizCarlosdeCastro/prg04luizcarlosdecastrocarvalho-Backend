package br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.entity;

import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.infraestructure.PersistenceEntity;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "usuarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)

public class Usuario extends PersistenceEntity implements Serializable {

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String senha;

    @Column(name = "tipo_usuario", nullable = false, length = 20)
    private String tipoUsuario;

    private LocalDate dataCadastro;

}