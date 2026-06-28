package br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.controller;

import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.dto.UsuarioPostRequestDto;
import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.entity.Usuario;
import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.service.UsuarioIService;
import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.dto.UsuarioGetResponseDto;
import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.mapper.ObjectMapperUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class UsuarioController implements UsuarioIController {

    private final UsuarioIService usuarioService;


//metodo get


    @GetMapping(path = "/findall")
    public ResponseEntity<Page<UsuarioGetResponseDto>> findAll(Pageable pageable) {

        Page<Usuario> usuariosPage = this.usuarioService.findAll(pageable);
        Page<UsuarioGetResponseDto> dtosPage = usuariosPage.map(usuario ->
                ObjectMapperUtil.map(usuario, UsuarioGetResponseDto.class)
        );

        return ResponseEntity.status(HttpStatus.OK).body(dtosPage);
    }

//get

    @GetMapping(path = "/findbyid/{id}")
    public ResponseEntity<UsuarioGetResponseDto> findById(@PathVariable Long id) {
        UsuarioGetResponseDto dto = ObjectMapperUtil.map(
                this.usuarioService.findById(id),
                UsuarioGetResponseDto.class
        );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping(path = "/save")
    public ResponseEntity<UsuarioGetResponseDto> save(@RequestBody @Valid UsuarioPostRequestDto usuarioPostRequestDto) {

        Usuario usuarioEntity = ObjectMapperUtil.map(usuarioPostRequestDto, Usuario.class);
        Usuario usuarioSalvo = this.usuarioService.save(usuarioEntity);
        UsuarioGetResponseDto responseDto = ObjectMapperUtil.map(usuarioSalvo, UsuarioGetResponseDto.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }

//put

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping(path = "/update/{id}")
    public ResponseEntity<UsuarioGetResponseDto> update(@PathVariable("id") Long id, @RequestBody @Valid UsuarioPostRequestDto usuarioPostRequestDto) {
        Usuario usuarioEntity = ObjectMapperUtil.map(usuarioPostRequestDto, Usuario.class);
        Usuario usuarioAtualizado = usuarioService.update(id, usuarioEntity);
        UsuarioGetResponseDto responseDto = ObjectMapperUtil.map(usuarioAtualizado, UsuarioGetResponseDto.class);
        return ResponseEntity.ok(responseDto);
    }

//delete
@DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        usuarioService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UsuarioPostRequestDto loginDto) {
        return usuarioService.findAll(org.springframework.data.domain.Pageable.unpaged())
                .stream()
                .filter(u -> u.getLogin().equals(loginDto.getLogin()) && u.getSenha().equals(loginDto.getSenha()))
                .findFirst()
                .map(usuario -> {
                    return ResponseEntity.ok(ObjectMapperUtil.map(usuario, UsuarioGetResponseDto.class));
                })
                .orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
    }
}
