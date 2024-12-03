# **Documento de Especificação do Projeto**

# 1\. Introdução

**Consumo de APIs Externas com Spring WebClient**

O projeto propõe a integração com uma ou mais APIs externas utilizando o Spring WebClient. O foco será no consumo eficiente dessas APIs, no tratamento básico de erros e na exibição estruturada dos dados recebidos.

# 2\. Backlog Inicial

## **Épicos**

### **1\. Consumo de APIs Externas**

- **Objetivo:** Estabelecer uma conexão com a API externa e consumir seus endpoints para obter as informações necessárias.

#### **Histórias de Usuário:**

1. **Como usuário**, quero que o sistema consulte a previsão do tempo para uma cidade específica ao informar seu nome, para que eu possa saber as condições climáticas.
    1. Critérios de Aceitação:
        1. Permitir entrada do nome da cidade no sistema.
        2. Realizar requisições à API de previsão do tempo.
        3. Retornar informações básicas sobre o clima (ex.: temperatura, descrição do clima).

### **2\. Tratamento de Erros**

- **Objetivo:** Lidar com situações em que o usuário digita uma cidade inválida.

#### **Histórias de Usuário:**

1. **Como usuário**, quero receber uma mensagem clara quando digitar o nome de uma cidade inválida, para saber o que fazer.
    1. Critérios de Aceitação:
        1. Exibir mensagem de erro: "Cidade não encontrada. Por favor, verifique o nome digitado."

### **3\. Exibição dos Dados**

- **Objetivo:** Mostrar as informações climáticas básicas da cidade consultada.

#### **Histórias de Usuário:**

1. **Como usuário**, quero ver as informações climáticas básicas (como temperatura e descrição do clima), para entender rapidamente o tempo na cidade.
    1. Critérios de Aceitação:
        1. Exibir a temperatura da cidade consultada.
        2. Mostrar a descrição básica do clima (ex.: "Ensolarado", "Chuvoso").

# **4\. Guia de instalação**

Para configurar o ambiente de desenvolvimento e executar o projeto em **Windows 10 ou superior**, siga os passos abaixo:

## **1\. Configurar a IDE**

Recomendamos o **IntelliJ IDEA** ou qualquer IDE que suporte Java e Maven. Para configurar sua IDE:

Baixe o IntelliJ IDEA Community Edition ou Ultimate: <https://www.jetbrains.com/idea/download>.

Abra a IDE e crie um novo projeto Maven.

## **2\. Instalar o Java Development Kit (JDK)**

Certifique-se de que o **JDK 11** ou superior está instalado em sua máquina:

Faça o download do JDK no site oficial da Oracle ou use uma versão open-source, como o OpenJDK.

## **3\. Instalar o Maven**

Baixe o Apache Maven em: <https://maven.apache.org/download.cgi>.

Extraia o conteúdo do arquivo baixado e configure a variável de ambiente MAVEN_HOME para o diretório onde o Maven foi extraído.

Adicione o diretório bin do Maven ao seu PATH.

## **4\. Baixar Dependências**

No arquivo pom.xml do seu projeto, adicione as seguintes dependências para configurar o ambiente com as bibliotecas necessárias:

### **1\. Spring Boot Starter Web**

Utilizado para criar uma aplicação web com suporte a RESTful APIs. Ele inclui o servidor embutido (Tomcat por padrão) e suporte a controladores web.

### **2\. Spring Boot DevTools**

Utilizado para facilitar o desenvolvimento, com funcionalidades como recarga automática da aplicação, melhor desempenho e depuração.

### **3\. Lombok**

Uma ferramenta que facilita o código Java, evitando a necessidade de escrever métodos repetitivos como getters, setters, toString(), equals(), entre outros.

### **4\. Spring Boot Starter Test**

Inclui as dependências necessárias para realizar testes na aplicação, como JUnit, Mockito, e outras ferramentas de teste.

### **5\. Spring Boot Starter WebFlux**

Suporta programação reativa e é usado para criar aplicações reativas com Spring, incluindo APIs baseadas em WebFlux.

### **6\. Thymeleaf**

Framework de templates usado para criar interfaces web dinâmicas, sendo amplamente utilizado no Spring Boot para renderizar páginas HTML.

## **5\. Compilar o Projeto e Acessar Aplicação**

Após configurar o Maven e o projeto, compile o projeto.

Após rodar o projeto, abra o navegador e acesse a URL: https://localhost:8080


# 5\. Arquitetura Proposta

A arquitetura do sistema é simples e tem como objetivo garantir uma boa estrutura para o consumo da API externa e a exibição dos dados de forma eficiente.

#### **Componentes Principais**

- **Frontend** (Interface do Usuário):
  - Página HTML simples onde o usuário digita o nome de uma cidade para obter a previsão do tempo.
  - O frontend utiliza **Thymeleaf** para renderizar o conteúdo dinâmico, mostrando os dados de clima que serão recebidos da API externa.
- **Backend**:
  - **Controlador (Controller)**: Recebe o pedido do usuário (cidade) e encaminha para o serviço de previsão.
  - **Serviço (Service)**: Faz a requisição para a API externa de clima e trata a resposta, enviando de volta para o controlador.
  - **Modelo (Model)**: Estrutura que representa os dados de clima, como temperatura, umidade, etc.
- **API Externa**:
  - O sistema faz uma chamada para uma API externa para obter os dados de previsão do tempo de acordo com a cidade fornecida.

#### **Fluxo de Dados**

