package br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Cliente extends Usuario {

    @Column(unique = true, length = 14)
    private String cpf;

    @Column(length = 20)
    private String telefone;
}