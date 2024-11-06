package com.fafram.products_crud.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_produto;

    private String descricao;
    private Double preco;
    private Integer quantidade_estoque;

    @ManyToOne
    @JoinColumn(name = "id_categoria", nullable = false)
    private Category category;
}
