package br.com.ecommerce.api.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Setter
@Entity
@Table(name = "pedido", schema = "ecommerce")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido", nullable = false)
    private Integer id;


    @Column(name = "data_cadastro")
    private OffsetDateTime dataCadastro;

    @Column(name = "valor_total", precision = 10, scale = 4)
    private BigDecimal valorTotal;

    @Column(name = "status", length = Integer.MAX_VALUE)
    private String status;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente idCliente;
}
