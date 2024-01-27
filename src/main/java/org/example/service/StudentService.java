package org.example.service;

public interface StudentService {

    java.util.List<org.example.model.Employee> getAllEmployees();

    org.example.model.Employee getEmployeeById(Long id);

    org.example.model.Employee getEmployeeByName(String name);

    java.util.List<org.example.model.Employee> getEmployeesByCity(String city);

    org.example.model.Employee saveEmployee(org.example.model.Employee employee);

    org.example.model.Employee updateEmployee(Long id, org.example.model.Employee updatedEmployee);

    void deleteEmployee(Long id);
}
