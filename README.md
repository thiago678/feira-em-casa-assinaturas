# Feira em Casa — Sistema de Assinatura Semanal

Este repositório contém o projeto da disciplina **Projeto de Software** (Universidade Presbiteriana Mackenzie), desenvolvido individualmente por **Thiago Azevedo Bezerra de Menezes**.

O sistema modela o caso de uso **“Assinar Serviço de Feira”**, em que um assinante contrata um plano semanal de entrega de frutas, legumes e verduras em casa, escolhe os itens da cesta, informa endereço de entrega e realiza o pagamento com cartão de crédito.   

---

## Objetivo do Projeto

Modelar e implementar, em Java, o fluxo principal de assinatura de um plano semanal de feira:

- Identificação do assinante por SMS  
- Seleção de plano de assinatura  
- Montagem da cesta da semana (frutas, legumes e verduras)  
- Definição de endereço de entrega  
- Pagamento com cartão de crédito  
- Geração de protocolo e confirmação da assinatura  

O foco é aplicar **UML**, **princípios de orientação a objetos** e **boas práticas de projeto de software**.

---

## Cenário de Uso — Assinar Serviço de Feira

- **Ator Principal:** Assinante  
- **Ator Secundário:** Operadora de Cartão de Crédito  
- **Pré-condições:**  
  - Planos de assinatura cadastrados  
  - Catálogo de produtos da semana atualizado  
- **Pós-condições:**  
  - Assinante validado e armazenado  
  - Plano de assinatura selecionado  
  - Cesta semanal configurada (frutas, legumes, verduras)  
  - Endereço de entrega armazenado  
  - Pagamento aprovado e protocolo gerado   

---

## Principais Funcionalidades (escopo)

- Cadastro e validação de **Assinante** (via número de celular + código SMS)
- Seleção de **Plano** com limites de itens por tipo (frutas, legumes, verduras)
- Consulta ao **Catálogo de Produtos** (arquivo de produtos da semana)   
- Montagem da **Cesta da Semana**, com itens do tipo `ItemCesta`
- Registro de **Endereço de Entrega**
- Registro de **Pagamento** com **Cartão**
- Geração de **Protocolo de Assinatura**

---

## Tecnologias

- **Linguagem:** Java (JDK 21)
- **Paradigma:** Orientação a Objetos
- **Modelagem:** UML (caso de uso, sequência, classes)
- **Ferramentas de diagramação:** diagrams.net (draw.io)
- **Controle de versão:** Git + GitHub

---

## Estrutura (proposta)

```text
src/
 └─ br.com.feiraemcasa/
     ├─ model/
     │   ├─ Assinante.java
     │   ├─ Plano.java
     │   ├─ Produto.java
     │   ├─ Cesta.java
     │   ├─ ItemCesta.java
     │   ├─ Pagamento.java
     │   ├─ Cartao.java
     │   ├─ Endereco.java
     │   ├─ Assinatura.java
     │   └─ Entrega.java
     ├─ service/
     │   ├─ AssinaturaService.java
     │   └─ PagamentoService.java
     └─ Main.java
