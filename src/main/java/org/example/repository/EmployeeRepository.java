package org.example.repository;

public interface EmployeeRepository extends org.springframework.data.jpa.repository.JpaRepository<org.example.model.Employee, Long> {
    java.util.Optional<org.example.model.Employee> findByName(String name);

    java.util.List<org.example.model.Employee> findByAddressCity(String city);
}