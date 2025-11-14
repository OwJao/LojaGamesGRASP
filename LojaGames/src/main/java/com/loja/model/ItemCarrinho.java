/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.loja.model;

/**
 *
 * @author JOAO
 */
public class ItemCarrinho {
    private Jogo jogo;
    private int quantidade;

    public ItemCarrinho(Jogo jogo, int quantidade) {
        this.jogo = jogo;
        this.quantidade = quantidade;
    }

    public Jogo getJogo() {
        return jogo;
    }

    public void setJogo(Jogo jogo) {
        this.jogo = jogo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    /*
     * padrão GRASP: Information Expert
     * essa classe é pra ser a especialista em calcular o subtotal.
     */
    public double getSubtotal() {
        return jogo.getPreco() * quantidade;
    }
}
