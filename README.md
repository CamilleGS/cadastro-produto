`note: There is a English version of this README bellow`

# 🛒 Cadastro de Produtos - API Spring Boot

API REST simples para cadastro de produtos, feita com Spring Boot, JPA e H2.

## 🚀 Tecnologias
- Java 17+
- Spring Boot
- Spring Data JPA
- H2 Database
- Lombok

## 🔗 Endpoints

- `POST /produtos` – Cadastra produto  
- `GET /produtos?id=1` – Busca produto por ID  
- `GET /produtos/todos` – Lista todos  
- `PUT /produtos?id=1` – Atualiza por ID  
- `DELETE /produtos?id=1` – Deleta por ID  

## ⚠️ Segurança
Adicione `application.properties` no `.gitignore` para evitar subir dados sensíveis.

## English ---------------------------------->
# 🛒 Product Registration API

A simple Spring Boot application to register, update, list, and delete products.

## 🚀 Technologies
- Java 17
- Spring Boot 3
- Spring Data JPA
- H2 Database

## 🔗 Endpoints

- `POST /produtos` – Register 
- `GET /produtos?id=1` – find products  
- `GET /produtos/todos` – List 
- `PUT /produtos?id=1` – update by ID  
- `DELETE /produtos?id=1` – Delete by ID  

## ⚠️ Security
Add application.properties to .gitignore to prevent uploading sensitive data.
