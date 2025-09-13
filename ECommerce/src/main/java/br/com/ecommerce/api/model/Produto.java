package br.com.ecommerce.api.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "produto", schema = "ecommerce")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_produto", nullable = false)
    private Integer id;

    @Column(name = "nome", nullable = false, length = Integer.MAX_VALUE)
    private String nome;

    @Column(name = "descricao", nullable = false, length = Integer.MAX_VALUE)
    private String descricao;

    @Column(name = "preco", nullable = false, precision = 18, scale = 4)
    private BigDecimal preco;

    @Column(name = "estoque_disponivel", nullable = false)
    private Integer estoqueDisponivel;

    @Column(name = "imagem_url", nullable = false, length = Integer.MAX_VALUE)
    private String imagemUrl;

}