package com.exemplo.ingressos.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "eventos")
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, length = 500)
    private String descricao;

    @ElementCollection
    @CollectionTable(name = "datas_evento", joinColumns = @JoinColumn(name = "evento_id"))
    @Column(name = "data")
    private List<LocalDate> datas;

    @Column(nullable = false)
    private String local;

    @Column(nullable = false)
    private Integer capacidade;

    // Getters e Setters
}