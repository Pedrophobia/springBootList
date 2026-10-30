package com.lab.mvc.springbootlist.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome do produto é obrigatório.")
    @Size(max = 60, message = "O nome deve ter no máximo 60 caracteres.")
    @Column(name = "nome", nullable = false, length = 60)
    private String nome;

    @NotBlank(message = "A marca é obrigatória.")
    @Size(min = 2, max = 45, message = "A marca deve ter entre 2 e 45 caracteres.")
    @Column(name = "marca", nullable = false, length = 45)
    private String marca;

    @NotBlank(message = "O país de fabricação é obrigatório.")
    @Size(min = 3, max = 60, message = "O país deve ter entre 3 e 60 caracteres.")
    @Column(name = "pais_fabricacao", nullable = false, length = 60)
    private String paisFabricacao;

    @NotNull(message = "O preço é obrigatório.")
    @DecimalMin(value = "0.01", message = "O preço deve ser maior que zero.")
    @Column(name = "preco", nullable = false, precision = 10, scale = 2)
    private BigDecimal preco;

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getPaisFabricacao() {
        return paisFabricacao;
    }

    public void setPaisFabricacao(String paisFabricacao) {
        this.paisFabricacao = paisFabricacao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }
}
