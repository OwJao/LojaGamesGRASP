/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.loja.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JOAO
 */
public class CarrinhoDeCompras {
    private List<ItemCarrinho> itens = new ArrayList<>();

    /**
     * padrão GRASP: Creator
     * a class CarrinhoDeCompras é responsável por criar o ItemCarrinho pois ele "contém" os itens
     */
    public void adicionarItem(Jogo jogo, int quantidade) {
        ItemCarrinho item = new ItemCarrinho(jogo, quantidade);
        itens.add(item);
    }

    // aqui retorna uma cópia da lista para a view poder mostrar no console
    public List<ItemCarrinho> getItens() {
        return new ArrayList<>(itens);
    }

    /**
     * padrão GRASP: Information Expert
     * essa classe é pra especialista em calcular o total do carrinho pq ela possui a lista dos itens
     */
    public double calcularTotal() {
        double total = 0;
        for (ItemCarrinho item : itens) {
            total += item.getSubtotal(); // chama função do ItemCarrinho pra dar trabalho pra ela
        }
        return total;
    }
}
