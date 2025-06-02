# BookStore REST API

A Spring Boot REST API for managing a bookstore.

## Features

- CRUD operations for books
- Swagger UI documentation
- H2 in-memory database
- Docker support

## Prerequisites

- Java 17
- Maven
- Docker (optional)

## Getting Started

### Running Locally

1. Clone the repository:
```bash
git clone https://github.com/sukaimi/project-book-store.git
cd project-book-store
```

2. Build the project:
```bash
mvn clean install
```

3. Run the application:
```bash
mvn spring-boot:run
```

### Using Docker

1. Build the Docker image:
```bash
docker build -t bookstore-api .
```

2. Run the container:
```bash
docker run -p 8080:8080 bookstore-api
```

## API Documentation

Once the application is running, you can access:
- Swagger UI: http://localhost:8080/swagger-ui.html
- H2 Console: http://localhost:8080/h2-console
  - JDBC URL: jdbc:h2:mem:bookstoredb
  - Username: sa
  - Password: password

## API Endpoints

- GET /api/books - Get all books
- GET /api/books/{id} - Get a book by ID
- POST /api/books - Create a new book
- PUT /api/books/{id} - Update a book
- DELETE /api/books/{id} - Delete a book

## Testing the API

You can test the API using Swagger UI or any REST client like Postman. Here's a sample book JSON:

```json
{
    "title": "The Great Gatsby",
    "author": "F. Scott Fitzgerald",
    "isbn": "978-0743273565",
    "price": 9.99,
    "quantity": 10
}
``` 