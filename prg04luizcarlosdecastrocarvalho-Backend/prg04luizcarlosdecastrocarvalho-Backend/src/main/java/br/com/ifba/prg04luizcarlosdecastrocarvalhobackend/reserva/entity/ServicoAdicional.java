package br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.reserva.entity;

import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.infraestructure.entity.PersistenceEntity;
import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;

@Entity
@Table(name = "servicos_adicionais")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ServicoAdicional extends PersistenceEntity implements Serializable {

    @Column(nullable = false, unique = true)
    private String nome; // Ex: "Sessão Caça-Fantasmas", "Café da manhã"

    @Column(nullable = false)
    private Double preco;
}