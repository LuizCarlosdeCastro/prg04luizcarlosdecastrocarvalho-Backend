package br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.controller;

import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.dto.PagamentoGetResponseDto;
import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.dto.PagamentoPostRequestDto;
import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.entity.Pagamento;
import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.service.PagamentoIService;
import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.mapper.ObjectMapperUtil;
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
public class PagamentoController implements PagamentoIController {

    private final PagamentoIService pagamentoService;

    @Override
    @GetMapping(path = "/findall")
    public ResponseEntity<Page<PagamentoGetResponseDto>> findAll(Pageable pageable) {
        Page<Pagamento> pagamentosPage = this.pagamentoService.findAll(pageable);
        Page<PagamentoGetResponseDto> dtosPage = pagamentosPage.map(pagamento ->
                ObjectMapperUtil.map(pagamento, PagamentoGetResponseDto.class)
        );
        return ResponseEntity.status(HttpStatus.OK).body(dtosPage);
    }

    @Override
    @GetMapping(path = "/findbyid/{id}")
    public ResponseEntity<PagamentoGetResponseDto> findById(@PathVariable Long id) {
        PagamentoGetResponseDto dto = ObjectMapperUtil.map(
                this.pagamentoService.findById(id),
                PagamentoGetResponseDto.class
        );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @Override
    @PostMapping(path = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PagamentoGetResponseDto> save(@RequestBody @Valid PagamentoPostRequestDto dto) {
        Pagamento pagamentoEntity = ObjectMapperUtil.map(dto, Pagamento.class);
        Pagamento pagamentoSalvo = this.pagamentoService.save(pagamentoEntity);
        PagamentoGetResponseDto responseDto = ObjectMapperUtil.map(pagamentoSalvo, PagamentoGetResponseDto.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }

    @Override
    @PutMapping(path = "/update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PagamentoGetResponseDto> update(@PathVariable("id") Long id, @RequestBody @Valid PagamentoPostRequestDto dto) {
        Pagamento pagamentoEntity = ObjectMapperUtil.map(dto, Pagamento.class);
        Pagamento pagamentoAtualizado = pagamentoService.update(id, pagamentoEntity);
        PagamentoGetResponseDto responseDto = ObjectMapperUtil.map(pagamentoAtualizado, PagamentoGetResponseDto.class);
        return ResponseEntity.ok(responseDto);
    }

    @Override
    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        pagamentoService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}