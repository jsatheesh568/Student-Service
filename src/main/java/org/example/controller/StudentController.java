package org.example.controller;

@org.springframework.web.bind.annotation.RestController
@org.springframework.web.bind.annotation.RequestMapping("/api/students")
@io.swagger.annotations.Api(tags = "Student Management")
public class StudentController {

    @org.springframework.beans.factory.annotation.Autowired
    private org.example.service.EmployeeService employeeService;

    @org.springframework.web.bind.annotation.GetMapping
    @io.swagger.annotations.ApiOperation("Get all students")
    public org.springframework.http.ResponseEntity<java.util.List<org.example.model.Employee>> getAllEmployees() {
        java.util.List<org.example.model.Employee> employees = employeeService.getAllEmployees();
        return new org.springframework.http.ResponseEntity<>(employees, org.springframework.http.HttpStatus.OK);
    }

    @org.springframework.web.bind.annotation.GetMapping("/{id}")
    @io.swagger.annotations.ApiOperation("Get Student by ID")
    public org.springframework.http.ResponseEntity<org.example.model.Employee> getEmployeeById(@org.springframework.web.bind.annotation.PathVariable Long id) {
        org.example.model.Employee employee = employeeService.getEmployeeById(id);
        return new org.springframework.http.ResponseEntity<>(employee, org.springframework.http.HttpStatus.OK);
    }

    @org.springframework.web.bind.annotation.GetMapping("/name/{name}")
    @io.swagger.annotations.ApiOperation("Get Student by name")
    public org.springframework.http.ResponseEntity<org.example.model.Employee> getEmployeeByName(@org.springframework.web.bind.annotation.PathVariable String name) {
        org.example.model.Employee employee = employeeService.getEmployeeByName(name);
        return new org.springframework.http.ResponseEntity<>(employee, org.springframework.http.HttpStatus.OK);
    }

    @org.springframework.web.bind.annotation.GetMapping("/city/{city}")
    @io.swagger.annotations.ApiOperation("Get Student by city")
    public org.springframework.http.ResponseEntity<java.util.List<org.example.model.Employee>> getEmployeesByCity(@org.springframework.web.bind.annotation.PathVariable String city) {
        java.util.List<org.example.model.Employee> employees = employeeService.getEmployeesByCity(city);
        return new org.springframework.http.ResponseEntity<>(employees, org.springframework.http.HttpStatus.OK);
    }

    @org.springframework.web.bind.annotation.PostMapping
    @io.swagger.annotations.ApiOperation("Create a new Student")
    public org.springframework.http.ResponseEntity<org.example.model.Employee> createEmployee(@org.springframework.web.bind.annotation.RequestBody org.example.model.Employee employee) {
        org.example.model.Employee createdEmployee = employeeService.saveEmployee(employee);
        return new org.springframework.http.ResponseEntity<>(createdEmployee, org.springframework.http.HttpStatus.CREATED);
    }

    @org.springframework.web.bind.annotation.PutMapping("/{id}")
    @io.swagger.annotations.ApiOperation("Update Student by ID")
    public org.springframework.http.ResponseEntity<org.example.model.Employee> updateEmployee(@org.springframework.web.bind.annotation.PathVariable Long id, @org.springframework.web.bind.annotation.RequestBody org.example.model.Employee updatedEmployee) {
        org.example.model.Employee updated = employeeService.updateEmployee(id, updatedEmployee);
        return new org.springframework.http.ResponseEntity<>(updated, org.springframework.http.HttpStatus.OK);
    }

    @org.springframework.web.bind.annotation.DeleteMapping("/{id}")
    @io.swagger.annotations.ApiOperation("Delete Student by ID")
    public org.springframework.http.ResponseEntity<Void> deleteEmployee(@org.springframework.web.bind.annotation.PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return new org.springframework.http.ResponseEntity<>(org.springframework.http.HttpStatus.NO_CONTENT);
    }
}