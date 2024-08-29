# Spring Boot Redis Cache Service

## Descrição

Este projeto é um serviço baseado em Spring Boot que utiliza o Redis para cache de respostas de uma API. A API expõe duas rotas principais:

- **`/estados`**: Recupera estados do banco de dados PostgreSQL.
- **`/estados/cacheable`**: Recupera estados do banco de dados PostgreSQL e armazena a resposta em cache no Redis por 10 segundos.

## Objetivo Principal

O objetivo do projeto é fornecer uma API eficiente que retorna informações sobre estados, com suporte a cache para melhorar o desempenho e reduzir a carga no banco de dados.

## Autor

Fernando Nicolau Freitas da Silva

## Requisitos

- **Docker**: Necessário para executar o projeto em containers.

**Verifique se o Docker está instalado:**

```bash
docker --version
```

## Instalação e Configuração do Ambiente

1. **Instale o Docker:**
   - [Instruções de instalação do Docker](https://docs.docker.com/engine/install/)

## Executando o Projeto Localmente

1. **Configure o arquivo `.env`**

   Crie um arquivo `.env` na raiz do projeto com as seguintes variáveis de ambiente:

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

2. **Execute o projeto usando Docker**

   Para compilar e executar o projeto, use:

   ```bash
   docker-compose up
   ```

   Se você fizer modificações no Dockerfile, é recomendável usar o parâmetro --build para reconstruir as imagens antes de iniciar os containers.

   Para parar e remover os containers, use:

   ```bash
   docker-compose down
   ```

## Funcionalidades

- **Ping**: Verifica se o serviço está funcionando.
- **Buscar Estados**: Obtém uma lista de estados do banco de dados PostgreSQL.
- **Buscar Estados com Cache**: Obtém uma lista de estados do banco de dados e armazena a resposta em cache no Redis por um período configurável (10 segundos por padrão).

## Configuração de Banco de Dados e Serviços Externos

Certifique-se de preencher o arquivo `.env` com as credenciais e configurações necessárias para o PostgreSQL e Redis.

## Gerenciamento de Variáveis de Ambiente e Configurações

As variáveis de ambiente são gerenciadas através do arquivo `.env`. Certifique-se de que todas as variáveis necessárias estejam corretamente definidas.

## Testes Automatizados

Para executar os testes automatizados, execute o seguinte comando no diretório do projeto:

1. **Instale o Maven:**
   - Certifique-se de ter o Maven 3.9.9 ou superior instalado para executar os testes. [Instruções de instalação do Maven](https://maven.apache.org/install.html)

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

O projeto segue o padrão **MVC (Model-View-Controller)**, promovendo uma separação clara entre a lógica de negócios, a interface do usuário e a manipulação de dados.
