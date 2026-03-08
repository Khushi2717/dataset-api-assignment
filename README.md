# Dataset API Assignment

This project implements a backend REST API using Spring Boot that allows:

1. Inserting records into a dataset
2. Querying dataset records
3. Grouping records by a field
4. Sorting records by a field

## Tech Stack
- Java
- Spring Boot
- Maven
- H2 Database

## How to Run the Project

1. Clone the repository
2. Navigate to the project folder
3. Run the following command:

./mvnw spring-boot:run

4. The server will start at:

http://localhost:8080

## API Examples

### Insert Record
POST /api/dataset/employees/record

Example Request

POST /api/dataset/employees/record

{
  "name": "Ravi",
  "age": 22,
  "department": "IT"
}

Example Response

{
  "id": 1,
  "datasetName": "employees",
  "name": "Ravi",
  "age": 22,
  "department": "IT"
}

### Group By Department
GET /api/dataset/employees/query?groupBy=department

### Sort By Age
GET /api/dataset/employees/query?sortBy=age

Project Structure

```
src/main/java
 ├── controller
 │    └── DatasetController.java
 ├── service
 │    └── DatasetService.java
 ├── repository
 │    └── DatasetRepository.java
 └── model
      └── DatasetRecord.java
```
