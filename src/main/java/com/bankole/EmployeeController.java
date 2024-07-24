package com.bankole;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/employees")
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    @PostMapping
    public void addEmployees(@RequestBody NewEmployeeRequest request) {
        Employee employee = new Employee();
        employee.setName(request.name());
        employee.setAge(request.age());
        employee.setDepartment(request.department());
        employee.setPosition(request.position());
        employee.setSalary(request.salary());
        employeeRepository.save(employee);
    }

    @DeleteMapping("{employeeId}")
    public void deleteEmployee(@PathVariable("employeeId") Integer id){
        employeeRepository.deleteById(id);
    }

    @PutMapping("{employeeId}")
    public void updateEmployee(@RequestBody UpdateEmployeeRequest theRequest,
                               @PathVariable("employeeId") Integer id){
        Employee employee = new Employee();
        employee.setName(theRequest.name());
        employee.setAge(theRequest.age());
        employee.setDepartment(theRequest.department());
        employee.setPosition(theRequest.position());
        employee.setSalary(theRequest.salary());
        employeeRepository.save(employee);
    }
    @GetMapping("/searchByName")
    public List<Employee> searchByName(@RequestParam String name){
        return employeeRepository.findByName(name);
    }

    @GetMapping("/searchByDepartment")
    public List<Employee> searchByDepargment(@RequestParam String department) {
        return employeeRepository.findByDepartment(department);
    }


}
