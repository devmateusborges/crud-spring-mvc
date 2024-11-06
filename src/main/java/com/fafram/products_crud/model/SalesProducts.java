package com.fafram.products_crud.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SalesProducts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_venda", nullable = false)
    private Sales sales;

    @ManyToOne
    @JoinColumn(name = "id_produto", nullable = false)
    private Product product;

    private Integer quantidade;
}
