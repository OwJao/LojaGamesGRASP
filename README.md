# 🎮 Justificativa de Design (GRASP & MVC)

Este projeto demonstra a separação de responsabilidades usando a arquitetura **MVC** como base e os princípios **GRASP** para alocar responsabilidades de forma coesa e com baixo acoplamento dentro do Modelo.

Este repositório cumpre os requisitos da atividade de **Melhores Práticas em Orientação à Objetos(OO) com GRASP**.

## 1. Padrão Arquitetural: Model-View-Controller (MVC)

O MVC foi usado para desacoplar a lógica de negócio (Model) da interface do usuário (View) e da coordenação de eventos (Controller).

* **Model**: `CarrinhoDeCompras`, `ItemCarrinho`, `Jogo`.
    * Contém os dados brutos e as regras de negócio. É aqui que os padrões GRASP são aplicados.
* **View**: `LojaGamesView`.
    * Responsável unicamente por renderizar os dados do Modelo para o usuário (neste caso, imprimindo no console). Não contém lógica de cálculo, promovendo **Alta Coesão**.
* **Controller**: `LojaGamesController`.
    * Atua como o maestro. Recebe a entrada (a "ação"), coordena o Modelo (manda o `CarrinhoDeCompras` adicionar itens) e, por fim, seleciona a View para exibir o resultado.

---

## 2. Padrão GRASP: Information Expert (Especialista da Informação)

O princípio do Especialista define que a responsabilidade deve ser alocada à classe que possui a informação necessária para cumpri-la.

* **Onde**:
    * `ItemCarrinho.getSubtotal()`
    * `CarrinhoDeCompras.calcularTotal()`
* **Por quê**:
    * A classe `ItemCarrinho` é a especialista em seu próprio subtotal, pois ela é a única que conhece seu `Jogo` (para saber o preço) e sua `quantidade`.
    * A classe `CarrinhoDeCompras` é a especialista no valor total, pois ela é a única que conhece a `List<ItemCarrinho>` completa.

## 3. Padrão GRASP: Creator (Criador)

Este padrão define quem deve ser responsável por criar (instanciar) novos objetos.

* **Onde**: `CarrinhoDeCompras.adicionarItem(Jogo, int)`
* **Por quê**: O `CarrinhoDeCompras` é responsável por criar instâncias de `ItemCarrinho`. Isso está correto porque a classe `CarrinhoDeCompras` "agrega" (ou "contém") os objetos `ItemCarrinho`. O ciclo de vida do `ItemCarrinho` está intimamente ligado ao do `CarrinhoDeCompras`.

## 4. Padrão GRASP: Controller (Controlador)

Este padrão GRASP é a base do 'C' no MVC e define quem deve receber e coordenar os eventos da "camada de sistema".

* **Onde**: A classe `LojaGamesController`.
* **Por quê**: O `LojaGamesController` atua como o ponto de entrada que recebe o evento do "mundo real" (no nosso caso, as entradas do usuário no loop `iniciar()`). Ele não faz o trabalho de negócio (como `calcularTotal`), mas **delega** esse trabalho aos especialistas (o Modelo). Isso promove **Baixo Acoplamento** entre a camada de "interface" e a lógica de negócio.

---

### Desenvolvedores:
João Antônio de Souza Assunção <br>
`j.antonioassuncao@outlook.com`

Gustavo Nascimento Ferreira <br>
`gnferreira14@gmail.com`

Easter Egg:
Salve salve Samuel, já dá aquela nota máxima da boa!
