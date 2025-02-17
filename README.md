# BancoFuctura
 Criação de um crud banco - projeto de entrega Mod-1 java Fuctura

- Projetos Práticos
    - Projeto FucturaBank
        
        ## **Classe Abstrata `Conta`**
        
        Crie uma classe abstrata `Conta` que servirá como base para os diferentes tipos de conta.
        
        ### **Atributos**
        
        - **Número da Conta**
        - **Nome do Titular**
        - **Saldo Disponível**
        
        ### **Métodos**
        
        - `exibirDados()`: Exibe as informações da conta.
        - `depositar(double valor)`: Adiciona um valor ao saldo da conta.
        - `getSaldo()`: Retorna o saldo atual da conta.
        - `alterarSaldo(double valor)`: Método protegido para alterar o saldo (não pode ser alterado diretamente).
        - `getters e setters` para os atributos necessários.
        
        ---
        
        ## **Interface `Tarifavel`**
        
        Crie uma interface chamada `Tarifavel` para representar contas que podem sofrer cobranças bancárias.
        
        ### **Métodos**
        
        - `void aplicarTarifaMensal(double valor)`: Aplica uma tarifa mensal à conta.
        - `void cobrarTaxa(double valor)`: Aplica uma cobrança única à conta.
        
        ---
        
        ## **Classes Concretas**
        
        ### **🔹 `ContaCorrente`** (Herda de `Conta` e Implementa `Tarifavel`)
        
        A classe `ContaCorrente` representa contas que permitem saques e movimentações.
        
        ### **Requisitos:**
        
        ✅ Deve herdar todos os métodos e atributos da classe `Conta`.
        
        ✅ Implementa a interface `Tarifavel`, permitindo a aplicação de tarifas e taxas.
        
        ✅ Deve possuir um método `sacar(double valor)`, que além do valor sacado, aplica uma **taxa fixa por saque**.
        
        ✅ Deve possuir um método `aplicar(double valor)`, que transfere valores para a `ContaPoupanca`.
        
        ---
        
        ### **🔹 `ContaPoupanca`** (Herda de `Conta`)
        
        A classe `ContaPoupanca` representa contas destinadas à economia, sem saques diretos.
        
        ### **Requisitos:**
        
        ✅ Deve herdar todos os métodos e atributos da classe `Conta`.
        
        ✅ Não permite depósitos e saques diretamente. O dinheiro só pode ser movimentado para ou a partir de uma `ContaCorrente`, utilizando os métodos:
        
        - `resgatar(double valor)`: Transfere dinheiro da poupança para a conta corrente.
        - `aplicar(double valor)`: Método da conta corrente para transferir dinheiro para a poupança.
        
        ---
        
        ## **Classe `Principal` (Método `main`)**
        
        Crie uma classe `Principal` que será o ponto de entrada do sistema.
        
        ### **Funcionalidades:**
        
        1️⃣ **Cadastro de Conta**
        
        - O sistema deverá solicitar o nome do titular e gerar um número aleatório para a conta.
        - O usuário poderá escolher entre abrir uma **Conta Corrente** ou **Conta Poupança**.
        
        2️⃣ **Depósito Inicial Opcional**
        
        - O cliente poderá iniciar com saldo **R$ 0,00** ou definir um valor inicial para depósito.
        
        3️⃣ **Operações Bancárias**
        
        - O usuário poderá escolher entre:
        
        ✅ **Sacar (aplicando taxa fixa, se for Conta Corrente)**
        
        ✅ **Depositar**
        
        ✅ **Aplicar dinheiro na Conta Poupança**
        
        ✅ **Resgatar dinheiro da Conta Poupança para Conta Corrente**
        
        ✅ **Visualizar saldo e detalhes da conta**
        
        ---
        
        ## **Observação: Uso Opcional de `enum`**
        
        Para melhorar a organização do código, você pode utilizar **enums**, mas isso é opcional. Algumas sugestões:
        
        ### 🔹 **Enum `TaxaBancaria`**
        
        - Para armazenar valores fixos, como **taxa de saque** e **tarifa mensal padrão**.
        
        ### 🔹 **Enum `TipoConta`**
        
        - Para diferenciar entre **Conta Corrente** e **Conta Poupança**.
        
        ### 🔹 **Enum `MensagemOperacao`**
        
        - Para centralizar mensagens como "Saque realizado com sucesso" ou "Saldo insuficiente".
        
        O uso de `enum` pode facilitar a manutenção do código, evitando valores "mágicos".
        
        ---
        
        **REGRAS:**
        
        **1.** O atributo **`saldo`** não deverá ser alterado diretamente. Será preciso criar um método para sua manipulação.
        
        **2.** A primeira ação que deverá ser feita é o cadastro de uma conta. 
        Implemente uma lógica para a criação da Conta. 
        Solicite ao cliente o nome do titular e crie um **número aleatório** para a conta.
        
        **3.** No momento do cadastro, deverá ser perguntado ao cliente se deseja fazer um depósito inicial. 
        As contas poderão ser criadas com saldo R$ 0.00 ou com o valor de depósito inicial.
        
        **4.** A **`Conta-Poupança`** não aceitará saques e depósitos diretamente. Para que seja possível depositar ou sacar da **`Conta-Poupança`**, implemente uma lógica utilizando os métodos para resgate e aplicação, respectivamente.