- O usuário entra na página inicial e digita o nome da cidade.
- O **Controller** pega esse nome de cidade e faz uma requisição para o **Service**, que por sua vez chama a **API Externa**.
- A **API Externa** retorna os dados de clima, que são processados e enviados para o **Controller**.
- O **Controller** repassa os dados para o **Frontend**, onde o **Thymeleaf** exibe a previsão do tempo para o usuário.

#### **Tecnologias Utilizadas**

- **Spring Boot**: Framework para estruturar a aplicação.
- **WebClient**: Usado para fazer as requisições HTTP à API externa.
- **Thymeleaf**: Para renderizar as páginas HTML dinâmicas no frontend.

# 6\. Funcionalidades

#### **1\. Consulta de Clima**

Permite que o usuário forneça o nome de uma cidade para buscar informações climáticas.

A funcionalidade está implementada nas seguintes partes:

**Controlador (PrevisaoController)**

Responsável por gerenciar as requisições recebidas e enviar os dados para o frontend.

**Trecho do código:**

![Controller](file:///C:/Users/abdie/OneDrive/Documentos/Mat%C3%A9rias/POO/imgs_readme/controller.png)

**Descrição:** O controlador recebe o nome da cidade através do formulário e usa o serviço para buscar os dados na API externa.

**Serviço (PrevisaoService)**

Realiza a comunicação direta com a API externa.

**Trecho do código:**

![Service](file:///C:/Users/abdie/OneDrive/Documentos/Mat%C3%A9rias/POO/imgs_readme/service.png)


**Descrição:** O serviço envia uma solicitação à API, processa a resposta e retorna os dados organizados ao controlador.

# 7.Classes

1. **Classe: Clima**

Descrição: A classe Clima é o modelo principal que encapsula as informações sobre o clima de uma cidade, incluindo os dados de localização e as condições climáticas atuais.

Campos:

- location (Location): Contém as informações de localização (cidade, região, país, etc.).
- current (Current): Contém as informações do clima atual (temperatura, umidade, vento, etc.).

1. **Classe: Location**

Descrição:

A classe Location armazena as informações sobre a localização geográfica da cidade para a qual os dados climáticos são fornecidos.

Campos:

- name (String): Nome da cidade.
- region (String): Região ou estado da cidade.
- country (String): País da cidade.
- lat (double): Latitude da cidade.
- lon (double): Longitude da cidade.
- tz_id (String): Identificador do fuso horário da cidade.
- localtime (String): Hora local na cidade.

1. **Classe: Current**

Descrição:

A classe Current armazena os dados relativos às condições climáticas atuais da cidade, como temperatura, umidade e velocidade do vento.

Campos:

- temp_c (double): Temperatura atual em graus Celsius.
- temp_f (double): Temperatura atual em graus Fahrenheit.
- humidity (double): Umidade relativa do ar (em %).
- wind_mph (double): Velocidade do vento em milhas por hora (mph).
- condition (Condition): Condição climática atual (texto e código do clima).

1. **Classe: Condition**

Descrição:

A classe Condition contém as informações sobre a descrição e o ícone do clima atual.

- Campos:
- text (String): Descrição textual das condições climáticas (ex: "Clear", "Overcast").
- icon (String): URL do ícone representando as condições climáticas.
- code (int): Código numérico associado ao tipo de clima (usado pela API para identificar condições específicas, como céu limpo, nublado, etc.).

#### **Tratamento de Erros**

Mostra na tela um erro quando o usuário coloca uma cidade inexistente.

**Trecho do código:**
![Erro](file:///C:/Users/abdie/OneDrive/Documentos/Mat%C3%A9rias/POO/imgs_readme/erro.png)


**Descrição:** O tratamento de erro implementado ocorre quando a cidade informada não é encontrada pela API. O sistema captura a exceção no controlador e exibe a mensagem: “Não foi possível localizar a cidade informada, digite uma cidade correta.”

**Frontend (HTML)**

Interface simples onde o usuário insere o nome da cidade e visualiza os resultados.

**Trecho do código:**

![Index](file:///C:/Users/abdie/OneDrive/Documentos/Mat%C3%A9rias/POO/imgs_readme/index.png)


**Descrição:** Exibe o formulário de consulta e os resultados obtidos.

# 8\. Protótipo Básico

**Protótipo básico da estrutura:**

![Protótipo](file:///C:/Users/abdie/OneDrive/Documentos/Mat%C3%A9rias/POO/imgs_readme/prot%C3%B3tipo.png)


**Telas:**

![Captura de tela 2024-12-02 234425](file:///C:/Users/abdie/OneDrive/Documentos/Mat%C3%A9rias/POO/imgs_readme/Captura%20de%20tela%202024-12-02%20234425.png)
**Descrição:** Tela de busca.

![Captura de tela 2024-12-02 234718](file:///C:/Users/abdie/OneDrive/Documentos/Mat%C3%A9rias/POO/imgs_readme/Captura%20de%20tela%202024-12-02%20234718.png)

**Descrição:** Tela de resultados.

# 8\. Considerações Finais

Este projeto proporcionou um aprendizado significativo na integração de APIs externas utilizando o Spring WebClient, permitindo a criação de uma aplicação eficiente e reativa. O desenvolvimento das camadas da aplicação, desde o backend até a renderização no frontend com Thymeleaf, foi um desafio que contribuiu para a compreensão da importância de uma comunicação clara entre as partes do sistema. A configuração do ambiente e a manipulação de erros também foram pontos cruciais para garantir uma boa experiência ao usuário. Apesar das dificuldades enfrentadas, como a integração da API e a configuração do Maven, o resultado final foi uma aplicação funcional que trouxe novos conhecimentos e preparou a equipe para futuros desafios no desenvolvimento de sistemas dinâmicos e reativos.
