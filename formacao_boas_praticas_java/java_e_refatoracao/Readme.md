# Adopet Console — Refatoração e Boas Práticas

Este repositório contém uma aplicação de console para gerenciamento de abrigos e pets, organizada e refatorada com foco em boas práticas de código. A estrutura foi aprimorada para facilitar manutenção, testes e extensibilidade, utilizando padrões de projeto e recursos modernos da linguagem.

Este trabalho foi baseado nas videoaulas do curso da Alura:
- Java e refatoração: melhorando códigos com boas práticas — https://cursos.alura.com.br/course/java-refatoracao-melhorando-codigos-boas-praticas

## O que foi feito
- Organização do código por responsabilidades (commands, services, domain)
- Aplicação do padrão de projeto Command para orquestrar ações do console
- Simplificação e clareza na leitura de código, extraindo métodos e reduzindo acoplamento
- Inclusão/apoio a testes de unidade com JUnit e Mockito
- Utilização de recursos modernos do Java, como pattern matching em `switch` (conforme abordado no curso)

## Ementa principal do curso (base deste projeto)
- Refatore código complexo com boas práticas de programação
- Estruture métodos e classes de modo eficaz
- Aprenda a utilizar o padrão de projeto Command
- Saiba como utilizar o pattern matching of switch do Java 15
- Conduza testes de unidade com jUnit e Mockito

## Como executar (resumo)
- Requisitos: Java 17+ e Maven
- Compilar: `mvn clean package`
- Executar (exemplo): `java -jar target/*.jar` ou via classe principal `br.com.alura.service.AdopetConsoleApplication`

