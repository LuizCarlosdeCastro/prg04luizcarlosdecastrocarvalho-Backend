package br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioPostRequestDto {

@JsonProperty(value = "nome")
    private String nome;

@JsonProperty(value = "email")
    private String email;

@JsonProperty(value = "login")
    private String login;

@JsonProperty(value = "senha")
    private String senha;
}
