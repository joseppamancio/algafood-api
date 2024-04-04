[English](README.md) | [Português](README.pt.md)

[![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)](https://www.java.com/)
[![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)](https://maven.apache.org/)
[![Swagger](https://img.shields.io/badge/Swagger-85EA2D?style=for-the-badge&logo=swagger&logoColor=white)](https://swagger.io/)
[![Docker](https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white)](https://www.docker.com/)
[![nginx](https://img.shields.io/badge/nginx-009639?style=for-the-badge&logo=nginx&logoColor=white)](https://www.nginx.com/)

# Algafood Rest Api
## 📝 Descripción
Este proyecto es una API Rest nivel 3 en la madurez de Richardson desarrollada durante el curso de Especialista Spring Rest de Algaworks.
La API se diseñó basada en los principios de REST y cuenta con documentación generada por Swagger y autenticación a través de OAuth2.
Es responsable de gestionar restaurantes, ciudades, estados, cocinas, pedidos, formas de pago, usuarios y grupos de permisos.

## 📜 Arquitectura
A continuación, se presenta el diagrama de arquitectura del proyecto:
![Arquitectura](src/main/resources/docs/projeto.jpg)

## ⚙️ Tecnologías
- Java 11
- Maven
- Spring Boot
- MySQL
- Flyway
- Docker

## 🚀 Ejecución
Para ejecutar el proyecto, es necesario tener Docker y Docker Compose instalados.
```bash
docker-compose up
```

Después de ejecutar el comando, la aplicación estará disponible en http://localhost:8080.

## 📚 Documentación
La documentación de la API fue generada por Swagger y se puede acceder en http://localhost:8080/swagger-ui.html.
