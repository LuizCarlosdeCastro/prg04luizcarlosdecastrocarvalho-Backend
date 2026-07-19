package br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.client;

import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.usuario.dto.UsuarioPostRequestDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Log4j2
public class SpringClient {

    public static void main(String[] args) {
        WebClient webClient = WebClient.builder()
                .baseUrl("http://localhost:8080/usuarios")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();

        UsuarioPostRequestDto usuarioPostRequestDto = new UsuarioPostRequestDto();
        usuarioPostRequestDto.setNome("Joao");
        usuarioPostRequestDto.setEmail("joao@gmail.com");
        usuarioPostRequestDto.setLogin("joao");
        usuarioPostRequestDto.setSenha("123456");
        usuarioPostRequestDto.setTipoUsuario("COMUM");

        String response = webClient.post()
                .uri("/save")
                .body(Mono.just(usuarioPostRequestDto), UsuarioPostRequestDto.class)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        log.info(response);
    }
}