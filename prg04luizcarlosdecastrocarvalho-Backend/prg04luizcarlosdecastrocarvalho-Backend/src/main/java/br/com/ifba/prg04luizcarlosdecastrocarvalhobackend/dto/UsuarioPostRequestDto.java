package br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioPostRequestDto {

    @JsonProperty(value = "nome")
    @NotBlank(message = "O nome é obrigatório")
    @NotNull(message = "O nome não pode ser vazio")
    private String nome;

    @NotBlank(message = "O email é obrigatório")
    @NotNull(message = "O email não pode ser vazio")
    @Email(message = "O email deve ser válido")
    @JsonProperty(value = "email")
    private String email;

    @NotBlank(message = "O login é obrigatório")
    @NotNull(message = "O login não pode ser vazio")
    @JsonProperty(value = "login")
    private String login;

    @NotBlank(message = "A senha é obrigatória")
    @NotNull(message = "A senha não pode ser vazio")
    @JsonProperty(value = "senha")
    private String senha;

    @NotBlank(message = "O tipo de usuário é obrigatório")
    @NotNull(message = "O tipo de usuário não pode ser vazio")
    @JsonProperty(value = "tipoUsuario")
    private String tipoUsuario;
}
