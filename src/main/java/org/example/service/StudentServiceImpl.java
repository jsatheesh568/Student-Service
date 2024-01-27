package org.example.service;

@org.springframework.stereotype.Service
public class StudentServiceImpl implements StudentService {

    @org.springframework.beans.factory.annotation.Autowired
    private org.example.repository.EmployeeRepository employeeRepository;

    @Override
    public java.util.List<org.example.model.Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public org.example.model.Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new org.example.exception.NotFoundException("Employee not found with id: " + id));
    }

    @Override
    public org.example.model.Employee getEmployeeByName(String name) {
        return employeeRepository.findByName(name)
                .orElseThrow(() -> new org.example.exception.NotFoundException("Employee not found with name: " + name));
    }

    @Override
    public java.util.List<org.example.model.Employee> getEmployeesByCity(String city) {
        return employeeRepository.findByAddressCity(city);
    }

    @Override
    public org.example.model.Employee saveEmployee(org.example.model.Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public org.example.model.Employee updateEmployee(Long id, org.example.model.Employee updatedEmployee) {
        org.example.model.Employee existingEmployee = getEmployeeById(id);

        // Update only the fields you want to allow updating
        existingEmployee.setName(updatedEmployee.getName());
        existingEmployee.setAddress(updatedEmployee.getAddress());
        existingEmployee.setMarks(updatedEmployee.getMarks());

        return employeeRepository.save(existingEmployee);
    }

    @Override
    public void deleteEmployee(Long id) {
        org.example.model.Employee existingEmployee = getEmployeeById(id);
        employeeRepository.delete(existingEmployee);
    }
}