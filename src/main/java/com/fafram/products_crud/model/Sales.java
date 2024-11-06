package com.fafram.products_crud.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sales {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_venda;

    private LocalDate data;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private Client cliente;
}
