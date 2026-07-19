package br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.pagamento.entity;

import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.infraestructure.entity.PersistenceEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "pagamentos")
@Getter
@Setter
public class Pagamento extends PersistenceEntity {

    private Double valor;
    private String formaPagamento;
}