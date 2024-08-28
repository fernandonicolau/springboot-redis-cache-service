# Spring Boot Redis Cache Service

## Descrição

Este projeto é um serviço em Spring Boot que utiliza Redis para cache de respostas de uma API. A API possui duas rotas principais:
- `/estados`: Recupera estados do banco de dados PostgreSQL.
- `/estados/cacheable`: Recupera estados do banco de dados PostgreSQL e armazena em cache no Redis por 10 segundos.

## Objetivo Principal

O objetivo do projeto é fornecer uma API que possa retornar informações sobre estados, com suporte a cache para melhorar o desempenho e reduzir a carga no banco de dados.

## Autor

Fernando Nicolau Freitas da Silva

## Requisitos

- **Docker**: Para executar o projeto em containers.
- **Apache Maven 3.9.9**: Para compilar o projeto.

**Verifique se o Docker e o Maven estão instalados:**

```bash
docker --version
mvn -version
```

## Instalação e Configuração do Ambiente

1. **Instale o Docker:**
   - [Instruções de instalação do Docker](https://docs.docker.com/engine/install/)

2. **Instale o Maven:**
   - [Baixe o Apache Maven](https://maven.apache.org/download.cgi)

## Compilação do Projeto

Para compilar o projeto, use o comando:

```bash
mvn clean package
```

Isso gerará um arquivo JAR no diretório `target`.

## Executando o Projeto Localmente

1. **Configure o arquivo `.env`**

   Crie um arquivo `.env` na raiz do projeto com os seguintes parâmetros:

   ```env
   POSTGRESS_URL=
   POSTGRESS_USERNAME=
   POSTGRESS_PASSWORD=
   REDIS_HOST=
   REDIS_PORT=
   REDIS_USERNAME=
   REDIS_PASSWORD=
   TTL=
   ```

   Onde `TTL` é o tempo de duração do cache em segundos.

2. **Suba o projeto usando Docker Compose**

   Para iniciar o projeto, execute:

   ```bash
   docker-compose up -d
   ```

   Para parar o projeto, use:

   ```bash
   docker-compose down
   ```

## Funcionalidades

- **Ping**: Verifica se o serviço está funcionando.
- **Buscar Estados**: Obtém uma lista de estados do banco de dados PostgreSQL.
- **Buscar Estados com Cache**: Obtém uma lista de estados do banco de dados e armazena a resposta em cache no Redis por 10 segundos.

## Configuração de Banco de Dados e Serviços Externos

Certifique-se de preencher o arquivo `.env` com as credenciais e configurações necessárias para o PostgreSQL e Redis.

## Gerenciamento de Variáveis de Ambiente e Configurações

As variáveis de ambiente são gerenciadas através do arquivo `.env`.

## Testes Automatizados

Para executar os testes automatizados, vá para o diretório do projeto e execute:

```bash
mvn test
```

## Estrutura de Diretórios

```
src
├── main
│   └── java
│       └── com
│           └── example
│               └── springboot_redis_cache_service
│                   ├── SpringBootRedisCacheServiceApplication.java
│                   ├── cache
│                   ├── config
│                   ├── controller
│                   ├── dto
│                   ├── mapper
│                   ├── model
│                   ├── repository
│                   └── service
```

## Arquitetura

O projeto segue o padrão **MVC (Model-View-Controller)**.
