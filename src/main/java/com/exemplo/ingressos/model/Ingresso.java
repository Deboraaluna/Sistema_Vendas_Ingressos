package com.exemplo.ingressos.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "ingressos")
public class Ingresso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String tipo; // define se é VIP, pista ou camarote...

    @Column(nullable = false)
    private Double preco;

    @Column(nullable = false)
    private String status; // disponível, vendido...

    @ManyToOne
    @JoinColumn(name = "evento_id", nullable = false)
    private Evento evento;

    @Column(nullable = false)
    private LocalDate data;

    @Column(nullable = false)
    private Integer quantidade; // armazena a qtd de ingressos

    @Column(nullable = false)
    private String restricaoPublico; // restrição de público (ex: estudante, PCD, idoso)

    private String comprador;
    private String codigo;

    // Construtor para gerar código único ao criar ingresso
    public Ingresso() {
        this.codigo = UUID.randomUUID().toString(); // Geração do código único
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Evento getEvento() {
        return evento; // Este método foi corrigido
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public String getRestricaoPublico() {
        return restricaoPublico;
    }

    public void setRestricaoPublico(String restricaoPublico) {
        this.restricaoPublico = restricaoPublico;
    }

    public String getComprador() {
        return comprador; // Este método foi corrigido
    }

    public void setComprador(String comprador) {
        this.comprador = comprador;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return evento.getNome(); // O método getNome é válido se o Evento tiver este método
    }
}
