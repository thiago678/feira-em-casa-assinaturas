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

## 🧩 Relação entre o Modelo Lógico (SQL) e as Classes Java

O projeto *Feira em Casa* segue um modelo orientado a objetos na aplicação Java, 
enquanto o banco de dados utiliza um modelo relacional.  
A tabela abaixo explica como cada classe se transforma em entidades SQL.

---

### **1. Classe: Assinante.java → Tabela: Assinante**
Armazena os dados pessoais do cliente que realiza a assinatura.

**Atributos no Java:**  
- idAssinante  
- nome  
- celular  
- email  

**Equivalente no SQL:**  
- id_assinante (PK)  
- nome  
- celular  
- email (UNIQUE)

---

### **2. Classe: Plano.java → Tabela: Plano**
Define características do plano escolhido pelo assinante.

**Atributos no Java:**  
- idPlano  
- nome  
- valorBase  
- qtdFrutasPermitidas  
- qtdLegumesPermitidos  
- qtdVerdurasPermitidas  

**Equivalente no SQL:**  
- id_plano (PK)  
- nome  
- valor_base  
- qtd_frutas_permitidas  
- qtd_legumes_permitidos  
- qtd_verduras_permitidas  

---

### **3. Classe: Produto.java → Tabela: Produto**
Representa frutas, legumes e verduras disponíveis no catálogo.

**Atributos no Java:**  
- idProduto  
- nome  
- tipo (enum TipoProduto)  

**Equivalente no SQL:**  
- id_produto (PK)  
- nome  
- tipo_produto (ENUM)

---

### **4. Classe: Catalogo.java → Tabelas: Catalogo e Catalogo_Produto**
Reflete os produtos disponíveis em uma semana específica.

**Atributos no Java:**  
- idCatalogo  
- dataSemana  
- List<Produto>  

**Equivalente no SQL:**  
- Catalogo (id_catalogo, data_semana)  
- Catalogo_Produto (id_catalogo, id_produto) — tabela N:N

---

### **5. Classe: Cesta.java → Tabela: Cesta**
Cesta semanal montada pelo usuário.

**Atributos no Java:**  
- idCesta  
- dataSemana  
- List<ItemCesta>  

**Equivalente no SQL:**  
- id_cesta (PK)  
- data_semana  

---

### **6. Classe: ItemCesta.java → Tabela: Item_Cesta**
Item da cesta, associando produto + quantidade.

**Atributos no Java:**  
- produto  
- quantidade  

**Equivalente no SQL:**  
- id_cesta (FK)  
- id_produto (FK)  
- quantidade  

Relação:  
- 1 Cesta → N Itens  
- 1 Produto → N Itens  

---

### **7. Classe: Endereco.java → Tabela: Endereco**
Endereço usado na entrega.

**Atributos no Java:**  
- logradouro  
- numero  
- complemento  
- bairro  
- cidade  
- cep  

**Equivalente no SQL:**  
- id_endereco (PK)  
- logradouro  
- numero  
- complemento  
- bairro  
- cidade  
- cep  

---

### **8. Classe: Cartao.java → Tabela: Cartao**
Representa o cartão utilizado no pagamento.

**Atributos no Java:**  
- nomeImpresso  
- numeroMascarado  
- bandeira  
- validadeMes  
- validadeAno  

**Equivalente no SQL:**  
- id_cartao (PK)  
- nome_impresso  
- numero_mascarado  
- bandeira  
- validade_mes  
- validade_ano  
- id_assinante (FK)

---

### **9. Classe: Pagamento.java → Tabela: Pagamento**
Registra o pagamento da assinatura.

**Atributos no Java:**  
- idPagamento  
- valor  
- status  
- dataPagamento  
- Cartao cartao  

**Equivalente no SQL:**  
- id_pagamento (PK)  
- id_assinatura (FK)  
- id_cartao (FK)  
- valor  
- status (ENUM)  
- data_pagamento  

---

### **10. Classe: Assinatura.java → Tabela: Assinatura**
Elemento central do projeto, juntando tudo.

**Atributos no Java:**  
- assinante  
- plano  
- cesta  
- endereco  
- pagamento  
- entrega  
- protocolo  
- status  
- dataCriacao  

**Equivalente no SQL:**  
- id_assinatura (PK)  
- id_assinante (FK)  
- id_plano (FK)  
- id_cesta (FK)  
- id_endereco (FK)  
- protocolo  
- status  
- data_criacao  

---

### **11. Classe: Entrega.java → Tabela: Entrega**
Representa a entrega já agendada.

**Atributos no Java:**  
- dataPrevista  
- janelaHorario  
- status  

**Equivalente no SQL:**  
- id_entrega (PK)  
- id_assinatura (FK)  
- data_prevista  
- janela_horario  
- status  

---

## ✔ Conclusão
O modelo SQL reflete exatamente as classes e relações do código Java, garantindo:

- coerência entre código e banco  
- fácil integração ORM futura  
- boa manutenção e escalabilidade  

---

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


