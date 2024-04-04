[English](README.md) | [Español](README.es.md)

[![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)](https://www.java.com/)
[![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)](https://maven.apache.org/)
[![Swagger](https://img.shields.io/badge/Swagger-85EA2D?style=for-the-badge&logo=swagger&logoColor=white)](https://swagger.io/)
[![Docker](https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white)](https://www.docker.com/)
[![nginx](https://img.shields.io/badge/nginx-009639?style=for-the-badge&logo=nginx&logoColor=white)](https://www.nginx.com/)

# Algafood Rest Api
## 📝 Descrição
Este projeto é uma API Rest nivel 3 na maturidade de Richardson desenvolvida durante o curso de Especialista Spring Rest da Algaworks. 
A API foi elaborada com base nos princípios do REST e possui documentação gerada pelo Swagger e autenticação via OAuth2.
É responsável por gerenciar restaurantes, cidades, estados, cozinhas, pedidos, formas de pagamento, usuários e grupos de permissões.

## 📜 Arquitetura
A seguir, é apresentado o diagrama de arquitetura do projeto:
![Arquitetura](src/main/resources/docs/projeto.jpg)

## ⚙️ Tecnologias
- Java 11
- Maven
- Spring Boot
- MySQL
- Flyway
- Docker

## 🚀 Execução
Para executar o projeto, é necessário ter o Docker e o Docker Compose instalados.
```bash
docker-compose up
```
Após a execução do comando, a aplicação estará disponível em http://localhost:8080.

## 📚 Documentação
A documentação da API foi gerada pelo Swagger e pode ser acessada em http://localhost:8080/swagger-ui.html.


