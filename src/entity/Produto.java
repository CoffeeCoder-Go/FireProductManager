/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author cliente
 */
public class Produto {
    private Long id;
    private String nome;
    private Integer quantidade;
    private Float precoUnidade;
    
    public Produto(){}

    public Produto(Long id, String nome, Integer quantidade, Float precoUnidade) {
        this.id = id;
        this.nome = nome;
        this.quantidade = quantidade;
        this.precoUnidade = precoUnidade;
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
