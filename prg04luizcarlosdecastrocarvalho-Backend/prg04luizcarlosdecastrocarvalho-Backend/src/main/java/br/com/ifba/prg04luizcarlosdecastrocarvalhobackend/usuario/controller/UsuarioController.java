package br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.usuario.controller;

import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.usuario.dto.UsuarioPostRequestDto;
import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.usuario.dto.UsuarioGetResponseDto;
import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.usuario.service.UsuarioIService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class UsuarioController implements UsuarioIController {

    private final UsuarioIService usuarioService;

    @GetMapping(path = "/findall")
    public ResponseEntity<Page<UsuarioGetResponseDto>> findAll(Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(this.usuarioService.findAllWithDto(pageable));
    }

    @GetMapping(path = "/findbyid/{id}")
    public ResponseEntity<UsuarioGetResponseDto> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(this.usuarioService.findByIdWithDto(id));
    }

    @PostMapping(path = "/save")
    public ResponseEntity<UsuarioGetResponseDto> save(@RequestBody @Valid UsuarioPostRequestDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.usuarioService.saveDto(dto));
    }

    @PutMapping(path = "/update/{id}")
    public ResponseEntity<UsuarioGetResponseDto> update(@PathVariable("id") Long id, @RequestBody @Valid UsuarioPostRequestDto dto) {
        return ResponseEntity.ok(this.usuarioService.updateDto(id, dto));
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        usuarioService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("/login")
    public ResponseEntity<UsuarioGetResponseDto> login(@RequestBody UsuarioPostRequestDto loginDto) {
        UsuarioGetResponseDto response = usuarioService.login(loginDto);
        if (response == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        return ResponseEntity.ok(response);
    }
}