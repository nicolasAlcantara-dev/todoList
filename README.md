# 📝 TodoList API com Spring Boot e Docker

Uma API simples de estudo para gerenciar tarefas (CRUD), desenvolvida com Spring Boot e Dockerizada para fácil deploy.

## 🚀 Tecnologias Utilizadas

- **Java 17** (LTS)
- **Spring Boot 3.5.0**
    - Spring Web (REST API)
    - Spring Data JPA (Banco de dados)
    - Lombok (Redução de boilerplate)
- **Banco de Dados**
    - PostgreSQL (Produção)
    - H2 (Desenvolvimento local)
- **Docker** (Containerização)
- **Docker Compose** (Orquestração)

## 📋 Funcionalidades

✔️ Criar, ler, atualizar e deletar tarefas  
✔️ Marcar tarefas como completas  
✔️ Buscar tarefas por status  
✔️ Validação de dados  
✔️ Pronta para deploy em containers

## 🛠️ Como Executar

### Pré-requisitos
- Docker e Docker Compose instalados
- JDK 17

### ▶️ Com Docker (Recomendado)
```bash
# 1. Clone o repositório
git clone https://github.com/seu-usuario/todolist-spring.git

# 2. Navegue até o diretório
cd todolist-spring

# 3. Inicie os containers
docker-compose up -d