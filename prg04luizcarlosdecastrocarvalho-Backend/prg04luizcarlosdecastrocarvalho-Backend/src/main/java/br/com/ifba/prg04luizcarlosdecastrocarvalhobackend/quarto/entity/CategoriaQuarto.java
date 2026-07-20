package br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.quarto.entity;

import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.infraestructure.entity.PersistenceEntity;
import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;

@Entity
@Table(name = "categorias_quarto")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CategoriaQuarto extends PersistenceEntity implements Serializable {

    @Column(nullable = false, unique = true)
    private String nome; // Ex: "Assombrado", "Suíte de Luxo", "Padrão"

    private String descricao;
}