/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.loja.cli;

import com.loja.model.ItemCarrinho;
import com.loja.model.Jogo;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author JOAO
 */
public class LojaGamesView {
    private Scanner scanner;

    public LojaGamesView() {
        this.scanner = new Scanner(System.in);
    }

    public int mostrarMenuPrincipal(List<Jogo> catalogo) {
        System.out.println("\n===== BEM-VINDO À LOJA DE GAMES =====");
        System.out.println("Escolha um jogo para adicionar ao carrinho:");
        
        int i = 1;
        for (Jogo jogo : catalogo) {
            System.out.printf("%d. %s - R$%.2f\n", i++, jogo.getNome(), jogo.getPreco());
        }
        System.out.println("-------------------------------------");
        System.out.println("9. Ver Carrinho e Finalizar Compra");
        System.out.println("0. Sair");
        System.out.print("Digite sua opção: ");
        
        return lerInt();
    }

    public int pedirQuantidade() {
        System.out.print("Digite a quantidade: ");
        return lerInt();
    }

    public void mostrarCarrinho(List<ItemCarrinho> itens, double total) {
        System.out.println("\n--- SEU CARRINHO DE COMPRAS ---");
        if (itens.isEmpty()) {
            System.out.println("O carrinho está vazio.");
        } else {
            for (ItemCarrinho item : itens) {
                System.out.printf("- %s (Qtd: %d) - Subtotal: R$%.2f\n",
                        item.getJogo().getNome(),
                        item.getQuantidade(),
                        item.getSubtotal());
            }
        }
        System.out.println("---------------------------------");
        System.out.printf("TOTAL DA COMPRA: R$%.2f\n", total);
    }

    public void mostrarMensagem(String msg) {
        System.out.println(msg);
    }
    
    private int lerInt() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Opção inválida. Tente novamente.");
            return -1;
        }
    }
}
