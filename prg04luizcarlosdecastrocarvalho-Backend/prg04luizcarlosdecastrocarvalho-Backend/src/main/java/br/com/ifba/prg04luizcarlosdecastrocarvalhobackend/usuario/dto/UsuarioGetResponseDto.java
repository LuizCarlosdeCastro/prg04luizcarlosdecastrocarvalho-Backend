package br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.usuario.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioGetResponseDto {

    @JsonProperty(value = "id")
    private Long id;

    @JsonProperty(value = "nome")
    private String nome;

    @JsonProperty(value = "email")
    private String email;

    @JsonProperty(value = "login")
    private String login;

    @JsonProperty(value = "tipoUsuario")
    private String tipoUsuario;


}
