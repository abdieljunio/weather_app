# Documento de Especificação do Projeto

## 1. Introdução

O projeto propõe a integração com uma ou mais APIs externas utilizando o Spring WebClient. O foco será no consumo eficiente dessas APIs, no tratamento básico de erros e na exibição estruturada dos dados recebidos.

## 2. Backlog Inicial

### Épicos

#### 1. Consumo de APIs Externas
- **Objetivo:** Estabelecer uma conexão com a API externa e consumir seus endpoints para obter as informações necessárias.
- **Histórias de Usuário:**
  - Como usuário, quero que o sistema consulte a previsão do tempo para uma cidade específica ao informar seu nome.
- **Critérios de Aceitação:**
  1. Permitir entrada do nome da cidade no sistema.
  2. Realizar requisições à API de previsão do tempo.
  3. Retornar informações básicas sobre o clima.

## 3. Arquitetura Proposta

### Componentes Principais

1. **Frontend (Interface do Usuário):** Página HTML simples onde o usuário digita o nome de uma cidade para obter a previsão do tempo.
2. **Backend:**
   - **Controlador (Controller):** Recebe o pedido do usuário e encaminha para o serviço de previsão.
   - **Serviço (Service):** Faz a requisição para a API externa de clima e trata a resposta.
   - **Modelo (Model):** Estrutura que representa os dados de clima.
3. **API Externa:** Fornece dados de previsão do tempo.

## 4. Funcionalidades

1. **Consulta de Clima:** Permite que o usuário forneça o nome de uma cidade para buscar informações climáticas.
2. **Tratamento de Erros:** Mostra na tela um erro quando o usuário coloca uma cidade inexistente.

## 5. Tecnologias Utilizadas

1. **Spring Boot**
2. **WebClient**
3. **Thymeleaf**

## 6. Classes

1. **Clima:** Modelo principal que encapsula as informações sobre o clima de uma cidade.
2. **Location:** Armazena as informações sobre a localização geográfica da cidade.
3. **Current:** Armazena os dados relativos às condições climáticas atuais da cidade.
4. **Condition:** Contém as informações sobre a descrição e o ícone do clima atual.

## 7. Protótipo Básico

1. **Tela de resultados**
  ![Captura de tela](file:///C:/Users/abdie/Pictures/Screenshots/Captura%20de%20tela%202024-12-02%20234425.png)


3. **Tela de busca**
![Captura de tela](file:///C:/Users/abdie/Pictures/Screenshots/Captura%20de%20tela%202024-12-02%20234718.png)




## 8. Considerações Finais

Este projeto proporcionou um aprendizado significativo na integração de APIs externas utilizando o Spring WebClient.
