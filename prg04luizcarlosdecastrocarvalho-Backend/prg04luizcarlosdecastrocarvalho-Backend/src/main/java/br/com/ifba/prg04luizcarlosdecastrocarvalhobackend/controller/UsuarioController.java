package br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.controller;

import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.dto.UsuarioPostRequestDto;
import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.entity.Usuario;
import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.service.UsuarioIService;
import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.dto.UsuarioGetResponseDto;
import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.dto.UsuarioPostRequestDto;
import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.mapper.ObjectMapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tools.jackson.databind.ObjectMapper;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController implements UsuarioIController {

    private final UsuarioIService usuarioService;
    private final ObjectMapper objectMapperUtil;

//metodo get

    @GetMapping(path = "/findall")
    public ResponseEntity<List<Usuario>> findAll() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(objectMapperUtil.mapAll(
                        this.usuarioService.findAll(),
                        UsuarioGetResponseDto.class));
    }

//get

    @GetMapping(path = "/findbyid/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(objectMapperUtil.mapId(this.usuarioService.findById(id),UsuarioGetResponseDto.class));
    }




    @PostMapping(
            path = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> save(@RequestBody UsuarioPostRequestDto usuarioPostRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(objectMapperUtil.map(usuarioService.save(objectMapperUtil.map(usuarioPostRequestDto, Usuario.class))), usuarioGetResponseDto.class);
    }

//put
    @Override
    @PutMapping(
            path = "/update/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Usuario> update(@PathVariable("id") Long id, @RequestBody Usuario usuario) {
        Usuario usuarioAtualizado = usuarioService.update(id, usuario);

        return ResponseEntity.ok(usuarioAtualizado);
    }

//delete
    @Override
    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        usuarioService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
