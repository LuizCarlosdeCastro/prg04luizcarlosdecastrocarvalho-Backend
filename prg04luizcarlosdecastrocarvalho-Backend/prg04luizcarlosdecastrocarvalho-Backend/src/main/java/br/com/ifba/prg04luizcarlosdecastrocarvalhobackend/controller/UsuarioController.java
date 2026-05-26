package br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.controller;

import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.dto.UsuarioPostRequestDto;
import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.entity.Usuario;
import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.service.UsuarioIService;
import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.dto.UsuarioGetResponseDto;
import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.mapper.ObjectMapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController implements UsuarioIController {

    private final UsuarioIService usuarioService;


//metodo get


    @GetMapping(path = "/findall")
    public ResponseEntity<List<UsuarioGetResponseDto>> findAll() {
        List<UsuarioGetResponseDto> dtos = ObjectMapperUtil.mapList(
                this.usuarioService.findAll(),
                UsuarioGetResponseDto.class
        );
        return ResponseEntity.status(HttpStatus.OK).body(dtos);
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




    @PostMapping(path = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UsuarioGetResponseDto> save(@RequestBody UsuarioPostRequestDto usuarioPostRequestDto) {

        Usuario usuarioEntity = ObjectMapperUtil.map(usuarioPostRequestDto, Usuario.class);
        Usuario usuarioSalvo = this.usuarioService.save(usuarioEntity);
        UsuarioGetResponseDto responseDto = ObjectMapperUtil.map(usuarioSalvo, UsuarioGetResponseDto.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }

//put

    @PutMapping(path = "/update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Usuario> update(@PathVariable("id") Long id, @RequestBody Usuario usuario) {
        Usuario usuarioAtualizado = usuarioService.update(id, usuario);
        return ResponseEntity.ok(usuarioAtualizado);
    }

//delete
@DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        usuarioService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
