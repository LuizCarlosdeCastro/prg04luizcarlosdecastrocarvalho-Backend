package br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.pagamento.controller;

import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.pagamento.dto.PagamentoGetResponseDto;
import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.pagamento.dto.PagamentoPostRequestDto;
import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.pagamento.service.PagamentoIService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pagamentos")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class PagamentoController implements PagamentoIController {

    private final PagamentoIService pagamentoService;

    @Override
    @GetMapping(path = "/findall")
    public ResponseEntity<Page<PagamentoGetResponseDto>> findAll(Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(this.pagamentoService.findAllWithDto(pageable));
    }

    @Override
    @GetMapping(path = "/findbyid/{id}")
    public ResponseEntity<PagamentoGetResponseDto> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(this.pagamentoService.findByIdWithDto(id));
    }

    @Override
    @PostMapping(path = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PagamentoGetResponseDto> save(@RequestBody @Valid PagamentoPostRequestDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.pagamentoService.saveDto(dto));
    }

    @Override
    @PutMapping(path = "/update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PagamentoGetResponseDto> update(@PathVariable("id") Long id, @RequestBody @Valid PagamentoPostRequestDto dto) {
        return ResponseEntity.ok(this.pagamentoService.updateDto(id, dto));
    }

    @Override
    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        pagamentoService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}