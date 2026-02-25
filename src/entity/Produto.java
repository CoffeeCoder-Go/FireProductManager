/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Henrique Rigoni Nunes
 */
// Modelo Produto
public class Produto {
    /*
        CREATE TABLE IF NOT EXISTS produtos (
            id INT PRIMARY KEY AUTO_INCREMENT,
            nome VARCHAR(150) UNIQUE NOT NULL,
            quantidade INTEGER NOT NULL,
            precoPorUnidade DECIMAL(10,2) NOT NULL
        );
    */
    
    private Long id;
    private String nome;
    private Integer quantidade;
    private Float precoUnidade;
    
    
    // Construtor Padrão
    public Produto(){}

    
    // Contrutor com todos os atributos
    public Produto(Long id, String nome, Integer quantidade, Float precoUnidade) {
        this.id = id;
        this.nome = nome;
        this.quantidade = quantidade;
        this.precoUnidade = precoUnidade;
    }

    // Getter e Setter
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

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Float getPrecoUnidade() {
        return precoUnidade;
    }

    public void setPrecoUnidade(Float precoUnidade) {
        this.precoUnidade = precoUnidade;
    }
    
    
}
