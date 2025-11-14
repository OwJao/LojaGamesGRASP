/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.loja.controller;
import com.loja.model.CarrinhoDeCompras;
import com.loja.model.ItemCarrinho;
import com.loja.model.Jogo;
import com.loja.cli.LojaGamesView;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gustavo
 */
public class LojaGamesController {
    
    private CarrinhoDeCompras carrinho;
    private LojaGamesView view;
    private List<Jogo> catalogo; // Simula um banco de dados de jogos

    public LojaGamesController() {
        this.carrinho = new CarrinhoDeCompras();
        this.view = new LojaGamesView();
        this.catalogo = new ArrayList<>();
        carregarCatalogo();
    }

    // Simula a carga de jogos do banco de dados
    private void carregarCatalogo() {
        catalogo.add(new Jogo("Elden Ring - Shadow of the Erdtree", 299.90));
        catalogo.add(new Jogo("Cyberpunk 2077 - Ultimate Edition", 220.50));
        catalogo.add(new Jogo("Stardew Valley", 24.99));
    }

    // Método principal que roda a aplicação (o "loop" do sistema)
    public void iniciar() {
        boolean rodando = true;
        while (rodando) {
            // 1. Controller pede para View mostrar o menu
            int escolha = view.mostrarMenuPrincipal(catalogo);
            
            // 2. Controller processa a escolha
            switch (escolha) {
                case 1:
                case 2:
                case 3:
                    if (escolha > 0 && escolha <= catalogo.size()) {
                        adicionarJogo(catalogo.get(escolha - 1));
                    } else {
                        view.mostrarMensagem("Jogo inválido.");
                    }
                    break;
                case 9:
                    finalizarCompra();
                    break;
                case 0:
                    rodando = false;
                    view.mostrarMensagem("Obrigado por comprar conosco!");
                    break;
                default:
                    view.mostrarMensagem("Opção inválida. Tente novamente.");
            }
        }
    }

    // Ação de adicionar um jogo
    private void adicionarJogo(Jogo jogo) {
        // 1. Controller pede dados para a View
        int quantidade = view.pedirQuantidade();
        
        if (quantidade > 0) {
            // 2. Controller DELEGA a lógica para o Model (Creator)
            carrinho.adicionarItem(jogo, quantidade);
            
            // 3. Controller informa a View para dar feedback
            view.mostrarMensagem(quantidade + "x " + jogo.getNome() + " adicionado(s)!");
        } else {
            view.mostrarMensagem("Quantidade inválida.");
        }
    }

    // Ação de finalizar a compra
    private void finalizarCompra() {
        // 1. Controller busca dados do Model (Information Experts)
        List<ItemCarrinho> itens = carrinho.getItens();
        double total = carrinho.calcularTotal(); // Delega o cálculo!
        
        // 2. Controller envia os dados prontos para a View exibir
        view.mostrarCarrinho(itens, total);
    }
    
}
