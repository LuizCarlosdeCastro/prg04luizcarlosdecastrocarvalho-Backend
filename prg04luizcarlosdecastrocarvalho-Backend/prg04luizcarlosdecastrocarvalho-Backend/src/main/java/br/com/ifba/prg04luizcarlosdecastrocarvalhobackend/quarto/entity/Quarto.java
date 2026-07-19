package br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.quarto.entity;

import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.infraestructure.entity.PersistenceEntity;
import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.usuario.entity.Usuario;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "quartos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Quarto extends PersistenceEntity {

    @ManyToOne
    @JoinColumn(name = "usuario_cadastro_id")
    private Usuario usuarioCadastro;

    @Column(nullable = false, unique = true)
    private String numero;

    @Column(nullable = false)
    private String tipo;

    @Column(nullable = false)
    private Double precoDiaria;
}