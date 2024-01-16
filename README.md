# Employee Management System

This is a simple Employee Management System built using Spring Boot and MySQL.

## Getting Started

### Prerequisites

- Java 8 or higher
- MySQL
- Maven

### Setup

1. Clone the repository:

    ```bash
    git clone https://github.com/yourusername/employee-management.git
    ```

2. Configure MySQL database in `src/main/resources/application.properties`:

    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/Employee
    spring.datasource.username=root
    spring.datasource.password=root
    spring.jpa.show-sql=true
    spring.jpa.hibernate.ddl-auto=update
    ```

3. Run the application:

    ```bash
    mvn spring-boot:run
    ```

The application will be accessible at `http://localhost:8080`.

## API Endpoints

- **Create Employee:**

    ```http
    POST /api/employees
    ```

    Request Body:

    ```json
    {
      "name": "John Doe",
      "address": {
        "city": "Sample City"
      },
      "marks": {
        "marks": 85
      }
    }
    ```

- **Get All Employees:**

    ```http
    GET /api/employees
    ```

- **Get Employee by ID:**

    ```http
    GET /api/employees/{employeeId}
    ```

- **Update Employee:**

    ```http
    PUT /api/employees/{employeeId}
    ```

    Request Body:

    ```json
    {
      "name": "Updated Name",
      "address": {
        "city": "Updated City"
      },
      "marks": {
        "marks": 90
      }
    }
    ```

- **Delete Employee:**

    ```http
    DELETE /api/employees/{employeeId}
    ```

