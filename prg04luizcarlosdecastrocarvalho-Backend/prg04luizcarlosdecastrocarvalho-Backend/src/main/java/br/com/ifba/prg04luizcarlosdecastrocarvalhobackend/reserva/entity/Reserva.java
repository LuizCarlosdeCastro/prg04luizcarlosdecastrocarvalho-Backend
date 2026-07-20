package br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.reserva.entity;

import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.infraestructure.entity.PersistenceEntity;
import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.pagamento.entity.Pagamento;
import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.quarto.entity.Quarto;
import br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.usuario.entity.Usuario;
import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "reservas")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Reserva extends PersistenceEntity implements Serializable {

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "cliente_id", nullable = false)
    private Usuario cliente;

    @ManyToOne
    @JoinColumn(name = "quarto_id", nullable = false)
    private Quarto quarto;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pagamento_id", referencedColumnName = "id")
    private Pagamento pagamento;

    @Column(nullable = false)
    private LocalDate dataCheckIn;

    @Column(nullable = false)
    private LocalDate dataCheckOut;

    private String status = "RESERVADO";

    @ManyToMany
    @JoinTable(
            name = "reserva_servicos",
            joinColumns = @JoinColumn(name = "reserva_id"),
            inverseJoinColumns = @JoinColumn(name = "servico_id")
    )
    private List<ServicoAdicional> servicosAdicionais;
}